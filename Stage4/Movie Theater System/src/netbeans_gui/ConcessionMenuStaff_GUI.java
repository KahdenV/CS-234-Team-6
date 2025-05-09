import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;
import model.Concession;

public class ConcessionMenuStaff_GUI extends JFrame {
    private JComboBox<String> itemDropdown;
    private JSpinner quantitySpinner;
    private JLabel totalLabel;

    public ConcessionMenuStaff_GUI() {
        setTitle("Concession Stand");
        setSize(660, 410);
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

        // Total Label
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setBounds(200, 200, 120, 25);
        add(totalLabel);

        // Checkout Button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setBounds(150, 280, 120, 30);
        add(checkoutButton);
        checkoutButton.addActionListener(this::handleCheckout);

        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(300, 280, 120, 30);
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

    private void handleCheckout(ActionEvent e) {
        String selectedItemName = (String) itemDropdown.getSelectedItem();
        int quantity = (int) quantitySpinner.getValue();

        for (Concession item : Concession.getConcessionMenu().values()) {
            if (item.getItemName().equals(selectedItemName)) {
                double total = item.getPrice() * quantity;
                totalLabel.setText(String.format("Total: $%.2f", total));
                JOptionPane.showMessageDialog(this, "Order total: " + totalLabel.getText());
                return;
            }
        }
    }

    private void resetSelections() {
        itemDropdown.setSelectedIndex(0);
        quantitySpinner.setValue(1);
        totalLabel.setText("Total: $0.00");
    }

    public static void main(String[] args) {
        // Populate concession menu before GUI launch
        Concession.addItem("popcorn", "Popcorn", 5.00);
        Concession.addItem("drink", "Drink", 3.00);
        Concession.addItem("candy", "Candy", 2.50);

        new ConcessionMenuStaff_GUI();
    }
}
