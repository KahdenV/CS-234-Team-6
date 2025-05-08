import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class ConcessionStandCustomerGUI extends JFrame {
    private JComboBox<String> itemDropdown;
    private JSpinner quantitySpinner;
    private JTextArea orderSummary;
    private JLabel totalLabel;
    private Map<String, Integer> cart = new HashMap<>();

    public ConcessionStandCustomerGUI() {
        setTitle("Concession Stand - Customer View");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("Concession Stand");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setBounds(200, 20, 300, 50);
        add(titleLabel);

        // Item Dropdown
        JLabel itemLabel = new JLabel("Select Item:");
        itemLabel.setBounds(100, 100, 120, 25);
        add(itemLabel);

        itemDropdown = new JComboBox<>();
        loadConcessionItems();
        itemDropdown.setBounds(250, 100, 150, 25);
        add(itemDropdown);

        // Quantity Spinner
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(100, 140, 120, 25);
        add(quantityLabel);

        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        quantitySpinner.setBounds(250, 140, 50, 25);
        add(quantitySpinner);

        // Order Summary
        JLabel orderLabel = new JLabel("Order Summary:");
        orderLabel.setBounds(100, 180, 120, 25);
        add(orderLabel);

        orderSummary = new JTextArea();
        orderSummary.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderSummary);
        scrollPane.setBounds(250, 180, 250, 100);
        add(scrollPane);

        // Total Label
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setBounds(200, 300, 120, 25);
        add(totalLabel);

        // Add to Cart Button
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBounds(150, 350, 120, 30);
        add(addToCartButton);
        addToCartButton.addActionListener(this::handleAddToCart);

        // Checkout Button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setBounds(300, 350, 120, 30);
        add(checkoutButton);
        checkoutButton.addActionListener(this::handleCheckout);

        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(450, 350, 120, 30);
        add(cancelButton);
        cancelButton.addActionListener(e -> resetSelections());

        setVisible(true);
    }

    private void loadConcessionItems() {
        Map<String, Concession> menu = Concession.getConcessionMenu();
        for (String itemId : menu.keySet()) {
            itemDropdown.addItem(menu.get(itemId).getItemName());
        }
    }

    private void handleAddToCart(ActionEvent e) {
        String selectedItemName = (String) itemDropdown.getSelectedItem();
        int quantity = (int) quantitySpinner.getValue();

        // Update cart
        cart.put(selectedItemName, cart.getOrDefault(selectedItemName, 0) + quantity);
        updateOrderSummary();
    }

    private void updateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        double total = 0.0;

        for (String itemName : cart.keySet()) {
            Concession item = findConcessionItem(itemName);
            if (item != null) {
                int quantity = cart.get(itemName);
                double cost = item.getPrice() * quantity;
                total += cost;
                summary.append(itemName).append(" x").append(quantity)
                        .append(" - $").append(String.format("%.2f", cost)).append("\n");
            }
        }

        orderSummary.setText(summary.toString());
        totalLabel.setText(String.format("Total: $%.2f", total));
    }

    private Concession findConcessionItem(String itemName) {
        for (Concession item : Concession.getConcessionMenu().values()) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    private void handleCheckout(ActionEvent e) {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your cart is empty.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Order placed!\n" + orderSummary.getText());
        resetSelections();
    }

    private void resetSelections() {
        cart.clear();
        orderSummary.setText("");
        totalLabel.setText("Total: $0.00");
    }

    public static void main(String[] args) {
        // Populate concession menu before GUI launch
        Concession.addItem("popcorn", "Popcorn", 5.00);
        Concession.addItem("drink", "Drink", 3.00);
        Concession.addItem("candy", "Candy", 2.50);

        new ConcessionStandCustomerGUI();
    }
}
