package day2.assignment4;


import java.util.ArrayList;

// Abstract base class for Employee
abstract class Employee {
    private String name;
    private int employeeID;

    public Employee(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    // Abstract method to calculate weekly salary
    public abstract double calculateWeeklySalary();

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }
}

// SalariedEmployee class
class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String name, int employeeID, double weeklySalary) {
        super(name, employeeID);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculateWeeklySalary() {
        return weeklySalary;
    }

    public void increaseSalary(double percentage) {
        weeklySalary += (weeklySalary * percentage / 100);
    }
}

// HourlyEmployee class
class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(String name, int employeeID, double hourlyRate, double hoursWorked) {
        super(name, employeeID);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    public void increaseHourlyRate(double percentage) {
        hourlyRate += (hourlyRate * percentage / 100);
    }
}

// CommissionEmployee class
class CommissionEmployee extends Employee {
    private double sales;
    private double commissionPercentage;

    public CommissionEmployee(String name, int employeeID, double sales, double commissionPercentage) {
        super(name, employeeID);
        this.sales = sales;
        this.commissionPercentage = commissionPercentage;
    }

    @Override
    public double calculateWeeklySalary() {
        return (sales * commissionPercentage / 100);
    }

    public void increaseCommission(double percentage) {
        commissionPercentage += percentage;
    }
}

// Main class
class EmployeeRecords {
    private ArrayList<Employee> employees;

    public EmployeeRecords() {
        employees = new ArrayList<>();
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Get weekly salary of all employees
    public void displayWeeklySalaries() {
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getName() + ", Weekly Salary: " + employee.calculateWeeklySalary());
        }
    }

    // Increase salary of a specific type of employee
    public void increaseSalaryByType(Class<?> employeeType, double percentage) {
        for (Employee employee : employees) {
            if (employeeType.isInstance(employee)) {
                if (employee instanceof SalariedEmployee) {
                    ((SalariedEmployee) employee).increaseSalary(percentage);
                } else if (employee instanceof HourlyEmployee) {
                    ((HourlyEmployee) employee).increaseHourlyRate(percentage);
                } else if (employee instanceof CommissionEmployee) {
                    ((CommissionEmployee) employee).increaseCommission(percentage);
                }
            }
        }
    }

    public static void main(String[] args) {
        EmployeeRecords company = new EmployeeRecords();

        // Adding employees
        company.addEmployee(new SalariedEmployee("Alice", 1, 1000));
        company.addEmployee(new HourlyEmployee("Bob", 2, 20, 40));
        company.addEmployee(new CommissionEmployee("Charlie", 3, 5000, 10));

        // Display weekly salaries
        System.out.println("Weekly Salaries Before Increase:");
        company.displayWeeklySalaries();

        // Increase salary by type
        company.increaseSalaryByType(SalariedEmployee.class, 10); // Increase salaried employees by 10%
        company.increaseSalaryByType(HourlyEmployee.class, 5);    // Increase hourly rate by 5%
        company.increaseSalaryByType(CommissionEmployee.class, 2); // Increase commission rate by 2%

        // Display updated weekly salaries
        System.out.println("\nWeekly Salaries After Increase:");
        company.displayWeeklySalaries();
    }
}
