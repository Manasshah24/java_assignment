package day6.assiq2;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(10000); // Initial balance

        // Create Bank and Company tasks
        Bank bank = new Bank(account);
        Company company = new Company(account);

        // Create threads for Bank and Company
        Thread bankThread = new Thread(bank, "Bank");
        Thread companyThread = new Thread(company, "Company");

        // Start threads
        bankThread.start();
        companyThread.start();

        // Wait for threads to complete
        try {
            bankThread.join();
            companyThread.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        // Final balance
        System.out.println("Final Balance: " + account.getBalance());
    }
}
