package eu.mithril.java.edu14;

import java.util.List;
import java.util.stream.Collectors;

public class BookOperations {
    private final List<Book> books;

    public BookOperations(List<Book> books) {
        this.books = books;
    }

    public List<String> getTitles() {
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getAuthorTitlePairs() {
        return books.stream()
                .map(book -> book.getAuthor() + ":" + book.getTitle())
                .collect(Collectors.toList());
    }

    public List<Double> getPricesWithDiscount() {
        return books.stream()
                .map(Book::getPrice)
                .map(price -> price * 0.8)  // 20% discount
                .map(price -> Math.round(price * 100.0) / 100.0)  // Round to 2 decimals
                .collect(Collectors.toList());
    }

    public List<String> getBookSummaries() {
        return books.stream()
                .map(book -> String.format("%s - %s, %d pages",
                        book.getTitle(), book.getAuthor(), book.getPages()))
                .collect(Collectors.toList());
    }

    public List<String> getUniqueAuthors() {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }
}
