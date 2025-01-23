package day8;



import java.util.*;
        import java.util.stream.Collectors;

public class CopyOfDemoBookCaseStudyProblem {

    public static void main(String[] args) {

        List<Book> allBooks = loadAllBooks();

        // 1. Find books with more than 400 pages
        List<Book> booksMoreThan400Pages = allBooks.stream()
                .filter(b -> b.getPages() > 400)
                .collect(Collectors.toList());
        System.out.println("Books with more than 400 pages: " + booksMoreThan400Pages);

        // 2. Find all books that are Java books and have more than 400 pages
        List<Book> javaBooksMoreThan400Pages = allBooks.stream()
                .filter(b -> b.getPages() > 400 && b.getSubject() == Subject.JAVA)
                .collect(Collectors.toList());
        System.out.println("Java books with more than 400 pages: " + javaBooksMoreThan400Pages);

        // 3. Get the top three longest books
        List<Book> topThreeLongestBooks = allBooks.stream()
                .sorted((b1, b2) -> Integer.compare(b2.getPages(), b1.getPages()))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top three longest books: " + topThreeLongestBooks);

        // 4. Get books from the fourth to the last longest
        List<Book> fromFourthToLastLongestBooks = allBooks.stream()
                .sorted((b1, b2) -> Integer.compare(b2.getPages(), b1.getPages()))
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Books from fourth to the last longest: " + fromFourthToLastLongestBooks);

        // 5. Get all the publishing years
        Set<Integer> publishingYears = allBooks.stream()
                .map(Book::getYear)
                .collect(Collectors.toSet());
        System.out.println("Publishing years: " + publishingYears);

        // 6. Get all authors' names
        Set<String> authorsNames = allBooks.stream()
                .flatMap(b -> b.getAuthors().stream())
                .map(Author::getName)
                .collect(Collectors.toSet());
        System.out.println("Authors' names: " + authorsNames);

        // 7. Get all the origin countries of the authors
        Set<String> originCountries = allBooks.stream()
                .flatMap(b -> b.getAuthors().stream())
                .map(Author::getCountry)
                .collect(Collectors.toSet());
        System.out.println("Origin countries: " + originCountries);

        // 8. Get the most recent published book
        Book mostRecentBook = allBooks.stream()
                .max(Comparator.comparingInt(Book::getYear))
                .orElse(null);
        System.out.println("Most recent published book: " + mostRecentBook);

        // 9. Check if all books are written by more than one author
        boolean allBooksMultipleAuthors = allBooks.stream()
                .allMatch(b -> b.getAuthors().size() > 1);
        System.out.println("All books written by more than one author: " + allBooksMultipleAuthors);

        // 10. Find any book written by more than one author
        Book bookWithMultipleAuthors = allBooks.stream()
                .filter(b -> b.getAuthors().size() > 1)
                .findAny()
                .orElse(null);
        System.out.println("A book written by more than one author: " + bookWithMultipleAuthors);

        // 11. Get the total number of pages published
        int totalPages = allBooks.stream()
                .mapToInt(Book::getPages)
                .sum();
        System.out.println("Total number of pages published: " + totalPages);

        // 12. Get the number of pages of the longest book
        int longestBookPages = allBooks.stream()
                .mapToInt(Book::getPages)
                .max()
                .orElse(0);
        System.out.println("Pages in the longest book: " + longestBookPages);

        // 13. Get the average number of pages of the books
        double averagePages = allBooks.stream()
                .mapToInt(Book::getPages)
                .average()
                .orElse(0);
        System.out.println("Average number of pages: " + averagePages);

        // 14. Get all the titles of the books
        List<String> bookTitles = allBooks.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
        System.out.println("Book titles: " + bookTitles);

        // 15. Get the book with the highest number of authors
        Book bookWithMostAuthors = allBooks.stream()
                .max(Comparator.comparingInt(b -> b.getAuthors().size()))
                .orElse(null);
        System.out.println("Book with the most authors: " + bookWithMostAuthors);

        // 16. Get a Map of books per year
        Map<Integer, List<Book>> booksPerYear = allBooks.stream()
                .collect(Collectors.groupingBy(Book::getYear));
        System.out.println("Books per year: " + booksPerYear);

        // 17. Count how many books are published per year
        Map<Integer, Long> bookCountPerYear = allBooks.stream()
                .collect(Collectors.groupingBy(Book::getYear, Collectors.counting()));
        System.out.println("Book count per year: " + bookCountPerYear);
    }

    private static List<Book> loadAllBooks() {
        List<Book> books = new ArrayList<>();
        List<Author> authors1 = Arrays.asList(new Author("raj", "gupta", "in"),
                new Author("ekta", "gupta", "in"));

        List<Author> authors2 = Arrays.asList(new Author("raj", "gupta", "in"));

        List<Author> authors3 = Arrays.asList(new Author("gunika", "gupta", "us"),
                new Author("keshav", "gupta", "us"));

        books.add(new Book("java", authors1, 400, Subject.JAVA, 2000, "1213"));
        books.add(new Book("python", authors2, 479, Subject.JAVA, 2007, "1218"));
        books.add(new Book("Mgt", authors3, 600, Subject.DOT_NET, 2000, "1293"));

        return books;
    }
}

class Book {
    private String title;
    private List<Author> authors;
    private int pages;
    private Subject subject;
    private int year;
    private String isbn;

    public Book(String title, List<Author> authors, int pages, Subject subject, int year, String isbn) {
        this.title = title;
        this.authors = authors;
        this.pages = pages;
        this.subject = subject;
        this.year = year;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getPages() {
        return pages;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                '}';
    }
}

class Author {
    private String name;
    private String lastname;
    private String country;

    public Author(String name, String lastname, String country) {
        this.name = name;
        this.lastname = lastname;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

enum Subject {
    JAVA,
    DOT_NET
}
