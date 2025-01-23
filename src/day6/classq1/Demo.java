package day6.classq1;



// Shared Account class
class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        int temp = balance; // Read balance
        temp += amount;     // Update balance locally
        try {
            Thread.sleep(100); // Simulate processing delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = temp;     // Write updated balance
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            int temp = balance; // Read balance
            temp -= amount;     // Update balance locally
            try {
                Thread.sleep(100); // Simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = temp;     // Write updated balance
        } else {
            System.out.println("Insufficient balance for withdrawal!");
        }
    }

    public int getBalance() {
        return balance;
    }
}

// Husband class
class Husband extends Thread {
    private Account1 account;

    public Husband(Account1 account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(1000);
            System.out.println("Husband deposited 1000. Current balance: " + account.getBalance());
        }
    }
}

// Wife class
class Wife extends Thread {
    private Account1 account;

    public Wife(Account1 account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(1000);
            System.out.println("Wife withdrew 1000. Current balance: " + account.getBalance());
        }
    }
}

// Demo class
public class Demo {
    public static void main(String[] args) {
        Account1 account = new Account1(1000); // Start with 1000 in the account

        Husband husband = new Husband(account);
        Wife wife = new Wife(account);

        husband.start();
        wife.start();

        try {
            husband.join();
            wife.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance in account: " + account.getBalance());
    }
}



/*
In the Above Code
1. The Shared Resource:
The Account object (balance field) is shared between the Husband and Wife threads.
Both threads access and modify the balance without any synchronization.
2. How the Race Condition Happens:
When husband deposits money:
It reads the current balance, adds an amount locally, and writes back the new balance.
When wife withdraws money:
It reads the current balance, subtracts an amount locally, and writes back the new balance.
Race Condition:
If the Husband and Wife threads execute at the same time, they might read the same balance before either thread has updated it.
This results in overwriting each other’s changes, producing incorrect results.
Example of a Race Condition
Initial balance: 1000
Both threads access the balance at the same time:
Husband reads the balance (1000), calculates 1000 + 1000 = 2000 (but hasn’t updated it yet).
Wife reads the same balance (1000), calculates 1000 - 1000 = 0 (but hasn’t updated it yet).
Threads write back the balance:
Husband writes 2000 to the balance.
Wife writes 0 to the balance (overwriting the husband's update).
The final balance becomes 0 instead of 1000 because the operations were not synchronized.

The Role of Thread.sleep()
Thread.sleep() introduces a deliberate delay in thread execution, simulating real-world scenarios where threads take time to perform operations. In this code, it plays a crucial role in exposing the race condition:

How it Affects Timing:

When a thread performs an operation (e.g., read-modify-write), the delay ensures that the other thread has a chance to execute during that time.
This increases the likelihood of overlapping operations, making the race condition easier to observe.
In the Code:

Deposit Operation (Husband):

java
Copy code
int temp = balance;  // Read balance (e.g., 1000)
Thread.sleep(100);   // Delay (wife might access balance here)
balance = temp + amount;  // Update balance (e.g., 2000)
Withdraw Operation (Wife):

java
Copy code
int temp = balance;  // Read balance (e.g., 1000)
Thread.sleep(100);   // Delay (husband might access balance here)
balance = temp - amount;  // Update balance (e.g., 0)
Because of the delay, both threads are more likely to read the same initial balance before either one updates it.

Why This Happens Without Thread.sleep()
Without the delay:

The thread scheduler may allow one thread (e.g., husband) to finish its operation entirely before switching to the other thread.
This reduces the chances of threads overlapping during critical operations, making the race condition less apparent.
How to Fix the Race Condition
To prevent the race condition, you can use synchronization to ensure that only one thread can access the critical section (code block modifying balance) at a time.


The synchronized keyword ensures that only one thread can execute these methods at a time, eliminating the race condition.
Summary
Race Condition:
Occurs when threads access and modify shared resources without synchronization.
Final results depend on the timing of thread execution, leading to incorrect results.
Role of Thread.sleep():
Simulates real-world delays in thread execution.
Increases the chances of overlapping operations, making the race condition more noticeable.
Fix:
Use synchronization to enforce mutually exclusive access to critical sections of the code.
 */
