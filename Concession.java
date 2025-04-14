import java.util.HashMap;
import java.util.Map;
/**
 * Represents a concession item and manages a static menu of concession items.
 */

public class Concession {
    private final String concessionId;
    private String itemName;
    private double price;


     /**
     * Static map storing concession items by ID.
     */
    protected static final Map<String, Concession> concessionMenu = new HashMap<>();


    /**
     * Returns the current map of concession items.
     *
     * @return A map of concession ID to Concession objects.
     */
    public static Map<String, Concession> getConcessionMenu() {
        return concessionMenu;
    }


    /**
     * Constructs a concession item.
     *
     * @param concessionId The unique ID of the concession item.
     * @param itemName     The name of the item.
     * @param price        The price of the item.
     */
    public Concession(String concessionId, String itemName, double price) {
        this.concessionId = concessionId;
        this.itemName = itemName;
        this.price = price;
    }


     /**
     * Returns the concession ID.
     */
    public String getConcessionId() { return concessionId; }


    /**
     * Returns the item name.
     */
    public String getItemName() { return itemName; }


    /**
     * Returns the item price.
     */
    public double getPrice() { return price; }


    /**
     * Adds a new item to the concession menu.
     *
     * @param itemId   The ID of the new item.
     * @param itemName The name of the item.
     * @param price    The price of the item.
     */
    public static void addItem(String itemId, String itemName, double price) {
        Concession item = new Concession(itemId, itemName, price);
        concessionMenu.put(itemId, item);
        System.out.println("Item added: " + itemName + " ($" + price + ")");
    }


    /**
     * Removes an item from the concession menu by ID.
     *
     * @param itemId The ID of the item to remove.
     */
    public static void removeItem(String itemId) {
        if (concessionMenu.remove(itemId) != null) {
            System.out.println("Item removed: " + itemId);
        } else {
            System.out.println("Item not found: " + itemId);
        }
    }


     /**
     * Updates the details of an existing item.
     *
     * @param itemId   The ID of the item.
     * @param itemName The new name.
     * @param price    The new price.
     */
    public static void updateItem(String itemId, String itemName, double price) {
        Concession item = concessionMenu.get(itemId);
        if (item != null) {
            item.itemName = itemName;
            item.price = price;
            System.out.println("Item updated: " + itemName + " ($" + price + ")");
        } else {
            System.out.println("Item not found: " + itemId);
        }
    }

    
    /**
     * Searches for a concession item by ID and prints the result.
     *
     * @param itemId The ID of the item to search for.
     */
    public static void searchItem(String itemId) {
        Concession item = concessionMenu.get(itemId);
        if (item != null) {
            System.out.println("Item found: " + item.itemName + " ($" + item.price + ")");
        } else {
            System.out.println("Item not found: " + itemId);
        }
    }
}