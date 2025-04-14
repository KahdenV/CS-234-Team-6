import java.util.List;
import java.util.Map;

/**
 * Main class for managing the movie theater system.
 */
public class MovieTheaterSystem {
    private List<Customer> customers;
    private List<Staff> staff;
    private AuthenticationService authService;
    private List<Movie> movies;
    private Map<String, Concession> concessions;
    private List<Showtime> showtimes;

    /**
     * Constructs the MovieTheaterSystem with dummy data for all major components.
     */
    public MovieTheaterSystem() {
        customers = DummyData.createDummyCustomers();
        staff = DummyData.createDummyStaff();
        movies = DummyData.createDummyMovies();
        concessions = DummyData.createDummyConcessions();
        showtimes = DummyData.getShowtimes();

        Concession.getConcessionMenu().putAll(concessions);
    }

    /**
     * Returns the authentication service.
     *
     * @return The AuthenticationService instance.
     */
    public AuthenticationService getAuthService() {
        return authService;
    }

    /**
     * Initializes the authentication service.
     */
    public void initialize() {
        authService = new AuthenticationService(customers, staff);
    }

    /**
     * Returns the concessions data.
     *
     * @return A map of concession items.
     */
    public Map<String, Concession> getConcessions() {
        return concessions;
    }

    /**
     * Returns the list of showtimes.
     *
     * @return List of showtimes.
     */
    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    /**
     * Displays the main menu and starts the application lifecycle.
     */
    public void showMainMenu() {
        MenuManager menuManager = new MenuManager(
            null,
            new StaffMenu(staff, customers, movies, concessions)
        );
        ApplicationManager appManager = new ApplicationManager(menuManager, authService);
        appManager.setMovies(movies);
        appManager.setConcessions(concessions);
        appManager.start();
    }

    /**
     * Main entry point for the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        MovieTheaterSystem system = new MovieTheaterSystem();
        system.initialize();
        system.showMainMenu();
    }
}