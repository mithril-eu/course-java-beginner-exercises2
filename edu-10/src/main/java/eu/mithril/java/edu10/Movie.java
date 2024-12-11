package eu.mithril.java.edu10;

/*
 * Create a Movie class that can be sorted by year, and then by rating
 */
public class Movie implements Comparable<Movie> {
    private String title;
    private int year;
    private double rating;

    public Movie(String title, int year, double rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    // TODO: Implement compareTo method to sort by year
    // If years are equal, sort by rating (highest first)
    @Override
    public int compareTo(Movie other) {
        // First compare by year
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        // If years are equal, compare by rating (highest first)
        return Double.compare(other.rating, this.rating);
    }

    public String toString() {
        return year + " - " + title + " (" + rating + ")";
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }
}
