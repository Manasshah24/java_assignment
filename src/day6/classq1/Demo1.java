package day6.classq1;


// Shared Account classclass Account {
class Account1 {
    private int balance;

    public Account1(int initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized deposit method
    public synchronized void deposit(int amount) {
        int temp = balance; // Read balance
        temp += amount;     // Update balance locally
        try {
            Thread.sleep(100); // Simulate processing delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = temp;     // Write updated balance
        System.out.println("Deposited " + amount + ". Current balance: " + balance);
    }

    // Synchronized withdraw method
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            int temp = balance; // Read balance
            temp -= amount;     // Update balance locally
            try {
                Thread.sleep(100); // Simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = temp;     // Write updated balance
            System.out.println("Withdrew " + amount + ". Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal!");
        }
    }

    public int getBalance() {
        return balance;
    }
}

// Husband class
class Husband1 extends Thread {
    private Account1 account;

    public Husband1(Account1 account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(1000); // Deposit 1000 each time
        }
    }
}

// Wife class
class Wife1 extends Thread {
    private Account1 account;

    public Wife1(Account1 account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(1000); // Withdraw 1000 each time
        }
    }
}

// Demo class
public class Demo1 {
    public static void main(String[] args) {
        Account1 account = new Account1(1000); // Start with 1000 in the account

        Husband1 husband = new Husband1(account);
        Wife1 wife = new Wife1(account);

        husband.start();
        wife.start();

        try {
            husband.join(); // Wait for husband's thread to finish
            wife.join();    // Wait for wife's thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance in account: " + account.getBalance());
    }
}

/*
Why Synchronization Affects Multithreading
Concurrency is Reduced:

When a thread enters a synchronized method, it locks the shared resource (Account in this case). Other threads attempting to access any synchronized method on the same object are blocked until the lock is released.
As a result, threads are no longer operating truly concurrently when accessing synchronized methods.
 */

