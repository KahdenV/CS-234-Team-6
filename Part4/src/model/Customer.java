package model;



public class Customer extends Person {
    private String email;
    private String password;
    private String id; // Unique ID for the customer

    /**
     * Constructs a Customer with the specified details.
     *
     * @param id       The unique ID for the customer.
     * @param name     The customer's full name.
     * @param email    The customer's email address.
     * @param password The customer's password.
     */
    public Customer(String id, String name, String email, String password) {
        super(id); // Calls Person constructor
        this.id = id;                
        this.setName(name);        
        this.email = email;
        this.password = password;
    }


    /**
     * Retrieves the customer's unique ID.
     *
     * @return The customer's ID.
     */
    public String getCustomerId() {
        return id;
    }


    /**
     * Returns a string representation of the customer.
     *
     * @return A summary including ID, name, and email.
     */
    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + getName() + ", Email: " + getEmail();
    }
    

     /**
     * Returns the customer's email.
     *
     * @return The email address.
     */
    @Override
    public String getEmail() {
        return this.email;
    }


    /**
     * Returns the customer's password.
     *
     * @return The password.
     */
    @Override
    public String getPassword() {
        return this.password;
    }
}