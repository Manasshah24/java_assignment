package week1.day1.day3.q4;

// Custom Exception for handling insufficient book copies
public class NotSufficientBookException extends Exception {
    public NotSufficientBookException(String message) {
        super(message); // Pass the custom error message to the parent Exception class
    }
}
