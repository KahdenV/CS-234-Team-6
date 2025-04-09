import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Displays the customer menu and handles customer actions.
 */
public class CustomerMenu {
    private List<Movie> movies;
    private String customerId;

    public CustomerMenu(List<Movie> movies) {
        this.movies = movies;
        this.customerId = customerId;
    }

    public void showCustomerMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. View All Movies");
            System.out.println("2. Sewarch Movie");
            System.out.println("3. Book Ticket");
            System.out.println("4. View Order History");
            System.out.println("5. View Concessions");
            System.out.println("6. Purchase Concessions");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllMovies();
                    break;
                case 2:
                    searchMovie(scanner);
                    break;
                case 3:
                    // bookTicket();
                    break;
                case 4:
                    // viewOrderHistory();
                    break;
                case 5:
                    viewConcessions();
                    break;
                case 6:
                    purchaseConcessions(scanner);
                    break;
                case 7:
                    running = false; // Log out and return to the login menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
    * Displays all movies.
    */
    private void viewAllMovies() {
        System.out.println("\n=== View All Movies ===");
            for (Movie movie : movies) {
                movie.printMovieDetails();
        }
    }

        /**
     * Searches for a movie by title.
     *
     * @param scanner The Scanner object for user input.
     */
    private void searchMovie(Scanner scanner) {
        System.out.print("\nEnter movie title to search: ");
        String title = scanner.nextLine();

        for (Movie movie : movies) {
            if (movie.getMovieTitle().equalsIgnoreCase(title)) {
                movie.printMovieDetails();
                return;
            }
        }

        System.out.println("Movie not found.");
    }

    /**
     * Displays all available concession items.
     */
    private void viewConcessions() {
        System.out.println("\n=== Concessions Menu ===");
        if (Concession.getConcessionMenu().isEmpty()) {
            System.out.println("No concession items available.");
        } else {
            for (Map.Entry<String, Concession> entry : Concession.getConcessionMenu().entrySet()) {
                Concession item = entry.getValue();
                System.out.println("ID: " + item.getConcessionId() + " | Item: " + item.getItemName() + " | Price: $" + item.getPrice());
            }
        }
    }

    /**
     * Allows the customer to purchase a concession item.
     *
     * @param scanner The Scanner object for user input.
     */
    private void purchaseConcessions(Scanner scanner) {
        System.out.println("\n=== Purchase Concessions ===");
        System.out.print("Enter the item ID to purchase: ");
        String itemId = scanner.nextLine();

        // Process the sale using the Concession class
        Concession.processSale(itemId, customerId);
    }
}