package week1.day1.day2.assignmet_2;



public class Main {
    public static void main(String[] args) {
        // Create a Savings Account
        SavingsAccount savings = new SavingsAccount("Alice", 12345, 1000, 2);
        System.out.println("Savings Account Details:");
        System.out.println("Name: " + savings.getName() + ", Account Number: " + savings.getAccountNumber());
        savings.deposit(500); // Deposit $500
        savings.checkBalance(); // Check balance including interest
        savings.withdraw(1200); // Try to withdraw $1200
        System.out.println();

        // Create a Current Account
        CurrentAccount current = new CurrentAccount("Bob", 54321, 200);
        System.out.println("Current Account Details:");
        System.out.println("Name: " + current.getName() + ", Account Number: " + current.getAccountNumber());
        current.deposit(300); // Deposit $300
        current.checkBalance(); // Check balance with overdraft
        current.withdraw(1300); // Try to withdraw $1300
    }
}

