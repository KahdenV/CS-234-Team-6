/**
 * Represents a movie ticket purchased by a customer.
 */
public class Ticket {
    private String ticketId;
    private String customerId;
    private Showtime showtime;
    private Movie movie;

    /**
     * Constructs a new ticket with the given details.
     *
     * @param ticketId    Unique identifier for the ticket
     * @param customerId  ID of the customer who purchased the ticket
     * @param showtime    Showtime associated with the ticket
     * @param movie       Movie for which the ticket was issued
     */
    public Ticket(String ticketId, String customerId, Showtime showtime, Movie movie) {
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.showtime = showtime;
        this.movie = movie;
    }

    /**
     * @return The unique ticket ID
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * @return The ID of the customer who owns the ticket
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @return The showtime associated with this ticket
     */
    public Showtime getShowtime() {
        return showtime;
    }

    /**
     * @return The movie associated with this ticket
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Returns a string representation of the ticket details.
     */
    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
               ", User ID: " + customerId +
               ", Movie: " + movie.getMovieTitle() +
               ", Showtime: " + showtime.getTime();
    }
}
