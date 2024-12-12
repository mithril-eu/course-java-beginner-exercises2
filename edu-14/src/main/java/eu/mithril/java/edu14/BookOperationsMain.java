package eu.mithril.java.edu14;

import java.util.Arrays;
import java.util.List;

public class BookOperationsMain {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("The Hobbit", "J.R.R. Tolkien", 320, 15.99),
                new Book("1984", "George Orwell", 268, 12.99),
                new Book("Pride and Prejudice", "Jane Austen", 432, 14.99),
                new Book("The Lord of the Rings", "J.R.R. Tolkien", 1178, 29.99),
                new Book("Animal Farm", "George Orwell", 140, 11.99)
        );

        BookOperations ops = new BookOperations(books);

        System.out.println("All titles:");
        System.out.println(ops.getTitles());

        System.out.println("\nAuthor:Title pairs:");
        System.out.println(ops.getAuthorTitlePairs());

        System.out.println("\nDiscounted prices:");
        System.out.println(ops.getPricesWithDiscount());

        System.out.println("\nBook summaries:");
        System.out.println(ops.getBookSummaries());

        System.out.println("\nUnique authors:");
        System.out.println(ops.getUniqueAuthors());
    }
}

/*
 * Expected output:
 * All titles:
 * [The Hobbit, 1984, Pride and Prejudice, The Lord of the Rings, Animal Farm]
 *
 * Author:Title pairs:
 * [J.R.R. Tolkien:The Hobbit, George Orwell:1984, Jane Austen:Pride and Prejudice,
 *  J.R.R. Tolkien:The Lord of the Rings, George Orwell:Animal Farm]
 *
 * Discounted prices:
 * [12.79, 10.39, 11.99, 23.99, 9.59]
 *
 * Book summaries:
 * [The Hobbit - J.R.R. Tolkien, 320 pages,
 *  1984 - George Orwell, 268 pages,
 *  Pride and Prejudice - Jane Austen, 432 pages,
 *  The Lord of the Rings - J.R.R. Tolkien, 1178 pages,
 *  Animal Farm - George Orwell, 140 pages]
 *
 * Unique authors:
 * [J.R.R. Tolkien, George Orwell, Jane Austen]
 */
