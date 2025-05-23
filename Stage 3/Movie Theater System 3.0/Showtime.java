import java.util.ArrayList;
import java.util.List;


/**
 * Represents a scheduled movie showtime within a specific screen.
 */
public class Showtime {

    protected String showtimeID;
    protected Movie shownMovie;
    protected Screen showingScreen;
    protected String time;
    private static List<Showtime> showtimeList = new ArrayList<>(); // Static list to store all showtimes
    private int availableSeats;

    /**
     * Constructs a new showtime and registers it in the showtime list.
     *
     * @param shownMovie     The movie being shown.
     * @param showingScreen  The screen where the movie is shown.
     * @param time           The time of the show.
     */
    public Showtime(Movie shownMovie, Screen showingScreen, String time) {
        this.shownMovie = shownMovie;
        this.showingScreen = showingScreen;
        this.time = time;
        showtimeList.add(this); // Add the new showtime to the list
        this.availableSeats = showingScreen.getCapacity(); // Set available seats to screen capacity
    }

    /**
     * Returns a list of all showtimes.
     *
     * @return A copy of the global showtime list.
     */
    public static List<Showtime> getShowtimeList() {
        return new ArrayList<>(showtimeList); // Return a copy to preserve encapsulation
    }

    // Getter and Setter methods
    public Movie getShownMovie() {
        return shownMovie;
    }

    public Screen getShowingScreen() {
        return showingScreen;
    }

    public String getTime() {
        return time;
    }


    public void setShowtimeID()
    {

    }

    public void setShownMovie(Movie newShownMovie) {
        shownMovie = newShownMovie;
    }

    public void setShowingScreen(Screen newShowingScreen) {
        showingScreen = newShowingScreen;
    }

    public void setTime(String newTime) {
        time = newTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

     /**
     * Decreases the number of available seats by the given quantity.
     *
     * @param numberOfSeats Number of seats to reduce.
     */
    public void reduceAvailableSeats(int numberOfSeats) {
        if (availableSeats >= numberOfSeats) {
            availableSeats -= numberOfSeats;
        } else {
            System.out.println("Not enough seats available.");
        }
    }

    /**
     * Prints a summary of this showtime's details.
     */
    public void printShowtimeDetails() {
        System.out.println("Movie being shown: " + shownMovie.getMovieTitle());
        System.out.println("Screen number: " + showingScreen.getScreenNumber());
        System.out.println("Time: " + time);
    }

    /**
     * Returns a string representation of this showtime.
     *
     * @return Summary string with movie title, time, screen, and seats.
     */
    @Override
    public String toString() {
        return "Movie: " + shownMovie.getMovieTitle() +
            ", Time: " + time +
            ", Screen: " + showingScreen.getScreenNumber() +
            ", Available Seats: " + availableSeats;
    }
}