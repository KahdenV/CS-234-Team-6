import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Utility class for creating dummy data for customers, staff, movies, and concessions.
 */
public class DummyData {
    // Store concession items in a static map
    private static final Map<String, Concession> concessionMenu = new HashMap<>();
    private static List<Showtime> showtimes = new ArrayList<>();
    private static Map<String, List<Ticket>> ticketsByCustomer = new HashMap<>();

    public static void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
    }

    public static List<Ticket> getTicketsByCustomer(String customerId) {
        return ticketsByCustomer.getOrDefault(customerId, new ArrayList<>());
    }
    
    public static void addTicket(String customerId, Ticket ticket) {
        ticketsByCustomer.computeIfAbsent(customerId, k -> new ArrayList<>()).add(ticket);
    }


    /**
     * Creates a list of dummy customers.
     *
     * @return A list of dummy customers.
     */
    public static List<Customer> createDummyCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Customer1", "John Doe", "john", "pass123"));
        customers.add(new Customer("Customer2", "Jane Smith", "jane", "pass456"));
        // Ensure no email or password is left null
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

    /**
     * Creates a list of dummy movies.
     *
     * @return A list of dummy movies.
     */
    public static List<Movie> createDummyMovies() {
        List<Movie> movies = new ArrayList<>();
    
        // Add first movie
        Movie movie1 = new Movie();
        movie1.movieID = "001"; // Ensure unique ID
        movie1.movieTitle = "Inception";
        movie1.movieGenres = "Sci-Fi, Thriller";
        movie1.movieRuntime = 148;
        movie1.movieRating = "PG-13";
        movie1.movieReleaseDate = "07/16/2010";
        movies.add(movie1);
    
        // Add second movie
        Movie movie2 = new Movie();
        movie2.movieID = "002"; // Ensure unique ID
        movie2.movieTitle = "The Dark Knight";
        movie2.movieGenres = "Action, Crime";
        movie2.movieRuntime = 152;
        movie2.movieRating = "PG-13";
        movie2.movieReleaseDate = "07/18/2008";
        movies.add(movie2);
    
        return movies;
    }

    /**
     * Creates a list of dummy screens.
     * 
     * @return A list of dummy screens.
     */
    public static List<Screen> createDummyScreens() {
        List<Screen> screens = new ArrayList<>();
        
        Screen screen1 = new Screen("001", 50);
        Screen screen2 = new Screen("002", 55);

        screens.add(screen1);
        screens.add(screen2);

        return screens;
    }

    /**
     * Creates a list of dummy showtimes
     * 
     * @param movies
     * @param screens
     * @return A list of dummy showtimes.
     */
    public static List<Showtime> createDummyShowtimes(List<Movie> movies, List<Screen> screens) {
        List<Showtime> showtimes = new ArrayList<>();

        Showtime showtime1 = new Showtime(movies.get(0), screens.get(0), "4:30 PM");
        Showtime showtime2 = new Showtime(movies.get(1), screens.get(1), "2:00 PM");

        showtimes.add(showtime1);
        showtimes.add(showtime2);
        screens.get(0).assignShowTime("4:30 PM");
        screens.get(1).assignShowTime("2:00 PM");

        return showtimes;
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