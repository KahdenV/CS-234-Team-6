public class Guest extends Person {
    private String id; // Unique ID for the guest

    /**
     * Constructs a Guest with a given ID.
     *
     * @param id The unique guest identifier.
     */
    public Guest(String id) {
        super("Guest", "guest", "");
        this.id = id;
    }

    /**
     * Returns the guest's ID.
     *
     * @return The guest ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns a string representation of the guest.
     *
     * @return A string showing the guest ID.
     */
    @Override
    public String toString() {
        return "Guest ID: " + id;
    }
}