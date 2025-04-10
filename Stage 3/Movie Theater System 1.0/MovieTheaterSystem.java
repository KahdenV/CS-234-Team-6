import java.util.ArrayList;
import java.util.Map;

/*
 * Class for managing the movie theater system (created directly from Main)
 */

public class MovieTheaterSystem
{
    private ArrayList<Customer> customers;
    private ArrayList<Staff> staff;
    private AuthenticationService authService;
    private ArrayList<Movie> movies;
    private ArrayList<Ticket> tickets;
    private Map<String, Concession> concessions;
    private static int customerIdCounter = 1;

    public MovieTheaterSystem()
    {
        customers = DummyData.createDummyCustomers();
        staff = DummyData.createDummyStaff();
        movies = DummyData.createDummyMovies();
        concessions = DummyData.createDummyConcessions();
        tickets = DummyData.createDummyTickets();
        showMainMenu();
    }


    public void showMainMenu()
    {
        MenuManager menuManager = new MenuManager
        (
            new CustomerMenu(movies, generateUniqueCustomerId(), concessions),
            new StaffMenu(staff, customers, movies, concessions)
        );
        ApplicationManager appManager = new ApplicationManager(menuManager, authService);
        appManager.start();
    }

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

    /**
     * Generates a unique customer ID dynamically.
     * @return A unique customer ID as a string.
     */
    private synchronized String generateUniqueCustomerId() {
        return "Customer" + customerIdCounter++;
    }
}
