package week1.day1.day2.assignmet_2;



public class SavingsAccount extends Account {
    private final double interestRate = 5; // 5% interest rate
    private int time; // Time in years

    // Constructor
    public SavingsAccount(String name, int accountNumber, double accountBalance, int time) {
        super(name, accountNumber, accountBalance);
        this.time = time;
    }

    // Check balance including interest
    @Override
    public void checkBalance() {
        double interest = (accountBalance * interestRate * time) / 100;
        double totalBalance = accountBalance + interest;
        System.out.println("Total balance after interest: " + totalBalance);
    }

    // Withdraw method
    @Override
    public void withdraw(double amount) {
        double interest = (accountBalance * interestRate * time) / 100;
        double totalBalance = accountBalance + interest;

        if (amount > 0 && totalBalance >= amount) {
            totalBalance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + totalBalance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}
