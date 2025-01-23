package day2.assignmet_2;


public abstract class Account {
    private String name;
    private int accountNumber;
    protected double accountBalance;

    // Constructor
    public Account(String name, int accountNumber, double accountBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // Deposit method (common for all accounts)
    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Abstract methods to be implemented by child classes
    public abstract void withdraw(double amount);
    public abstract void checkBalance();
}
