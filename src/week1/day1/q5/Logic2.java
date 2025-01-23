package week1.day1.q5;

public class Logic2 {

    // Method to return the number of days in a given month and year
    public int noOfDays(int month, int year) {
        int arr[] = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Check for February in a leap year
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        // Return the number of days for the given month
        if (month >= 1 && month <= 12) {
            return arr[month];
        } else {
            return -1; // Invalid month
        }
    }

    // Static method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0; // Divisible by 400 means leap year
            } else {
                return true; // Divisible by 4 but not 100
            }
        } else {
            return false; // Not divisible by 4
        }
    }

    // Method to find the next date
    public String findNextDate(int day, int month, int year) {
        int daysInMonth = noOfDays(month, year);

        // Validate input date
        if (daysInMonth == -1 || day < 1 || day > daysInMonth) {
            return "Invalid date!";
        }

        // Increment the day
        day++;

        // Check if we need to move to the next month
        if (day > daysInMonth) {
            day = 1;
            month++;

            // Check if we need to move to the next year
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        // Return the next date as a string
        return day + "/" + month + "/" + year;
    }

    public static void main(String[] args) {
        Logic2 logic = new Logic2();

        // Example usage
        int day = 28;  // Input day
        int month = 2; // Input month
        int year = 2024; // Input year

        String nextDate = logic.findNextDate(day, month, year);
        System.out.println("Next date: " + nextDate);
    }
}
