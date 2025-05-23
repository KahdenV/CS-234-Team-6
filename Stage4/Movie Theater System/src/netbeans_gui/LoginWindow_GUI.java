package netbeans_gui;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import model.Staff;
import service.AuthenticationService;
import model.Person;
import model.MovieTheaterSystem;
import model.Customer;
import javax.swing.*;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import model.*;
import io.*;

/**
 *
 * @author Kahden Vienna
 */
public class LoginWindow_GUI extends javax.swing.JFrame {

    private MovieTheaterSystem system;
    private AuthenticationService authService;

    /**
     * Creates new form LoginWindow_GUI7
     */
    public LoginWindow_GUI() {
        initComponents();
        system = new MovieTheaterSystem();
        authService = system.getAuthService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login_Label = new javax.swing.JLabel();
        UserInput_TextField = new javax.swing.JTextField();
        PasswordInput_PasswordField = new javax.swing.JPasswordField();
        Login_Button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Window");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(660, 410));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login_Label.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Login_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login_Label.setText("Login");
        getContentPane().add(Login_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 110, -1, -1));

        UserInput_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UserInput_TextField.setToolTipText("Email");
        UserInput_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserInput_TextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(UserInput_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 180, 30));

        PasswordInput_PasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PasswordInput_PasswordField.setToolTipText("Password");
        getContentPane().add(PasswordInput_PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 180, 30));

        Login_Button.setText("Login");
        Login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Login_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 140, 30));

        jButton1.setText("Create Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 140, 30));

        jButton2.setText("Skip");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 100, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movie Munch Theater");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 540, 80));

        jLabel2.setText("Email:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UserInput_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInput_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInput_TextFieldActionPerformed

    private void Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_ButtonActionPerformed
        // TODO add your handling code here:
        String username = UserInput_TextField.getText();
        String password = new String(PasswordInput_PasswordField.getPassword());

        Person person = authService.authenticate(username, password);

        if (person != null) {
            JOptionPane.showMessageDialog(this, "Login succesful! Welcome, " + person.getName());
            this.dispose();
            if (person instanceof Customer) {
                Customer customer = (Customer) person;
                java.awt.EventQueue.invokeLater(() -> {
                    new CustomerMenu_GUI(customer).setVisible(true);
                });
            } else if (person instanceof Staff) {
                Staff staff = (Staff) person;
                java.awt.EventQueue.invokeLater(() -> {
                    new StaffMenu_GUI(staff).setVisible(true);
                });

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_Login_ButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = new JFrame("Create Account");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JTextField usernameField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            String nextID = getNextCustomerID();
            if (nextID == null) {
                JOptionPane.showMessageDialog(frame, "Failed to generate ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String record = nextID + "," + username + "," + email + "," + password + "\n";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/customers.txt", true))) {
                writer.write(record);
                writer.newLine();
                writer.flush();

                Customer newCustomer = new Customer(nextID, username, email, password);
                authService.addCustomer(newCustomer);

                JOptionPane.showMessageDialog(frame, "Account Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Failed to save account.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(new JLabel("Username:"));
        frame.add(usernameField);
        frame.add(new JLabel("Email:"));
        frame.add(emailField);
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(new JLabel());
        frame.add(saveButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        Customer guest = new Customer("GUEST000", "Guest", "guest@guest.com", ""); // or null
        new CustomerMenu_GUI(guest).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private String getNextCustomerID() {
        int maxID = -1;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].startsWith("C")) {
                    String numericPart = parts[0].substring(1); // e.g., from C003 → 003
                    int currentID = Integer.parseInt(numericPart);
                    if (currentID > maxID) {
                        maxID = currentID;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return "C" + String.format("%03d", maxID + 1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login_Button;
    private javax.swing.JLabel Login_Label;
    private javax.swing.JPasswordField PasswordInput_PasswordField;
    private javax.swing.JTextField UserInput_TextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
