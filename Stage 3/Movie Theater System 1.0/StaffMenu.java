import java.util.List;
import java.util.Scanner;

/**
 * Displays the staff menu and handles staff actions.
 */
public class StaffMenu {
    private List<Staff> staff;
    private List<Customer> customers;
    private List<Movie> movies;

    public StaffMenu(List<Staff> staff, List<Customer> customers, List<Movie> movies) {
        this.staff = staff;
        this.customers = customers;
        this.movies = movies;
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
            System.out.println("10. Logout");
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
     * Displays all customers.
     */
    private void viewAllCustomers() {
        System.out.println("\n=== View All Customers ===");
        for (Customer c : customers) {
            System.out.println(c.getName() + " - " + c.getEmail());
        }
    }

    /**
     * Adds a new movie to the list.
     *
     * @param scanner The Scanner object for user input.
     */
    private void addMovie(Scanner scanner) {
        System.out.println("\n=== Add New Movie ===");
        Movie newMovie = new Movie();
        newMovie.inputMovieDetails(); // Use the Movie class method to input details
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
                movie.inputMovieDetails(); // Reuse the method to update details
                System.out.println("Movie details updated successfully.");
                return;
            }
        }

        System.out.println("Movie not found.");
    }
}