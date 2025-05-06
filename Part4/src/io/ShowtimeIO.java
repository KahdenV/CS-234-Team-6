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
import model.*;
/**
 *
 * @author Kahden Vienna
 */
public class ShowtimeIO {
    public static List<Showtime> loadShowtimes(String filename, List<Movie> movies, List<Screen> screens) {
        List<Showtime> showtimes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // movieID,screenID,time
                Movie movie = movies.stream().filter(m -> m.getMovieID().equals(parts[0])).findFirst().orElse(null);
                Screen screen = screens.stream().filter(s -> s.getScreenNumber().equals(parts[1])).findFirst().orElse(null);
                if (movie != null && screen != null) {
                    showtimes.add(new Showtime(movie, screen, parts[2]));
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
                writer.write(s.getShownMovie().getMovieID() + "," + s.getShowingScreen().getScreenNumber() + "," + s.getTime());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
