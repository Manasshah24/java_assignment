package day3.q4;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;
    private int noOfCopies;

    // Constructor
    public Book(int id, String isbn, String title, String author, double price, int noOfCopies) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.noOfCopies = noOfCopies;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    // Override toString for easy display of book details
    @Override
    public String toString() {
        return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author
                + ", price=" + price + ", noOfCopies=" + noOfCopies + "]";
    }
}
