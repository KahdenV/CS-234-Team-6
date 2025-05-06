package service;

import model.Staff;
import model.Guest;
import model.Customer;
import model.Person;
import java.util.List;

/**
 * Handles authentication and account management for customers, staff, and guests.
 */

public class AuthenticationService {
    private List<Customer> customers;
    private List<Staff> staff;
    private int guestCounter = 1; // Track guest IDs


    /**
     * Constructs the authentication service with existing customer and staff lists,
     * and loads additional dummy data.
     *
     * @param customers The list of customers.
     * @param staff The list of staff members.
     */
    public AuthenticationService(List<Customer> customers, List<Staff> staff) {
        this.customers = customers;
        this.staff = staff;
    }


    /**
     * Retrieves the list of customers.
     *
     * @return List of customers.
     */
    public List<Customer> getCustomers() {
        return customers;
    }


    /**
     * Adds a new customer to the system.
     *
     * @param customer The customer to add.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer); // Add new customer to the list
    }


    /**
     * Logs in a guest user by generating a unique guest ID.
     *
     * @return A Guest object.
     */
    public Guest loginAsGuest() {
        String guestId = "guest" + guestCounter++;
        return new Guest(guestId); 
    }


    /**
     * Authenticates a user by matching credentials against customer and staff records.
     *
     * @param username The email or username.
     * @param password The password.
     * @return A valid Person object if authentication succeeds, otherwise null.
     */
    public Person authenticate(String username, String password) {
        for (Customer customer : customers) {
            if (customer.getEmail() != null && customer.getPassword() != null &&
                customer.getEmail().equals(username) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        for (Staff staffMember : staff) {
            System.out.println("Checking staff: " + staffMember.getEmail() + ", " + staffMember.getPassword());

            if (staffMember.getEmail() != null && staffMember.getPassword() != null &&
                staffMember.getEmail().equals(username) && staffMember.getPassword().equals(password)) {
                return staffMember;
            }
        }
        return null; // Authentication failed
    }
}