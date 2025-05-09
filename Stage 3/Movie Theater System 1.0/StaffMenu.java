import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Displays the staff menu and handles staff actions.
 */
public class StaffMenu {
    private List<Staff> staff;
    private List<Customer> customers;
    private List<Movie> movies;
    private Map<String, Concession> concessions;

    public StaffMenu(List<Staff> staff, List<Customer> customers, List<Movie> movies, Map<String, Concession> concessions) {
        this.staff = staff;
        this.customers = customers;
        this.movies = movies;
        this.concessions = concessions;
    }

    public void showStaffMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Staff Menu ===");
            System.out.println("1. View All Staff");
            System.out.println("2. Add New Staff");
            System.out.println("3. View All Customers");
            System.out.println("4. View Inventory");
            System.out.println("5. Add Stock");
            System.out.println("6. Update Stock");
            System.out.println("7. View Reports");
            System.out.println("8. Add Movie");
            System.out.println("9. Update Movie");
            System.out.println("10. Manage Concession");
            System.out.println("11. Manage Refunds");
            System.out.println("12. View Payments"); // New option
            System.out.println("13. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllStaff();
                    break;
                case 2:
                    addNewStaff(scanner);
                    break;
                case 3:
                    viewAllCustomers();
                    break;
                case 4:
                    // viewInventory();
                    break;
                case 5:
                    // addStock(scanner);
                    break;
                case 6:
                    // updateStock(scanner);
                    break;
                case 7:
                    // viewReports();
                    break;
                case 8:
                    addMovie(scanner);
                    break;
                case 9:
                    updateMovie(scanner);
                    break;
                case 10:
                    manageConcessions(scanner);
                    break;
                case 11:
                    manageRefunds(scanner);
                    break;
                case 12:
                    viewPayments(); // Call the new method
                    break;
                case 13:
                    running = false; // Log out and return to the login menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays all staff members.
     */
    private void viewAllStaff() {
        System.out.println("\n=== View All Staff ===");
        for (Staff s : staff) {
            System.out.println(s.getName() + " - " + s.getEmail());
        }
    }

    /**
     * Adds a new staff member.
     *
     * @param scanner The Scanner object for user input.
     */
    private void addNewStaff(Scanner scanner) {
        System.out.println("\n=== Add New Staff ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Staff newStaff = new Staff(name, username, password);
        staff.add(newStaff);

        System.out.println("New staff member added successfully.");
    }

    /**
     * Displays all customers with their IDs and names.
     */
    private void viewAllCustomers() {
        System.out.println("\n=== View All Customers ===");
        for (Customer c : customers) {
            // Assuming Customer class has a getCustomerId() method
            System.out.println(c.getCustomerId() + " - " + c.getName() + " (" + c.getEmail() + ")");
        }
    }

    /**
    * Displays all payments.
    */
    private void viewPayments() {
        System.out.println("\n=== View Payments ===");
        if (Payment.getPaymentRecords().isEmpty()) {
            System.out.println("No payments have been processed.");
        } else {
            for (Payment payment : Payment.getPaymentRecords().values()) {
                System.out.println(payment); // Assumes the Payment class has a meaningful toString() method
            }
        }
    }

    /**
     * Adds a new movie to the list.
     *
     * @param scanner The Scanner object for user input.
     */
    private void addMovie(Scanner scanner)
    {
        System.out.println("\n=== Add New Movie ===");
        Movie newMovie = new Movie();
        newMovie.setMovieID(createMovieID(movies));
        newMovie.setMovieTitle(createMovieTitle());
        newMovie.setMovieGenres(createMovieGenres());
        newMovie.setMovieRuntime(createMovieRuntime());
        newMovie.setMovieRating(createMovieRating());
        newMovie.setMovieReleaseDate(createMovieReleaseDate());
        movies.add(newMovie);

        System.out.println("New movie added successfully.");
    }

    /**
     * Updates an existing movie.
     *
     * @param scanner The Scanner object for user input.
     */
    private void updateMovie(Scanner scanner) {
        System.out.println("\n=== Update Movie ===");
        System.out.print("Enter the movie title to update: ");
        String title = scanner.nextLine();

        for (Movie movie : movies) {
            if (movie.getMovieTitle().equalsIgnoreCase(title)) {
                System.out.println("Movie found. Updating details...");

                boolean updating = true;
                while (updating) {
                    System.out.println("\nWhat would you like to update?");
                    System.out.println("1. Movie Title");
                    System.out.println("2. Movie Genres");
                    System.out.println("3. Movie Runtime");
                    System.out.println("4. Movie Rating");
                    System.out.println("5. Movie Release Date");
                    System.out.println("6. Finish Updating");
                    System.out.print("Enter your choice: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter the new movie title: ");
                            String newTitle = scanner.nextLine();
                            movie.setMovieTitle(newTitle);
                            System.out.println("Movie title updated successfully.");
                            break;
                        case 2:
                            movie.setMovieGenres();
                            System.out.println("Movie genres updated successfully.");
                            break;
                        case 3:
                            movie.setMovieRuntime();
                            System.out.println("Movie runtime updated successfully.");
                            break;
                        case 4:
                            movie.setMovieRating();
                            System.out.println("Movie rating updated successfully.");
                            break;
                        case 5:
                            movie.setMovieReleaseDate();
                            System.out.println("Movie release date updated successfully.");
                            break;
                        case 6:
                            updating = false;
                            System.out.println("Finished updating the movie.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
                return; // Exit the method after updating
            }
        }
        System.out.println("Movie not found.");
    }

    /**
     * Manage concessions menu for staff.
     *
     * @param scanner The Scanner object for user input.
     */
    private void manageConcessions(Scanner scanner) {
        boolean managing = true;

        while (managing) {
            System.out.println("\n=== Manage Concessions ===");
            System.out.println("1. Add Concession Item");
            System.out.println("2. Update Concession Item");
            System.out.println("3. Remove Concession Item");
            System.out.println("4. Search Concession Item");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addConcessionItem(scanner);
                    break;
                case 2:
                    updateConcessionItem(scanner);
                    break;
                case 3:
                    removeConcessionItem(scanner);
                    break;
                case 4:
                    searchConcessionItem(scanner);
                    break;
                case 5:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addConcessionItem(Scanner scanner) {
        System.out.println("\n=== Add Concession Item ===");
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Concession.addItem(itemId, itemName, price);
    }

    private void updateConcessionItem(Scanner scanner) {
        System.out.println("\n=== Update Concession Item ===");
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter new item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter new item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Concession.updateItem(itemId, itemName, price);
    }

    private void removeConcessionItem(Scanner scanner) {
        System.out.println("\n=== Remove Concession Item ===");
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();

        Concession.removeItem(itemId);
    }

    private void searchConcessionItem(Scanner scanner) {
        System.out.println("\n=== Search Concession Item ===");
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();

        Concession.searchItem(itemId);
    }

    /**
     * Manages staff-related actions, including refunds.
     */
    private void manageRefunds(Scanner scanner) {
        System.out.println("\n=== Manage Refunds ===");
        System.out.print("Enter Payment ID to refund: ");
        String paymentId = scanner.nextLine();

        Payment.refundPayment(paymentId);
    }
}
