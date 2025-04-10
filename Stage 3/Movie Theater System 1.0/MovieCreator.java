import java.util.Scanner;
import java.util.Random;
public class MovieCreator
{
    public static Scanner in = new Scanner(System.in);


    private static String createMovieID(ArrayList<Movie> movie_list)
    {
        String characterSelection = "abcdefghijklmnopqrstuvwxyz123456789!#$%&?";
        StringBuilder ID_Generator = new StringBuilder();
        Random random = new Random();
        for (int counter = 0; counter <= 4; counter++)
        {
            int randomIndex = random.nextInt(characterSelection.length());
            ID_Generator.append(characterSelection.charAt(randomIndex));
        }
        String movieID = ID_generator.toString();

        for (int counter = 0; counter < movie_list.size(); counter++)
        {
            if (movie_list(counter).getMovieID() == movieID)
            {
                createMovieID(movie_list);
            }
        }

        return movieID;
    }


    private static String createMovieTitle()
    {
        System.out.printf("\nEnter film title (please be case-sensitive!): ");
        String movieTitle = in.nextLine();
        return movieTitle;
    }


    private static String createMovieGenres()
    {
        String movieGenres;
        String[] genreSelection = {"Action", "Adventure", "Animated", "Comedy", "Crime", "Documentary", "Drama", "Family", "Fantasy", "Historical", "Horror", "Musical", "Mystery", "Political", "Romance", "Sci-Fi", "Superhero", "Thriller", "War", "Western"};
        System.out.println("\nGenre Selection: ");
        printSelection(genreSelection);
        System.out.printf("\nPick genre one: ");
        int genre_one = movieScanner.nextInt()-1;
        System.out.printf("Pick genre two: ");
        int genre_two = movieScanner.nextInt()-1;

        if (genre_one > genreSelection.length || genre_two > genreSelection.length || genre_one == -1 || genre_two == -1)
        {
            System.out.println("\nInvalid choice.");
            createMovieGenres();
        }

        if (genre_one<genre_two) {movieGenres = genreSelection[genre_one] + ", " + genreSelection[genre_two];}
        else if (genre_one>genre_two) {movieGenres = genreSelection[genre_two] + ", " + genreSelection[genre_one];}
        else {movieGenres = genreSelection[genre_one];}
        return movieGenres;
    }


    private static int createMovieRuntime()
    {
        System.out.printf("\nEnter movie runtime (in minutes): ");
        int movieRuntime = movieScanner.nextInt();
        return movieRuntime;
    }


    private static String createMovieRating()
    {
        String[] ratingSelection = {"G", "PG", "PG-13", "R"};
        System.out.println("\nRating Selection: ");
        printSelection(ratingSelection);
        System.out.printf("\nPick film rating: ");
        int rating = movieScanner.nextInt();

        if (rating > ratingSelection.length || rating == 0)
        {
            System.out.println("Invalid entry.");
            setMovieRating();
        }

        String movieRating = ratingSelection[rating-1];
        return movieRating;
    }


    private static String createMovieReleaseDate()
    {
        System.out.printf("\nYear of release: ");
        int releaseYear = movieScanner.nextInt();
        System.out.printf("Month of release (in number format): ");
        int releaseMonth = movieScanner.nextInt();
        System.out.printf("Day of release: ");
        int releaseDate = movieScanner.nextInt();
        String movieReleaseDate = releaseMonth + "/" + releaseDate + "/" + releaseYear;
        return movieReleaseDate;
    }

    
    public static void printSelection(String[] printThisList)
    {
        for (int counter = 0; counter < printThisList.length; counter++)
        {
            System.out.println((counter+1) + ") " + printThisList[counter]);
        }
    }
}
