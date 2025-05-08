/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;
import model.Staff;
import java.io.*;
import java.util.*;

import model.*;

/**
 *
 * @author Kahden Vienna
 */
public class StaffIO {
    public static List<Staff> loadStaff(String filename) {
        List<Staff> staffList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    staffList.add(new Staff(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public static void saveStaff(String filename, List<Staff> staffList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Staff s : staffList) {
                writer.write(s.getName() + "," + s.getEmail() + "," + s.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
