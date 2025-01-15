package day3.q4;

import java.io.*;
import java.util.LinkedList;

public class BookApp {
    private LinkedList<Book> books = new LinkedList<>();

    // Method to load books from file
    public void loadBooksFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(":");
                int id = Integer.parseInt(details[0]);
                String isbn = details[1];
                String title = details[2];
                String author = details[3];
                double price = Double.parseDouble(details[4]);
                int noOfCopies = 10; // Default noOfCopies for all books
                books.add(new Book(id, isbn, title, author, price, noOfCopies));
            }
            System.out.println("Books loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }

    // Method to search for a book by ID
    public Book searchBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
        return null;
    }

    // Method to sell a book
    public void sellBook(String isbn, int noOfCopies) throws NotSufficientBookException {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.getNoOfCopies() >= noOfCopies) {
                    book.setNoOfCopies(book.getNoOfCopies() - noOfCopies);
                    System.out.println("Sold " + noOfCopies + " copies of book: " + book.getTitle());
                } else {
                    throw new NotSufficientBookException("Not enough copies of book: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    // Method to purchase more copies of a book
    public void purchaseBook(String isbn, int noOfCopies) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setNoOfCopies(book.getNoOfCopies() + noOfCopies);
                System.out.println("Purchased " + noOfCopies + " copies of book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    // Display all books
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        BookApp app = new BookApp();
        app.loadBooksFromFile("books.txt");

        app.displayBooks();

        // Search for a book by ID
        Book book = app.searchBook(121);
        if (book != null) {
            System.out.println("Found: " + book);
        }

        // Sell a book
        try {
            app.sellBook("A234", 2);
        } catch (NotSufficientBookException e) {
            System.out.println(e.getMessage());
        }

        // Purchase more copies of a book
        app.purchaseBook("A234", 5);

        // Display all books after modifications
        app.displayBooks();
    }
}
