import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map; // For the Map interface

/**
 * Displays the customer menu and handles customer actions.
 */
public class CustomerMenu {
    private List<Movie> movies;
    private ArrayList<Ticket> tickets;
    private ArrayList<Showtime> showtimes;
    private String customerId;
    private Map<String, Concession> concessions;
    private ArrayList<Customer> customers;

    public CustomerMenu(List<Movie> movies, String customerId, Map<String, Concession> concessions, ArrayList<Customer> customers) {
        this.movies = movies;
        this.customerId = customerId;
        this.concessions = concessions;
        this.customers = customers;
    }

    public void showCustomerMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. View All Movies");
            System.out.println("2. Search Movie");
            System.out.println("3. Book Ticket");
            System.out.println("4. View Order History");
            System.out.println("5. View Concessions");
            System.out.println("6. Purchase Concessions");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewAllMovies();
                    break;
                case 2:
                    searchMovie(scanner);
                    break;
                case 3:
                    bookTicket(scanner);
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
     * Books a ticket for the customer and processes the payment.
     *
     * @param scanner The Scanner object for user input.
     */
    private void bookTicket(Scanner scanner)
    {
        System.out.println("\n=== Book Ticket ===");
        Ticket newTicket = new Ticket();

        newTicket.setTicketID(createTicketID(tickets));

        System.out.printf("Would you like a list of movies currently showing?\n 1) Yes\n 2) No\n Input Answer: ");
        if (scanner.nextInt() == 1)
        {
            viewAllMovies();
        }

        newTicket.setShowtime(createTicketShowtime(movies, showtimes));

        if (movieTitleList.contains(movieTitle) !=  false)
        {
            System.out.printf("Movie " + movieTitle + "does not exist.\n 1) Start over\n2) Exit");
            if (scanner.nextInt() == 2)
            {
                return;
                bookTicket(scanner);
            }
            else
            {
                bookTicket(scanner);
            }
        }
        Movie desiredMovie = movies(movieTitleList.indexOf(movieTitle));

        System.out.printf("Would you like a list of showing times for that particular movie?\n 1) Yes\n 2) No\n Input Answer: ");
        if (scanner.nextInt() == 1)
        {
            for (int counter = 0; counter < showtimes.size(); counter++)
            {
                if (showtimes(counter).getShownMovie() == desiredMovie)
                {
                    System.out.println(showtimes(counter).getTime());
                }
            }
        }

        System.out.printf("Enter movie showtime to book: ");
        String desiredTime = scanner.nextLine();
        for (int counter = 0; counter<showtimes.size(); counter++)
        {
            if (showtimes(counter).getShownMovie() == desiredMovie && showtimes(counter).getTime == desiredTime)
            {
                Showtime desiredShowtime = showtimes(counter);
                newTicket.setShowtime(desiredShowtime);
                break;
            }

            else if (counter+1 == showtimes.size())
            {
                System.out.printf("Desired showtime does not exist!\n1) Start over\n2) Exit");
                if (scanner.nextInt() == 2) {return;}
                else {bookTicket(scanner);}
            }
        }


        for (Movie movie : movies) {
            if (movie.getMovieTitle().equalsIgnoreCase(movieTitle)) {
                System.out.print("Enter ticket price: ");
                double ticketPrice = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                // Process payment
                Payment payment = Payment.processPayment(customerId, ticketPrice);
                System.out.println("Ticket booked successfully! Payment ID: " + payment.getPaymentId());
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
        if (concessions.isEmpty()) {
            System.out.println("No concession items available.");
        } else {
            for (Concession item : concessions.values()) {
                System.out.println(item.getConcessionId() + ": " + item.getItemName() + " - $" + item.getPrice());
            }
        }
    }


    /**
     * Allows the customer to purchase a concession item and processes the payment.
     *
     * @param scanner The Scanner object for user input.
     */
    private void purchaseConcessions(Scanner scanner) {
        System.out.println("\n=== Purchase Concessions ===");
        System.out.print("Enter the item ID to purchase: ");
        String itemId = scanner.nextLine();

        Concession item = Concession.getConcessionMenu().get(itemId);
        if (item != null) {
            // Process payment
            Payment payment = Payment.processPayment(customerId, item.getPrice());
            System.out.println("Concession purchased successfully! Payment ID: " + payment.getPaymentId());
        } else {
            System.out.println("Concession item not found.");
        }
    }
}