public class MenuManager {
    private CustomerMenu customerMenu;
    private StaffMenu staffMenu;

    /**
     * Constructs a MenuManager with specified customer and staff menus.
     *
     * @param customerMenu The customer menu handler.
     * @param staffMenu The staff menu handler.
     */
    public MenuManager(CustomerMenu customerMenu, StaffMenu staffMenu) {
        this.customerMenu = customerMenu;
        this.staffMenu = staffMenu;
    }

    /**
     * Updates the customer menu at runtime.
     *
     * @param customerMenu The updated CustomerMenu instance.
     */
    public void setCustomerMenu(CustomerMenu customerMenu) {
        this.customerMenu = customerMenu;
    }

    /**
     * Displays the appropriate menu based on the user's role.
     *
     * @param user The logged-in user.
     */
    public void displayMainMenu(Person user) {
        if (user instanceof Staff) {
            staffMenu.showStaffMenu();
        } else if (user instanceof Customer || user instanceof Guest) {
            customerMenu.showCustomerMenu();
        } else {
            System.out.println("Unknown user type. Unable to display menu.");
        }
    }
}
