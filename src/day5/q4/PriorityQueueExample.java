package day5.q4;
import java.util.*;

class Product {
    private int productId;
    private String productName;
    private double productPrice;

    // Constructor
    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    // toString method for printing product details
    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Price: " + productPrice;
    }
}

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Define a PriorityQueue with a custom comparator (sort by productPrice)
        PriorityQueue<Product> productQueue = new PriorityQueue<>(Comparator.comparingDouble(Product::getProductPrice));

        // Add 5 products to the PriorityQueue
        productQueue.add(new Product(1, "Laptop", 1200.50));
        productQueue.add(new Product(2, "Smartphone", 800.00));
        productQueue.add(new Product(3, "Headphones", 150.75));
        productQueue.add(new Product(4, "Monitor", 300.40));
        productQueue.add(new Product(5, "Keyboard", 75.99));

        // Print and remove products from the PriorityQueue
        System.out.println("Products in the PriorityQueue (ordered by price):");
        while (!productQueue.isEmpty()) {
            System.out.println(productQueue.poll()); // poll() removes and returns the head of the queue
        }
    }
}
