/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;

import model.Movie;
import model.Screen;
import model.Showtime;
import java.io.*;
import java.util.*;

/**
 * ShowtimeIO handles loading and saving showtime data from text files.
 * Format: movieID;theaterID;timeRange
 * Example: 004;02;2:00 PM - 4:00 PM
 *
 * @author Kahden Vienna
 */
public class ShowtimeIO {
    public static List<Showtime> loadShowtimes(String filename, List<Movie> movies, List<Screen> screens) {
        List<Showtime> showtimes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";"); // movieID;theaterID;timeRange
                if (parts.length == 3) {
                    String movieID = parts[0];
                    String screenID = parts[1];
                    String timeRange = parts[2];

                    Movie movie = movies.stream().filter(m -> m.getMovieID().equals(movieID)).findFirst().orElse(null);
                    Screen screen = screens.stream().filter(s -> s.getScreenNumber().equals(screenID)).findFirst().orElse(null);

                    if (movie != null && screen != null) {
                        showtimes.add(new Showtime(movie, screen, timeRange));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return showtimes;
    }

    public static void saveShowtimes(String filename, List<Showtime> showtimes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Showtime s : showtimes) {
                writer.write(s.getShownMovie().getMovieID() + ";" + s.getShowingScreen().getScreenNumber() + ";" + s.getTime());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<String>> getShowtimesByMovie(String filename) {
        Map<String, List<String>> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String movieID = parts[0];
                    String theaterID = parts[1];
                    String time = parts[2];
                    String entry = "Theater " + theaterID + ": " + time;

                    map.computeIfAbsent(movieID, k -> new ArrayList<>()).add(entry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
