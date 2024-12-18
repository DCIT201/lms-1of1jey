public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }
}

// Library Class
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}

// the patron class
class Patron {
    private String name;
    private List<Book> borrowedBooks;

    public Patron(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean borrowBook(Library library, String title) {
        Book book = library.findBook(title);
        if (book != null && !book.isBorrowed()) {
            book.borrowBook();
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Library library, String title) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                borrowedBooks.remove(book);
                return true;
            }
        }
        return false;
    }
}

// the App class
public class App {
    public static void main(String[] args) {
        // Create Library
        Library library = new Library();

        // Add books to Library
        library.addBook(new Book("2015", "Jeffrey Eshun"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        // Create Patrons
        Patron Jeffrey = new Patron("Jeffrey");
        Patron George = new Patron("George");

        // Simulate borrowing books
        System.out.println("Jeffrey borrows '2015': " + Jeffrey.borrowBook(library, "2015")); // The output will be True
        System.out.println("George borrows '2015': " + George.borrowBook(library, "2015"));   // The output will be False

        // Show borrowed books
        System.out.println("Jeffrey's borrowed books: " + Jeffrey.getBorrowedBooks().size()); // It will give an output of 1

        // Simulate returning books
        System.out.println("Jeffrey returns '2015': " + Jeffrey.returnBook(library, "2015")); // Will provide True

        // Show available books in the library
        System.out.println("Available books in the library: " + library.getAvailableBooks().size()); // 3
    }
}
