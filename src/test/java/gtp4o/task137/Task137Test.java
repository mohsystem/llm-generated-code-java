package gtp4o.task137;

import java.util.HashMap;
import java.util.Map;

public class Task137Test {

    static class Product {
        private String name;
        private int price;

        public Product() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }

    // Simulate product "table" storage with product ID keys
    private static Map<String, Product> productTable = new HashMap<>();

    public static void addProduct(String id, String name, int price) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productTable.put(id, p);
    }

    public static Product getProduct(String id) {
        return productTable.get(id);
    }

    public static void runTests() {
        // Setup test data
        addProduct("001", "Apple", 100);
        addProduct("002", "Banana", 50);
        addProduct("003", "Orange", 120);

        // Test 1: Retrieve existing product 001
        Product p = getProduct("001");
        if (p == null || !p.getName().equals("Apple") || p.getPrice() != 100) {
            System.out.println("Test Case 1 Failed");
            return;
        }

        // Test 2: Retrieve existing product 002
        p = getProduct("002");
        if (p == null || !p.getName().equals("Banana") || p.getPrice() != 50) {
            System.out.println("Test Case 2 Failed");
            return;
        }

        // Test 3: Retrieve non-existent product 999
        p = getProduct("999");
        if (p != null) {
            System.out.println("Test Case 3 Failed");
            return;
        }

        System.out.println("All test cases passed!");
    }

    public static void main(String[] args) {
        runTests();
    }
}
