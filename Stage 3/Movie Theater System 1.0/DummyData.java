import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Utility class for creating dummy data for customers, staff, movies, and concessions.
 */
public class DummyData {
    // Store concession items in a static map
    private static final Map<String, Concession> concessionMenu = new HashMap<>();

    /**
     * Creates a list of dummy customers.
     *
     * @return A list of dummy customers.
     */
    public static ArrayList<Customer> createDummyCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer ("GUEST", "N/A", "N/A"));
        customers.add(new Customer("John Doe", "john", "pass123"));
        customers.add(new Customer("Jane Smith", "jane", "pass456"));
        return customers;
    }

    /**
     * Creates a list of dummy staff members.
     *
     * @return A list of dummy staff members.
     */
    public static ArrayList<Staff> createDummyStaff() {
        ArrayList<Staff> staff = new ArrayList<>();
        staff.add(new Staff("Admin User", "admin", "admin123"));
        staff.add(new Staff("Theater Staff", "staff", "staff123"));
        return staff;
    }

    /**
     * Creates a list of dummy movies.
     *
     * @return A list of dummy movies.
     */
    public static ArrayList<Movie> createDummyMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        // Add first movie
        Movie movie1 = new Movie();
        movie1.setMovieID("0001");
        movie1.setMovieTitle("Inception");
        movie1.setMovieGenres("Sci-Fi, Thriller");
        movie1.setMovieRuntime(148);
        movie1.setMovieRating("PG-13");
        movie1.setMovieReleaseDate("07/16/2010");
        movies.add(movie1);

        // Add second movie
        Movie movie2 = new Movie();
        movie2.setMovieID("0002");
        movie2.setMovieTitle("The Dark Knight");
        movie2.setMovieGenres("Action, Crime");
        movie2.setMovieRuntime(152);
        movie2.setMovieRating("PG-13");
        movie2.setMovieReleaseDate("07/18/2008");
        movies.add(movie2);

        return movies;
    }

    public static ArrayList<Ticket> createDummyTickets()
    {
        ArrayList<Ticket> tickets = new ArrayList<>();

        Ticket ticket_01 = new Ticket();
        ticket_01.setTicketID("000001");
        ticket_01.setCustomerName("98987");
        ticket_01.setShowtime("--");
        ticket_01.setSeatNumber("E2");
        ticket_01.setTicketPrice("34");
        ticket_01.setTicketStatus("Booked");

        tickets.add(ticket_01);

        return tickets;
    }

    /**
     * Initializes dummy concessions data.
     */
    public static Map<String, Concession> createDummyConcessions() {
        if (concessionMenu.isEmpty()) {
            concessionMenu.put("C001", new Concession("C001", "Popcorn (Small)", 4.50));
            concessionMenu.put("C002", new Concession("C002", "Popcorn (Medium)", 6.00));
            concessionMenu.put("C003", new Concession("C003", "Popcorn (Large)", 7.50));
            concessionMenu.put("C004", new Concession("C004", "Coca-Cola (Small)", 2.50));
            concessionMenu.put("C005", new Concession("C005", "Coca-Cola (Medium)", 3.50));
            concessionMenu.put("C006", new Concession("C006", "Coca-Cola (Large)", 4.50));
            concessionMenu.put("C007", new Concession("C007", "Nachos", 5.00));
            concessionMenu.put("C008", new Concession("C008", "Hot Dog", 4.00));
            concessionMenu.put("C009", new Concession("C009", "Candy (Small)", 3.00));
            concessionMenu.put("C010", new Concession("C010", "Candy (Large)", 5.00));
            concessionMenu.put("C011", new Concession("C011", "Ice Cream", 4.50));
        }
        return concessionMenu;
    } 
}
