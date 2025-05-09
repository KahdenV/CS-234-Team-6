package model;



/**
 * Class representing a person with basic information.
 */
public class Person {
    private static int idCounter = 1; 
    private String id; // Declare the id field
    private String name;
    private String email;
    private String password;

    /**
     * Constructor for creating a person with name, email, and password.
     *
     * @param name     The name of the person.
     * @param email    The email address.
     * @param password The password.
     */
    public Person(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Generates a unique customer ID.
     *
     * @return A unique ID string.
     */
    protected static synchronized String generateUniqueId() {
        return "Customer" + (idCounter++); 
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return this.id; // Replace with your actual ID retrieval logic
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Constructor for assigning a predefined ID to the person.
     *
     * @param id The unique identifier.
     */
    public Person(String id) {
        this.id = id; // Initialize the id field in the constructor
    }

    public void setId(String id) {
        this.id = id; // Provide a setter method if needed
    }
}