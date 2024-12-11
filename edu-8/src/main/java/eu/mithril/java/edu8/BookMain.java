package eu.mithril.java.edu8;

import java.util.ArrayList;

/**
 * Test program that demonstrates:
 * 1. Adding books to ArrayList
 * 2. Removing books
 * 3. Searching books
 * 4. Printing book collection
 */
public class BookMain {
    public static void main(String[] args) {
        BookManager library = new BookManager();

        // Add some books
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", 1813));
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954));

        // Print all books
        System.out.println("All books:");
        library.printBooks();

        // Find books by Tolkien
        System.out.println("\nBooks by Tolkien:");
        ArrayList<Book> tolkienBooks = library.findBooksByAuthor("J.R.R. Tolkien");
        for (Book book : tolkienBooks) {
            System.out.println(book);
        }

        // Find books after 1900
        System.out.println("\nBooks after 1900:");
        ArrayList<Book> modernBooks = library.findBooksAfterYear(1900);
        for (Book book : modernBooks) {
            System.out.println(book);
        }

        // Remove a book
        library.removeBook("1984");

        System.out.println("\nAfter removing 1984:");
        library.printBooks();
    }
}