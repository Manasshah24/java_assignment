package day2.assignment_1;

import java.util.HashMap;
import java.util.Map;

public class BookStore {
    // Attributes
    private Map<Integer, Integer> bookInventory; // bookId -> quantity
    private Map<Integer, Book> books; // bookId -> Book object

    // Constructor
    public BookStore() {
        bookInventory = new HashMap<>();
        books = new HashMap<>();
    }

    // Add a book to the bookstore (initial setup)
    public void addBook(Book book, int quantity) {
        books.put(book.getId(), book);
        bookInventory.put(book.getId(), quantity);
    }

    // Display books and their quantities
    public void display() {
        System.out.println("Book Inventory:");
        for (Map.Entry<Integer, Integer> entry : bookInventory.entrySet()) {
            int bookId = entry.getKey();
            int quantity = entry.getValue();
            Book book = books.get(bookId);
            System.out.println("Book ID: " + book.getId() + ", Name: " + book.getTitle() + ", Quantity: " + quantity);
        }
    }

    // Update book quantity
    public void updateQuantity(int bookId, int amount) {
        int currentQuantity = bookInventory.getOrDefault(bookId, 0);
        bookInventory.put(bookId, currentQuantity + amount);
    }

    // Order a book
    public void orderBook(int bookId) {
        int quantity = bookInventory.getOrDefault(bookId, 0);
        Book book = books.get(bookId); // Fetch the book details

        if (book == null) {
            System.out.println("Book with ID " + bookId + " does not exist in the bookstore.");
            return;
        }

        if (quantity > 0) {
            // Decrease quantity and display book details
            updateQuantity(bookId, -1);
            System.out.println("Order placed successfully for the following book:");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Book ID: " + book.getId());
        } else {
            // Out of stock
            orderNewFromInventory(book);
        }
    }

    // Order new books from inventory
    public void orderNewFromInventory(Book book) {
        System.out.println("The book '" + book.getTitle() + "' by " + book.getAuthor() + " is out of stock.");
        System.out.println("It will arrive in 1 month.");
    }

    // Sell a book to the library
    public void sellBookToLibrary(int bookId) {
        Book book = books.get(bookId);
        if (book != null) {
            updateQuantity(bookId, 1);
            System.out.println("Book sold to library: " + book.getTitle());
        } else {
            System.out.println("Book with ID " + bookId + " does not exist in the bookstore.");
        }
    }
}


