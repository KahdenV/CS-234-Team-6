/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;

/**
 *
 * @author Kahden Vienna
 */

import model.Customer;
 import java.io.*;
 import java.util.*;
 import model.*;

 public class CustomerIO {
    public static List<Customer> loadCustomers(String filename) {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    customers.add(new Customer(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void saveCustomers(String filename, List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Customer c : customers) {
                writer.write(c.getId() + "," + c.getName() + "," + c.getEmail() + "," + c.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
