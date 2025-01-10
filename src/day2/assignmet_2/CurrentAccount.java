package day2.assignmet_2;



public class CurrentAccount extends Account {
    private final int tradeLicenseNumber;
    private final double overdraftLimit = 1000; // Overdraft allowed

    // Constructor
    public CurrentAccount(String name, int accountNumber, double accountBalance) {
        super(name, accountNumber, accountBalance);
        this.tradeLicenseNumber = 100; // Default trade license number
    }

    // Check balance including overdraft
    @Override
    public void checkBalance() {
        double availableBalance = accountBalance + overdraftLimit;
        System.out.println("Available balance: " + availableBalance);
    }

    // Withdraw method
    @Override
    public void withdraw(double amount) {
        double availableBalance = accountBalance + overdraftLimit;

        if (amount > 0 && availableBalance >= amount) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + accountBalance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}
