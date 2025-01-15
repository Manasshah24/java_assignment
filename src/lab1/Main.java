package lab1;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MerchandiseInventoryApp {
    // Inner Merchandise class
    static class Merchandise {
        private String itemCode;
        private int quantity;
        private double unitPrice;

        // Constructor
        public Merchandise(String itemCode, int quantity, double unitPrice) {
            this.itemCode = itemCode;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        // Getters
        public String getItemCode() {
            return itemCode;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        // Calculate total price
        public double getTotalPrice() {
            return unitPrice * quantity;
        }

        // toString method for printing
        @Override
        public String toString() {
            return itemCode + " " + quantity + " " + unitPrice + " Total Price: " + getTotalPrice();
        }
    }

    // List to store inventory
    private List<Merchandise> inventory;

    // Constructor
    public MerchandiseInventoryApp() {
        this.inventory = new ArrayList<>();
    }

    // Method to read data from the file
    public void loadInventory(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) { // Ensure the line has exactly 3 parts
                    String itemCode = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    double unitPrice = Double.parseDouble(parts[2]);
                    inventory.add(new Merchandise(itemCode, quantity, unitPrice));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to print the inventory
    public void printInventory() {
        inventory.forEach(System.out::println);
    }

    // Method to sort by item code in ascending order
    public void sortByItemCode() {
        inventory.sort(Comparator.comparing(Merchandise::getItemCode));
    }

    // Method to sort by total price in descending order
    public void sortByTotalPriceDescending() {
        inventory.sort(Comparator.comparing(Merchandise::getTotalPrice).reversed());
    }

    // Main method
    public static void main(String[] args) {
        MerchandiseInventoryApp app = new MerchandiseInventoryApp();

        // Load inventory from file
        String filePath = "C:\\Users\\manas.shah\\Desktop\\koerber_intern\\koerber_intern\\koerber_manas\\src\\lab1\\input.txt"; // Update with the correct path
        app.loadInventory(filePath);

        // Print original inventory
        System.out.println("Original Inventory:");
        app.printInventory();

        // Sort by item code and print
        app.sortByItemCode();
        System.out.println("\nInventory sorted by item code (ascending):");
        app.printInventory();

        // Sort by total price and print
        app.sortByTotalPriceDescending();
        System.out.println("\nInventory sorted by total price (descending):");
        app.printInventory();
    }
}





