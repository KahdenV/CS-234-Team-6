import java.util.ArrayList;
import java.util.List;

/**
 * Represents a theater screen with seating capacity and associated showtimes.
 */
public class Screen {
    private String screenId;
    private int capacity;
    private int availableSeats;
    private List<String> showTimes = new ArrayList<>();
    private static List<Screen> screens = new ArrayList<>();

    /**
     * Constructs a new Screen and registers it in the static screen list.
     *
     * @param screenId The identifier for the screen.
     * @param capacity The seating capacity of the screen.
     */
    public Screen(String screenId, int capacity) {
        this.screenId = screenId;
        this.capacity = capacity;
        this.availableSeats = capacity;
        screens.add(this);
    }

    /**
     * Returns a copy of the list of all registered screens.
     *
     * @return List of screens.
     */
    public static List<Screen> getScreens() {
        return new ArrayList<>(screens);
    }

    /**
     * Adds a showtime string to this screen.
     *
     * @param showtime The showtime to add.
     */
    public void addShowtime(String showtime) {
        showTimes.add(showtime);
    }

    public String getScreenId() {
        return screenId;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Returns a copy of this screen's showtimes.
     *
     * @return List of showtime strings.
     */
    public List<String> getShowTimes() {
        return new ArrayList<>(showTimes);
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    /**
     * Updates the number of available seats, if within valid bounds.
     *
     * @param seats The new seat count.
     */
    public void updateAvailableSeats(int seats) {
        if (seats > this.capacity || seats < 0) {
            System.out.println("Invalid number of seats. Must be between 0 and " + this.capacity);
        } else {
            this.availableSeats = seats;
        }
    }

    /**
     * Assigns a new showtime to this screen.
     *
     * @param showTime The time to add.
     */
    public void assignShowTime(String showTime) {
        this.showTimes.add(showTime);
    }

    /**
     * Returns a string with screen details.
     *
     * @return String summary of the screen.
     */
    @Override
    public String toString() {
        return "Screen ID: " + screenId + ", Capacity: " + capacity + ", Available Seats: " + availableSeats +
                ", Showtimes: " + showTimes;
    }
}
