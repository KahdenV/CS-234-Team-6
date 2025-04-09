import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Utility class for creating dummy data for customers and staff.
 */
public class DummyData {
    /**
     * Creates a list of dummy customers.
     *
     * @return A list of dummy customers.
     */
    public static List<Customer> createDummyCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John Doe", "john", "pass123"));
        customers.add(new Customer("Jane Smith", "jane", "pass456"));
        return customers;
    }

    /**
     * Creates a list of dummy staff members.
     *
     * @return A list of dummy staff members.
     */
    public static List<Staff> createDummyStaff() {
        List<Staff> staff = new ArrayList<>();
        staff.add(new Staff("Admin User", "admin", "admin123"));
        staff.add(new Staff("Theater Staff", "staff", "staff123"));
        return staff;
    }

    public static List<Movie> createDummyMovies() {
        List<Movie> movies = new ArrayList<>();
    
        // Add first movie
        Movie movie1 = new Movie();
        movie1.setMovieID("001");
        movie1.movieTitle = "Inception";
        movie1.movieGenres = "Sci-Fi, Thriller";
        movie1.movieRuntime = 148;
        movie1.movieRating = "PG-13";
        movie1.movieReleaseDate = "07/16/2010";
        movies.add(movie1);
    
        // Add second movie
        Movie movie2 = new Movie();
        movie2.setMovieID("002");
        movie2.movieTitle = "The Dark Knight";
        movie2.movieGenres = "Action, Crime";
        movie2.movieRuntime = 152;
        movie2.movieRating = "PG-13";
        movie2.movieReleaseDate = "07/18/2008";
        movies.add(movie2);
    
        return movies;
    }

    public static void createDummyConcessions() {
        Concession.addItem("C001", "Popcorn (Small)", 4.50);
        Concession.addItem("C002", "Popcorn (Medium)", 6.00);
        Concession.addItem("C003", "Popcorn (Large)", 7.50);
        Concession.addItem("C004", "Coca-Cola (Small)", 2.50);
        Concession.addItem("C005", "Coca-Cola (Medium)", 3.50);
        Concession.addItem("C006", "Coca-Cola (Large)", 4.50);
        Concession.addItem("C007", "Nachos", 5.00);
        Concession.addItem("C008", "Hot Dog", 4.00);
        Concession.addItem("C009", "Candy (Small)", 3.00);
        Concession.addItem("C010", "Candy (Large)", 5.00);
        Concession.addItem("C011", "Ice Cream", 4.50);
    }
}