package model;



import model.Concession;
import model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Displays the staff menu and handles staff actions.
 */
public class StaffMenu {
    private List<Staff> staff;
    private List<Customer> customers;
    private List<Movie> movies;
    private Map<String, Concession> concessions;
    private List<Screen> screens;
    private List<Showtime> showtimes;

    // Updated constructor to match the call in MovieTheaterSystem
    public StaffMenu(List<Staff> staff, List<Customer> customers, List<Movie> movies, Map<String, Concession> concessions, List<Screen> screens, List<Showtime> showtimes) {
        this.staff = staff;
        this.customers = customers;
        this.movies = movies;
        this.concessions = concessions;
        this.screens = screens;
        this.showtimes = showtimes;
    }


    /**
     * Method for displaying staff menu - leads to submenus.
     */
    public void showStaffMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Staff Menu ===");
            System.out.println("1. Manage Staff");
            System.out.println("2. Manage Screens and Showtimes");
            System.out.println("3. Manage Movies");
            System.out.println("4. Manage Concessions");
            System.out.println("5. Manage Refunds");
            System.out.println("6. View All Customers");
            System.out.println("7. View Payments");
            System.out.println("8. Log Out");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    staffOptions(scanner); // Call submenu
                    break;
                case 2:
                    screenShowtimeOptions(scanner); // Call submenu
                    break;
                case 3:
                    movieOptions(scanner); // Call submenu
                    break;
                case 4:
                    concessionsOptions(scanner); // Call submenu
                    break;
                case 5:
                    manageRefunds(scanner);
                    break;
                case 6:
                    viewAllCustomers();
                    break;
                case 7:
                    viewPayments();
                    break;
                case 8:
                    running = false; // Log out and return to the login menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    /**
     * Submenu for managing staff.
     * @param scanner
     */
    public void staffOptions(Scanner scanner)
    {
        boolean running = true;
        while(running)
        {
            System.out.println("\n=== Staff Manager Menu ===");
            System.out.println("1. View All Staff");
            System.out.println("2. Add New Staff");
            System.out.println("3. Remove Staff");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

            switch (choice)
            {
                case 1:
                    viewAllStaff();
                    break;
                case 2:
                    addStaff(scanner);
                    break;
                case 3:
                    removeStaff(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    /**
     * Displays all staff members.
     */
    private void viewAllStaff()
    {
        System.out.println("\n=== View All Staff ===");
        for (Staff s : staff)
        {
            System.out.println(s.getName() + " - " + s.getEmail());
        }
    }


    /**
     * Adds a new staff member.
     * @param scanner
     */
    private void addStaff(Scanner scanner) {
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
     * Removes a staff member.
     * @param scanner
     */
    private void removeStaff(Scanner scanner)
    {
        System.out.println("\n=== Remove Staff ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        for (Staff s: staff)
        {
            if (s.getName().equals(name))
            {
                staff.remove(staff.indexOf(s));
                System.out.println("Staff member removed successfully.");
                return;
            }
            
        }
        System.out.println("Staff member does not exist.");
    }


    /**
     * Submenu for managing screens and showtimes
     * @param scanner
     */
    public void screenShowtimeOptions(Scanner scanner)
    {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Screen Manager Menu ===");
            System.out.println("1. View All Screens");
            System.out.println("2. Add New Screen");
            System.out.println("3. Edit a Screen");
            System.out.println("4. Delete a Screen");
            System.out.println("5. View All Showtimes");
            System.out.println("6. Create and Assign Showtime");
            System.out.println("7. Delete a Showtime");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayScreens();
                    break;
                case 2:
                    addScreen(scanner);
                    break;
                case 3:
                    updateScreen(scanner);
                    break;
                case 4:
                    deleteScreen(scanner);
                    break;
                case 5:
                    displayShowtimes();
                    break;
                case 6:
                    createAndAssignShowtime(scanner);
                    break;
                case 7:
                    deleteShowtime(scanner);
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting Staff Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    /**
     * Displays all existing screens.
     */
    public void displayScreens()
    {
        System.out.println("\n=== View All Screens ===");
        if (screens.isEmpty())
        {
            System.out.println("No screens available.");
        }
        else
        {
            for (Screen screen : screens)
            {
                System.out.println(screen.toString());
            }
        }
    }


    /**
     * Method to create a new screen.
     * @param screenId
     * @param capacity
     */
    public void addScreen(Scanner scanner)
    {
        System.out.println("\n=== Add New Screen ===");
        System.out.print("Enter screen ID: ");
        String screenId = scanner.nextLine();
        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        Screen screen = new Screen(screenId, capacity);
        screens.add(screen);
        System.out.println("New screen added successfully: " + screenId);
    }


    /**
     * Method to edit a screen's details.
     * @param scanner
     */
    private void updateScreen(Scanner scanner)
    {
        System.out.println("\n=== Update Screen ===");
        System.out.print("Enter screen ID to edit: ");
        String editScreenId = scanner.nextLine();
        boolean screenFound = false;

        for (Screen screen : screens)
        {
            if (screen.getScreenNumber().equals(editScreenId))
            {
                screenFound = true;
                System.out.println("1. Update Available Seats");
                System.out.println("2. Add a Showtime");
                System.out.print("Enter your choice: ");
                int editChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (editChoice == 1)
                {
                    System.out.println("Enter new available seats: ");
                    int availableSeats = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    screen.updateAvailableSeats(availableSeats);
                }

                else if (editChoice == 2)
                {
                    createAndAssignShowtime(scanner);
                }

                else
                {
                    System.out.println("Invalid option.");
                }

                break;
            }
        }

        if (!screenFound)
        {
            System.out.println("Screen not found.");
        }
    }
    

    /*
     * Method to delete a screen.
     */
    private void deleteScreen(Scanner scanner)
    {
        System.out.println("\n=== Delete Screen ===");
        System.out.println("Enter screen ID to delete: ");
        String deleteID = scanner.nextLine();
        for (Screen s: screens)
        {
            if (s.getScreenNumber().equals(deleteID))
            {
                screens.remove(screens.indexOf(s));
                System.out.println("Screen deleted successfully.");
                return;
            }
        }

        System.out.println("Screen not found.");
    }


    /**
     * Method to display all existing showtimes.
     */
    private void displayShowtimes()
    {
        System.out.println("\n=== View All Showtimes ===");
        if (showtimes.isEmpty())
        {
            System.out.println("No showtimes available.");
        }
        else 
        {
            for (Showtime s : showtimes) 
            {
                System.out.println("Movie: " + s.getShownMovie().getMovieTitle() + ", Time: " + s.getTime() + ", Screen: " + s.getShowingScreen());
            }
        }
    }


    /**
     * Method to create a new showtime.
     * @param scanner
     */
    private void createAndAssignShowtime(Scanner scanner)
    {
        System.out.println("\n=== Create and Assign Showtime ===");
    
        // Ensure movies exist
        if (movies.isEmpty())
        {
            System.out.println("No movies available. Please add movies first.");
            return;
        }
    
        // Display available movies
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++)
        {
            System.out.println((i + 1) + ". " + movies.get(i).getMovieTitle());
        }
    
        // Select a movie
        System.out.print("Select a movie by number: ");
        int movieChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        if (movieChoice < 1 || movieChoice > movies.size())
        {
            System.out.println("Invalid selection.");
            return;
        }
        Movie selectedMovie = movies.get(movieChoice - 1);
    
        // Create showtime
        System.out.print("Enter showtime (e.g., '12:00 PM'): ");
        String showtimeTime = scanner.nextLine();
    
        // Ensure screens exist
        if (screens.isEmpty())
        {
            System.out.println("No screens available. Please add screens first.");
            return;
        }
    
        // Display available screens
        System.out.println("Available Screens:");
        for (int i = 0; i < screens.size(); i++)
        {
            System.out.println((i + 1) + ". " + screens.get(i).getScreenNumber());
        }
    
        // Select a screen
        System.out.print("Select a screen by number: ");
        int screenChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        if (screenChoice < 1 || screenChoice > screens.size())
        {
            System.out.println("Invalid selection.");
            return;
        }
        Screen selectedScreen = screens.get(screenChoice - 1);
        screens.get(screenChoice - 1).assignShowTime(showtimeTime);
    
        // Create and save the new showtime
        Showtime newShowtime = new Showtime(selectedMovie, selectedScreen, showtimeTime, List.of("A0"));
        showtimes.add(newShowtime);

    
        System.out.println("Showtime '" + showtimeTime + "' assigned to screen '" + selectedScreen.getScreenNumber() + "' for movie '" + selectedMovie.getMovieTitle() + "'.");
    }


    /**
     * Method to delete a showtime.
     * @param scanner
     */
    private void deleteShowtime(Scanner scanner)
    {
        System.out.println("\n=== Delete Showtime ===");
        System.out.println("Enter movie for the showtime you want to delete: ");
        String title = scanner.nextLine();
        System.out.println("Enter time for the showtime you want to delete: ");
        String time = scanner.nextLine();
        System.out.println("Enter screen for the showtime you want to delete: ");
        String screen = scanner.nextLine();
        for (Showtime s: showtimes)
        {
            if (s.getShownMovie().getMovieTitle().equals(title) && s.getTime().equals(time) && s.getShowingScreen().getScreenNumber().equals(screen))
            {
                showtimes.remove(s);
                System.out.println("Showtime deleted successfully.");
            }
        }
    }


    /**
     * Submenu for managing movies.
     * @param scanner
     */
    public void movieOptions(Scanner scanner)
    {
        boolean running = true;
        while(running)
        {
            System.out.println("\n=== Movie Manager Menu ===");
            System.out.println("1. View All Movies");
            System.out.println("2. Add New Movie");
            System.out.println("3. Update Movie");
            System.out.println("4. Remove Movie");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice)
            {
                case 1:
                    viewAllMovies();
                    break;
                case 2:
                    addMovie(scanner);
                    break;
                case 3:
                    updateMovie(scanner);
                    break;
                case 4:
                    removeMovie(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays all movies.
     */
    public void viewAllMovies()
    {
        System.out.println("\n=== View All Movies ===");
        if (movies.isEmpty())
        {
            System.out.println("No movies available.");
        }
        else 
        {
            for (Movie m : movies) 
            {
                m.printMovieDetails();
            }
        }
    }


    /**
    * Adds a new movie to the list.
    * @param scanner The Scanner object for user input.
    */
    private void addMovie(Scanner scanner) {
        System.out.println("\n=== Add New Movie ===");
    
        // Create a new movie instance
        Movie newMovie = new Movie();

        // Set ID
        newMovie.setMovieID(movies.get(movies.size()-1).getMovieID());
    
        // Set title
        newMovie.setMovieTitle();
    
        // Set genre using predefined selections
        newMovie.setMovieGenres();
    
        // Set runtime (direct input)
        System.out.print("Enter movie runtime (in minutes): ");
        int runtime = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        newMovie.movieRuntime = runtime; // Directly set runtime instead of using setMovieRuntime()
    
        // Set rating using predefined selections
        newMovie.setMovieRating();
    
        // Set release date
        newMovie.setMovieReleaseDate();
    
        // Add new movie to the list
        movies.add(newMovie);
    
        System.out.println("New movie added successfully.");
    }


    /**
     * Updates an existing movie.
     * @param scanner The Scanner object for user input.
     */
    private void updateMovie(Scanner scanner)
    {
        System.out.println("\n=== Update Movie ===");
        System.out.print("Enter the movie title to update: ");
        String title = scanner.nextLine();

        for (Movie movie : movies)
        {
            boolean running = true;
            while(running)
            {
                if (movie.getMovieTitle().equalsIgnoreCase(title))
                {
                    System.out.println("1. Update name");
                    System.out.println("2. Update genre");
                    System.out.println("3. Update runtime");
                    System.out.println("4. Update rating");
                    System.out.println("5. Update release date");
                    System.out.println("6. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    switch(choice)
                    {
                        case 1:
                            movie.setMovieTitle();
                            break;
                        case 2:
                            movie.setMovieGenres();
                            break;
                        case 3:
                            movie.setMovieRuntime();
                            break;
                        case 4:
                            movie.setMovieRating();
                            break;
                        case 5:
                            movie.setMovieReleaseDate();
                            break;
                        case 6:
                            running = false;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
            return;
        }
        System.out.println("Movie not found.");
    }


    /**
     * Deletes movie from list.
     * @param scanner
     */
    public void removeMovie(Scanner scanner)
    {
        Iterator<Movie> iter = movies.iterator();
        System.out.println("\n=== Delete Movie ===");
        System.out.print("Enter movie to delete: ");
        String deleteMovie = scanner.nextLine();
        while (iter.hasNext())
        {
            Movie removeMovie = iter.next();
            if (iter.next().getMovieTitle().equalsIgnoreCase(deleteMovie))
            {
                movies.remove(removeMovie);
                System.out.println("Movie deleted successfully.");
                break;
            }
        }
    }


    /**
     * Submenu for managing concessions.
     * @param scanner
     */
    public void concessionsOptions(Scanner scanner)
    {
        boolean running = true;
        while(running)
        {
            System.out.println("\n=== Concessions Manager Menu ===");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Stock");
            System.out.println("3. Update Stock");
            System.out.println("4. Remove Stock");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

            switch (choice)
            {
                case 1:
                    viewInventory();
                    break;
                case 2:
                    addStock(scanner);
                    break;
                case 3:
                    updateStock(scanner);
                    break;
                case 4:
                    removeStock(scanner);
                    break;
                case 5:
                    running = false;
                    break;
            }
        }
    }


    /**
     * Displays all concession items as inventory.
     */
    private void viewInventory() {
        System.out.println("\n=== Inventory ===");
        if (concessions.isEmpty()) {
            System.out.println("No concession items available.");
        } else {
            for (Concession item : concessions.values()) {
                System.out.println(item.getConcessionId() + ": " + item.getItemName() + " - $" + item.getPrice());
            }
        }
    }


    /**
     * Adds a new concession item to the inventory.
     *
     * @param scanner The Scanner object for user input.
     */
    private void addStock(Scanner scanner) {
        System.out.println("\n=== Add Stock ===");
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Concession.addItem(itemId, itemName, price);
    }


    /**
     * Updates an existing concession item in the inventory.
     *
     * @param scanner The Scanner object for user input.
     */
    private void updateStock(Scanner scanner) {
        System.out.println("\n=== Update Stock ===");
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter new item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter new item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Concession.updateItem(itemId, itemName, price);
    }

    private void removeStock(Scanner scanner)
    {
        System.out.println("\n=== Delete Stock===");
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        for (Concession item : concessions.values())
        {
            if (item.getConcessionId().equals(itemId))
            {
                concessions.remove(item);
            }
        }
    }

    /**
     * Displays all customers with their IDs and names.
     */
    private void viewAllCustomers() {
        System.out.println("\n=== View All Customers ===");
        for (Customer c : customers) {
            System.out.println(c.getCustomerId() + " - " + c.getName() + " (" + c.getEmail() + ")");
        }
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
}