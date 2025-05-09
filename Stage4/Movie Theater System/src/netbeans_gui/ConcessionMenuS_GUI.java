package netbeans_gui;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import model.Concession;

public class ConcessionMenuS_GUI extends javax.swing.JFrame {
    private Map<String, Concession> concessions;
    private DefaultComboBoxModel<String> dropdownModel;
    private JComboBox<String> itemDropdown;
    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;

    public ConcessionMenuS_GUI() {
        setTitle("Concession Stand");
        setSize(660, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("Concession Stand");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setBounds(200, 20, 300, 40);
        add(titleLabel);

        // ID Input
        JLabel idLabel = new JLabel("Item ID:");
        idLabel.setBounds(20, 80, 60, 25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(80, 80, 80, 25);
        add(idField);

        // Name Input
        JLabel nameLabel = new JLabel("Item Name:");
        nameLabel.setBounds(170, 80, 70, 25);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(240, 80, 120, 25);
        add(nameField);

        // Price Input
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(380, 80, 50, 25);
        add(priceLabel);
        priceField = new JTextField();
        priceField.setBounds(430, 80, 80, 25);
        add(priceField);

        // Add Item Button
        JButton saveItemButton = new JButton("Add Item");
        saveItemButton.setBounds(530, 80, 100, 25);
        add(saveItemButton);
        saveItemButton.addActionListener(e -> handleManualAddItem());

        // Dropdown
        JLabel itemLabel = new JLabel("Select Item:");
        itemLabel.setBounds(20, 130, 120, 25);
        add(itemLabel);

        itemDropdown = new JComboBox<>();
        loadConcessionItems();
        itemDropdown.setBounds(120, 130, 250, 25);
        add(itemDropdown);

        // Delete Button
        JButton deleteButton = new JButton("Delete Item");
        deleteButton.setBounds(390, 130, 120, 25);
        add(deleteButton);
        deleteButton.addActionListener(e -> handleDeleteItem());

        setVisible(true);
    }

    private void loadConcessionItems() {
        concessions = io.ConcessionIO.loadConcessions("data/concessions.txt");
        dropdownModel = new DefaultComboBoxModel<>();
        for (Concession item : concessions.values()) {
            dropdownModel.addElement(item.getItemName());
        }
        itemDropdown.setModel(dropdownModel);
    }

    private void handleManualAddItem() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String priceText = priceField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        if (concessions.containsKey(id)) {
            JOptionPane.showMessageDialog(this, "ID already exists.");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price.");
            return;
        }

        Concession newItem = new Concession(id, name, price);
        concessions.put(id, newItem);
        io.ConcessionIO.saveConcessions("data/concessions.txt", concessions);
        loadConcessionItems();

        idField.setText("");
        nameField.setText("");
        priceField.setText("");

        JOptionPane.showMessageDialog(this, "New item added successfully.");
    }

    private void handleDeleteItem() {
        String selectedItemName = (String) itemDropdown.getSelectedItem();
        String toRemoveId = null;

        for (Map.Entry<String, Concession> entry : concessions.entrySet()) {
            if (entry.getValue().getItemName().equals(selectedItemName)) {
                toRemoveId = entry.getKey();
                break;
            }
        }

        if (toRemoveId != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Delete this item?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                concessions.remove(toRemoveId);
                io.ConcessionIO.saveConcessions("data/concessions.txt", concessions);
                loadConcessionItems();
            }
        }
    }
}
