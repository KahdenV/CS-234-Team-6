import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Utility class for creating dummy data for customers, staff, movies, showtimes, and concessions.
 */
public class DummyData {
    private static final Map<String, Concession> concessionMenu = new HashMap<>();
    private static List<Showtime> showtimes = new ArrayList<>();
    private static Map<String, List<Ticket>> ticketsByCustomer = new HashMap<>();

    /**
     * Adds a showtime to the central list.
     *
     * @param showtime The showtime to add.
     */
    public static void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
    }

    /**
     * Retrieves all registered showtimes.
     *
     * @return A list of showtimes.
     */
    public static List<Showtime> getShowtimes() {
        return new ArrayList<>(showtimes);
    }

    /**
     * Retrieves tickets purchased by a specific customer.
     *
     * @param customerId The customer's ID.
     * @return A list of tickets.
     */
    public static List<Ticket> getTicketsByCustomer(String customerId) {
        return ticketsByCustomer.getOrDefault(customerId, new ArrayList<>());
    }

    /**
     * Adds a ticket to the customer's ticket list.
     *
     * @param customerId The ID of the customer.
     * @param ticket The ticket to add.
     */
    public static void addTicket(String customerId, Ticket ticket) {
        ticketsByCustomer.computeIfAbsent(customerId, k -> new ArrayList<>()).add(ticket);
    }

    /**
     * Creates a sample list of dummy customers.
     *
     * @return A list of Customer objects.
     */
    public static List<Customer> createDummyCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Customer1", "John Doe", "john", "pass123"));
        customers.add(new Customer("Customer2", "Jane Smith", "jane", "pass456"));
        return customers;
    }

    /**
     * Creates a sample list of dummy staff members.
     *
     * @return A list of Staff objects.
     */
    public static List<Staff> createDummyStaff() {
        List<Staff> staff = new ArrayList<>();
        staff.add(new Staff("Admin User", "admin", "admin123"));
        staff.add(new Staff("Theater Staff", "staff", "staff123"));
        return staff;
    }

    /**
     * Creates a sample list of dummy movies.
     *
     * @return A list of Movie objects.
     */
    public static List<Movie> createDummyMovies() {
        List<Movie> movies = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setMovieID("001");
        movie1.setMovieTitle("Inception");
        movie1.movieGenres = "Sci-Fi, Thriller";
        movie1.movieRuntime = 148;
        movie1.movieRating = "PG-13";
        movie1.movieReleaseDate = "07/16/2010";
        movies.add(movie1);

        Movie movie2 = new Movie();
        movie2.setMovieID("002");
        movie2.setMovieTitle("The Dark Knight");
        movie2.movieGenres = "Action, Crime";
        movie2.movieRuntime = 152;
        movie2.movieRating = "PG-13";
        movie2.movieReleaseDate = "07/18/2008";
        movies.add(movie2);

        return movies;
    }

    /**
     * Initializes and returns a map of dummy concession items.
     *
     * @return A map of concession items keyed by ID.
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