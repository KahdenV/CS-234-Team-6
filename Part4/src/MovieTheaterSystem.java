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
    private List<Screen> screens;
    private List<Showtime> showtimes;


    /**
     * Constructs the MovieTheaterSystem with dummy data for all major components.
     */
    public MovieTheaterSystem() {
        customers = DummyData.createDummyCustomers();
        staff = DummyData.createDummyStaff();
        movies = DummyData.createDummyMovies();
        concessions = DummyData.createDummyConcessions(); // Initialize dummy concessions
        screens = DummyData.createDummyScreens();
        showtimes = DummyData.createDummyShowtimes(movies, screens); // Initialize showtimes

        // Populate the global Concession menu with dummy data
        Concession.getConcessionMenu().putAll(concessions);

        initialize();
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
     * Initializes the movie theater system.
     */
    public void initialize() {
        // Initialize the auth service with the dummy data
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

    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    /**
     * Shows the main menu and starts the application.
     */
    public void showMainMenu() {
        // Initialize the MenuManager without pre-creating CustomerMenu
        MenuManager menuManager = new MenuManager(
            null, // CustomerMenu will be initialized dynamically
            new StaffMenu(staff, customers, movies, concessions, screens, showtimes) // StaffMenu remains the same
        );
        ApplicationManager appManager = new ApplicationManager(menuManager, authService);
        appManager.setMovies(movies);
        appManager.setConcessions(concessions);
        appManager.setShowtimes(showtimes);

        // Start the application lifecycle
        appManager.start();
    }
}