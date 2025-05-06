package io;

import model.Customer;
import model.Staff;
import model.Movie;

import java.util.List;

public class IOTester {

    public static void testCustomerIO() {
        List<Customer> customers = List.of(
            new Customer("C001", "Alice", "alice@example.com", "password123"),
            new Customer("C002", "Bob", "bob@example.com", "pass456")
        );

        String filename = "customers_test.txt";
        CustomerIO.saveCustomers(filename, customers);
        List<Customer> loaded = CustomerIO.loadCustomers(filename);

        System.out.println("✅ Loaded Customers:");
        for (Customer c : loaded) {
            System.out.println(c.getId() + " " + c.getName() + " " + c.getEmail());
        }
    }

    public static void testStaffIO() {
        List<Staff> staffList = List.of(
            new Staff("Manager", "manager@cinema.com", "adminpass"),
            new Staff("Clerk", "clerk@cinema.com", "clerkpass")
        );

        String filename = "staff_test.txt";
        StaffIO.saveStaff(filename, staffList);
        List<Staff> loaded = StaffIO.loadStaff(filename);

        System.out.println("✅ Loaded Staff:");
        for (Staff s : loaded) {
            System.out.println(s.getName() + " " + s.getEmail());
        }
    }

    public static void testMovieIO() {
        Movie m1 = new Movie();
        m1.setMovieID("001");
        m1.setMovieTitleFromFile("Inception");
        m1.setMovieGenresFromFile("Action, Sci-Fi");
        m1.setMovieRuntimeFromFile(148);
        m1.setMovieRatingFromFile("PG-13");
        m1.setMovieReleaseDateFromFile("7/16/2010");
        
        Movie m2 = new Movie();
        m2.setMovieID("002");
        m2.setMovieTitleFromFile("Inception");
        m2.setMovieGenresFromFile("Action, Sci-Fi");
        m2.setMovieRuntimeFromFile(148);
        m2.setMovieRatingFromFile("PG-13");
        m2.setMovieReleaseDateFromFile("7/16/2010");

        String filename = "movies_test.txt";
        MovieIO.saveMovies(filename, List.of(m1,m2));
        List<Movie> loaded = MovieIO.loadMovies(filename);

        System.out.println("✅ Loaded Movies:");
        for (Movie m : loaded) {
            System.out.println(m.getMovieID() + " " + m.getMovieTitle() + " " + m.getMovieGenres());
        }
    }
}
