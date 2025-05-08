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
                String[] parts = line.split(";", 4); // ensure you grab seats too
                if (parts.length >= 3) {
                    String movieID = parts[0];
                    String screenID = parts[1];
                    String time = parts[2];
                    List<String> seats = new ArrayList<>();
    
                    if (parts.length == 4 && !parts[3].isBlank()) {
                        seats = Arrays.asList(parts[3].trim().split(" "));
                    }
    
                    Movie movie = movies.stream()
                            .filter(m -> m.getMovieID().equals(movieID))
                            .findFirst()
                            .orElse(null);
    
                    Screen screen = screens.stream()
                            .filter(s -> s.getScreenNumber().equals(screenID))
                            .findFirst()
                            .orElseGet(() -> {
                                Screen newScreen = new Screen(screenID);
                                screens.add(newScreen);
                                return newScreen;
                            });
    
                    if (movie != null) {
                        showtimes.add(new Showtime(movie, screen, time, new ArrayList<>(seats)));
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
                String seatList = String.join(" ", s.getAvailableSeats());
                writer.write(s.getShownMovie().getMovieID() + ";" + 
                             s.getShowingScreen().getScreenNumber() + ";" + 
                             s.getTime() + ";" + seatList);
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
                String[] parts = line.split(";", 4); // allow seat field to contain semicolons or be ignored
                if (parts.length >= 3) {
                    String movieID = parts[0];
                    String screenNumber = parts[1];
                    String time = parts[2];
                    String label = time + " (Screen " + screenNumber + ")";
                    
                    map.putIfAbsent(movieID, new ArrayList<>());
                    map.get(movieID).add(label);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return map;
    }
    
}
