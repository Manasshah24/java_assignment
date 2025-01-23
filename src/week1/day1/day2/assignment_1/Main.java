package week1.day1.day2.assignment_1;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 1);
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", 2);

        BookStore bookstore = new BookStore();
        bookstore.addBook(book1, 5);
        bookstore.addBook(book2, 0);

        bookstore.display();
    }
}
