import java.util.Scanner;

/**
 * Represents a movie with attributes and user input capabilities.
 */
public class Movie {
    protected String movieID;
    protected String movieTitle;
    protected String movieGenres;
    protected int movieRuntime;
    protected String movieRating;
    protected String movieReleaseDate;
    protected Scanner movieScanner;

    /**
     * Default constructor initializing a Scanner.
     */
    public Movie() {
        movieScanner = new Scanner(System.in);
    }

    /**
     * Constructor with movie title, genre, and runtime.
     *
     * @param title   The title of the movie.
     * @param genres  The genres of the movie.
     * @param runtime The duration in minutes.
     */
    public Movie(String title, String genres, int runtime) {
        this.movieTitle = title;
        this.movieGenres = genres;
        this.movieRuntime = runtime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Movie movie = (Movie) obj;
        return movieID.equals(movie.movieID);
    }

    @Override
    public int hashCode() {
        return movieID.hashCode();
    }

    /**
     * Prompts the user to input all details for a new movie.
     */
    public void inputMovieDetails() {
        System.out.println("Enter information for new movie: \n");
        movieScanner = new Scanner(System.in);

        System.out.print("Enter movie title: ");
        String title = movieScanner.nextLine();
        setMovieTitle(title);

        setMovieGenres();
        setMovieRuntime();
        setMovieRating();
        setMovieReleaseDate();
    }

    public String getMovieID() { return movieID; }
    public String getMovieTitle() { return movieTitle; }
    public String getMovieGenres() { return movieGenres; }
    public int getMovieRuntime() { return movieRuntime; }
    public String getMovieRating() { return movieRating; }
    public String getMovieReleaseDate() { return movieReleaseDate; }

    public void setMovieID(String replace_movieID) { movieID = replace_movieID; }
    public void setMovieTitle(String newTitle) { this.movieTitle = newTitle; }

    /**
     * Prompts the user to choose genres from a predefined list.
     */
    public void setMovieGenres() {
        String[] genreSelection = {"Action", "Adventure", "Animated", "Comedy", "Crime", "Documentary", "Drama",
                                   "Family", "Fantasy", "Historical", "Horror", "Musical", "Mystery", "Political",
                                   "Romance", "Sci-Fi", "Sports", "Thriller", "War", "Western"};
        System.out.println("\nGenre Selection: ");
        printSelection(genreSelection);
        System.out.printf("\nPick genre one: ");
        int genre_one = movieScanner.nextInt() - 1;
        System.out.printf("Pick genre two: ");
        int genre_two = movieScanner.nextInt() - 1;

        if (genre_one > genreSelection.length || genre_two > genreSelection.length || genre_one == -1 || genre_two == -1) {
            System.out.println("\nInvalid choice.");
            setMovieGenres();
        }

        if (genre_one < genre_two) {
            movieGenres = genreSelection[genre_one] + ", " + genreSelection[genre_two];
        } else if (genre_one > genre_two) {
            movieGenres = genreSelection[genre_two] + ", " + genreSelection[genre_one];
        } else {
            movieGenres = genreSelection[genre_one];
        }
    }

    /**
     * Prompts the user to input the runtime of the movie.
     */
    public void setMovieRuntime() {
        System.out.printf("\nEnter movie runtime (in minutes): ");
        movieRuntime = movieScanner.nextInt();
    }

    /**
     * Prompts the user to choose a rating from predefined options.
     */
    public void setMovieRating() {
        String[] ratingSelection = {"G", "PG", "PG-13", "R"};
        System.out.println("\nRating Selection: ");
        printSelection(ratingSelection);
        System.out.printf("\nPick film rating: ");
        int rating = movieScanner.nextInt();

        if (rating > ratingSelection.length || rating == 0) {
            System.out.println("Invalid entry.");
            setMovieRating();
        }

        movieRating = ratingSelection[rating - 1];
    }

    /**
     * Prompts the user to enter the release date of the movie.
     */
    public void setMovieReleaseDate() {
        System.out.printf("\nYear of release: ");
        int releaseYear = movieScanner.nextInt();
        System.out.printf("Month of release (in number format): ");
        int releaseMonth = movieScanner.nextInt();
        System.out.printf("Day of release: ");
        int releaseDate = movieScanner.nextInt();
        movieReleaseDate = releaseMonth + "/" + releaseDate + "/" + releaseYear;
    }

    /**
     * Prints a numbered list of options to the console.
     *
     * @param printThisList The array of strings to display.
     */
    public void printSelection(String[] printThisList) {
        for (int counter = 0; counter < printThisList.length; counter++) {
            System.out.println((counter + 1) + ") " + printThisList[counter]);
        }
    }

    /**
     * Displays all movie details in formatted output.
     */
    public void printMovieDetails() {
        System.out.println("\n\n" + movieTitle + ":\n");
        System.out.println("Rating: " + movieRating);
        System.out.println("Released: " + movieReleaseDate);
        System.out.println("Runtime: " + movieRuntime + " minutes");
        System.out.println("Genre: " + movieGenres);
    }
}