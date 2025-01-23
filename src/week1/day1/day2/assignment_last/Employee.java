package week1.day1.day2.assignment_last;

class Employee implements Payable {
    private String name;
    private int id;
    private double salary;

    // Constructor to initialize all fields
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Overriding the getPayment method from Payable interface
    @Override
    public void getPayment() {
        System.out.println("Employee Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

