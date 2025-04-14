/**
 * Class representing a staff member, extends the Person class.
 */
public class Staff extends Person {

    /**
     * Constructs a Staff object with the provided name, email, and password.
     *
     * @param name     The name of the staff member.
     * @param email    The email of the staff member.
     * @param password The password for the staff member's account.
     */
    public Staff(String name, String email, String password) {
        super(name, email, password);
    }
}
