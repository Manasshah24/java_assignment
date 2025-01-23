package week1.day1.day2.assignment_1;

public class Book {
    // Attributes
    private String title;
    private String author;
    private int id;

    // Constructor
    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    // Getter methods (optional, based on need)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    // Behavior methods
    public void order() {
        System.out.println("Order placed for book: " + title);
    }

    public void sell() {
        System.out.println("Book sold to library: " + title);
    }
}
