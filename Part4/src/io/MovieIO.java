package io;

import model.Movie;
import java.io.*;
import java.util.*;

public class MovieIO {

    public static List<Movie> loadMovies(String filename) {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 7) {
                    Movie movie = new Movie();
                    movie.setMovieID(parts[0]);
                    movie.setMovieTitleFromFile(parts[1]);
                    movie.setMovieGenresFromFile(parts[2]);
                    movie.setMovieRuntimeFromFile(Integer.parseInt(parts[3].trim()));
                    movie.setMovieRatingFromFile(parts[4]);
                    movie.setMovieReleaseDateFromFile(parts[5]);
                    movie.setMoviePrice(Double.parseDouble(parts[6].trim()));
                    movies.add(movie);
                } else {
                    System.out.println("⚠️ Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public static void saveMovies(String filename, List<Movie> movies) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Movie m : movies) {
                writer.write(String.join(";",
                    m.getMovieID(), m.getMovieTitle(), m.getMovieGenres(),
                    String.valueOf(m.getMovieRuntime()), m.getMovieRating(),
                    m.getMovieReleaseDate(), String.valueOf(m.getMoviePrice())));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
