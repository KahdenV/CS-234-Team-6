package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;

/**
 * Represents a scheduled movie showtime within a specific screen.
 */
public class Showtime {

    protected String showtimeID;
    protected Movie shownMovie;
    protected Screen showingScreen;
    protected String time;
    private static List<Showtime> showtimeList = new ArrayList<>();
    private List<String> availableSeats; // Now stores actual seat IDs

    /**
     * Constructs a new showtime with seats.
     *
     * @param shownMovie    The movie being shown.
     * @param showingScreen The screen where the movie is shown.
     * @param time          The time of the show.
     * @param seats         List of available seat IDs.
     */
    public Showtime(Movie shownMovie, Screen showingScreen, String time, List<String> seats) {
        this.shownMovie = shownMovie;
        this.showingScreen = showingScreen;
        this.time = time;
        this.availableSeats = new ArrayList<>(seats);
        showtimeList.add(this);
    }

    public static List<Showtime> getShowtimeList() {
        return new ArrayList<>(showtimeList);
    }

    public Movie getShownMovie() {
        return shownMovie;
    }

    public Screen getShowingScreen() {
        return showingScreen;
    }

    public String getTime() {
        return time;
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

    public List<String> getAvailableSeats() {
        return availableSeats;
    }
    

    public int getAvailableSeatCount() {
        return availableSeats.size();
    }

    /**
     * Decreases the number of available seats by removing one seat.
     */
    public void decreaseAvailableSeats() {
        if (!availableSeats.isEmpty()) {
            availableSeats.remove(0); // Removes first available seat
        }
    }

    public void printShowtimeDetails() {
        System.out.println("Movie being shown: " + shownMovie.getMovieTitle());
        System.out.println("Screen number: " + showingScreen.getScreenNumber());
        System.out.println("Time: " + time);
    }

    @Override
    public String toString() {
        return "Movie: " + shownMovie.getMovieTitle() +
               ", Time: " + time +
               ", Screen: " + showingScreen.getScreenNumber() +
               ", Available Seats: " + availableSeats.size();
    }
}
