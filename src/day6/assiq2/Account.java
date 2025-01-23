package day6.assiq2;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to add amount
    public synchronized void addAmount(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", Balance: " + balance);
    }

    // Synchronized method to subtract amount
    public synchronized void subtractAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance for withdrawal.");
        }
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}
