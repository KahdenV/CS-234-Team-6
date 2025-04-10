import java.util.Scanner;
public class Movie
{
    // Movie class 
    protected String movieID;
    protected String movieTitle;
    protected String movieGenres;
    protected int movieRuntime;
    protected String movieRating;
    protected String movieReleaseDate;
    protected Scanner movieScanner;


    // Initialize the Movie class
    public Movie()
    {
    }



    public String getMovieID()
    {
        return movieID;
    }



    public String getMovieTitle()
    {
        return movieTitle;
    }



    public String getMovieGenres()
    {
        return movieGenres;
    }



    public int getMovieRuntime()
    {
        return movieRuntime;
    }



    public String getMovieRating()
    {
        return movieRating;
    }



    public String getMovieReleaseDate()
    {
        return movieReleaseDate;
    }



    public void setMovieID(String newID)
    {
        movieID = newID;
    }



    public void setMovieTitle(String newTitle)
    {
        movieTitle = newTitle;
    }



    public void setMovieGenres(String newGenres)
    {
        movieGenres = newGenres;
    }



    public void setMovieRuntime(int newRuntime)
    {
        movieRuntime = newRuntime;
    }



    public void setMovieRating(String newRating)
    {
        movieRating = newRating;
    }



    public void setMovieReleaseDate(String newReleaseDate)
    {
        movieReleaseDate = newReleaseDate;
    }



    public void printMovieDetails()
    {
        System.out.println("\n\n" + movieTitle + ":\n");
        System.out.println("Rating: " + movieRating);
        System.out.println("Released: " + movieReleaseDate);
        System.out.println("Runtime: " + movieRuntime + " minutes");
        System.out.println("Genre: " + movieGenres);
    }
}
