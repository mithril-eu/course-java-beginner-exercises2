package eu.mithril.java.edu10;

import java.util.ArrayList;
import java.util.Collections;

public class MovieMain {

    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Godfather", 1972, 9.2));
        movies.add(new Movie("Pulp Fiction", 1994, 8.9));
        movies.add(new Movie("The Dark Knight", 2008, 9.0));
        movies.add(new Movie("Fight Club", 1999, 8.8));
        movies.add(new Movie("Inception", 2010, 8.8));
        movies.add(new Movie("Goodfellas", 1990, 8.7));
        movies.add(new Movie("The Matrix", 1999, 8.7));

        // Print unsorted list
        System.out.println("Unsorted Movies:");
        printMovies(movies);

        Collections.sort(movies);

        // Print sorted list
        System.out.println("\nSorted by Year (and Rating):");
        printMovies(movies);
    }

    private static void printMovies(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}

/*
 * Expected output example:
 * Unsorted Movies:
 * 1972 - The Godfather (9.2)
 * 1994 - Pulp Fiction (8.9)
 * 2008 - The Dark Knight (9.0)
 * ...
 * Sorted by Year (and Rating):
 * 1972 - The Godfather (9.2)
 * 1990 - Goodfellas (8.7)
 * 1994 - Pulp Fiction (8.9)
 * 1999 - Fight Club (8.8)
 * 1999 - The Matrix (8.7)
 * 2008 - The Dark Knight (9.0)
 * 2010 - Inception (8.8)
 */