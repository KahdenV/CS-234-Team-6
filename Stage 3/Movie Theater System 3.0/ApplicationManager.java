import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Handles the overall control flow of the movie theater system,
 * including startup, shutdown, user login, and account creation.
 */
public class ApplicationManager
{
    private MenuManager menuManager;
    private AuthenticationService authService;
    private List<Movie> movies; // Add movies list
    private Map<String, Concession> concessions; // Add concessions map
    private List<Showtime> showtimes;


    /**
     * Constructs the ApplicationManager with the required components.
     *
     * @param menuManager Handles menu navigation.
     * @param authService Manages user authentication.
     */
    public ApplicationManager(MenuManager menuManager, AuthenticationService authService)
    {
        this.menuManager = menuManager;
        this.authService = authService;
    }


    /**
     * Displays system initialization message.
     */
    public void initialize()
    {
        System.out.println("System initializing...");
    }


    /**
     * Displays system shutdown message.
     */
    public void shutdown()
    {
        System.out.println("System shutting down...");
    }


    /**
     * Sets the movie list used by the system.
     *
     * @param movies The list of movies.
     */
    public void setMovies(List<Movie> movies)
    {
        this.movies = movies;
    }
    

    /**
     * Sets the available concession items.
     *
     * @param concessions The concession map.
     */
    public void setConcessions(Map<String, Concession> concessions)
    {
        this.concessions = concessions;
    }

    public void setShowtimes(List<Showtime> showtimes) {
        this.showtimes = showtimes;
    }


    /**
     * Starts the system and handles the login loop.
     */
    public void start() {
        while (true) {
            Person authenticatedUser = authenticateUser();
            if (authenticatedUser != null) {
                if (authenticatedUser instanceof Guest) {
                    System.out.println("Logged in as: " + ((Guest) authenticatedUser).getId());
                } else if (authenticatedUser instanceof Customer) {
                    System.out.println("Logged in as: " + ((Customer) authenticatedUser).getCustomerId());
                }
                menuManager.displayMainMenu(authenticatedUser);
            } else {
                System.out.println("Exiting the system.");
                break;
            }
        }
    }

    /**
     * Displays login menu and authenticates the user.
     *
     * @return The authenticated user or null if exiting.
     */
    private Person authenticateUser() {
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("\n=== Login Menu ===");
            System.out.println("1. Login");
            System.out.println("2. Login as Guest");
            System.out.println("3. Create an Account");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    System.out.println("\n=== Log In ===");
                    System.out.print("Enter username/email: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
    
                    Person user = authService.authenticate(username, password);
                    if (user != null) {
                        // Dynamically set up the CustomerMenu
                        menuManager.setCustomerMenu(new CustomerMenu(movies, user, concessions, showtimes));
                        return user;
                    } else {
                        System.out.println("Authentication failed. Please try again.");
                    }
                    break;
                case 2:
                    Guest guest = authService.loginAsGuest();
                    // Dynamically set up the CustomerMenu for the guest
                    menuManager.setCustomerMenu(new CustomerMenu(movies, guest, concessions, showtimes));
                    return guest;
                case 3:
                    createAccount(scanner);
                    break;
                case 4:
                    return null;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Prompts the user for account information and registers a new customer.
     *
     * @param scanner Scanner object for user input.
     */
    private void createAccount(Scanner scanner) {
        System.out.println("\n=== Create an Account ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter username/email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    
        // Generate a unique ID for the customer
        String customerId = "Customer" + (authService.getCustomers().size() + 1);
    
        // Create a new customer and add it to the list
        Customer newCustomer = new Customer(customerId, name, email, password);
        authService.addCustomer(newCustomer);
    
        System.out.println("Account created successfully. You can now log in.");
    }
}