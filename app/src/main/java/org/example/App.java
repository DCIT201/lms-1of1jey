/*
 * This should be your main class where all your objects will be created
 */
package org.example;

public class App {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("A lecture's salary", "Robert Johnson", 2006));
        library.addBook(new Book("48 Books of Power", "Ama wilson", 1927));
        library.addBook(new Book("Power of God", "Nance miles", 2001));
        library.addBook(new Book("kings in Action", "Irene Oware", 2013));

        // List all books
        System.out.println("Books in the store:");
        library.listBooks();

        // Create a patron
        Patron patron = new Patron("Mary", 1);

        // Borrow a book
        patron.borrowBook(new Book("A Lecture's salary", "Robert Johnson", 2024), library);

        // List borrowed books
        System.out.println("\nBorrowed books:");
        patron.listBorrowedBooks();

        // Return a book
        patron.returnBook(new Book("A Lecture's salary", "Robert Johnson", 2024), library);

        // Final library state
        System.out.println("\nBooks in the store after operations:");
        library.listBooks();
    }
}
