/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;
import model.Concession;
import java.io.*;
import java.util.*;
import model.*;
/**
 *
 * @author Kahden Vienna
 */
public class ConcessionIO {
    public static Map<String, Concession> loadConcessions(String filename) {
        Map<String, Concession> concessions = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Concession item = new Concession(parts[0], parts[1], Double.parseDouble(parts[2]));
                concessions.put(parts[0], item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return concessions;
    }

    public static void saveConcessions(String filename, Map<String, Concession> concessions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Concession c : concessions.values()) {
                writer.write(c.getConcessionId() + "," + c.getItemName() + "," + c.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}