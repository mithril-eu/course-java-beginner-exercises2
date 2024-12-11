package eu.mithril.java.edu8;

import java.util.ArrayList;

public class BookManager {

    private final ArrayList<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> findBooksByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> findBooksAfterYear(int year) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > year) {
                result.add(book);
            }
        }
        return result;
    }

    public void printBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
