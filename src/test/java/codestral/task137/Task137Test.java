package codestral.task137;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task137Test {

    private static Map<String, Map<String, Object>> productTable = new HashMap<>();

    static {
        Map<String, Object> product1 = new HashMap<>();
        product1.put("name", "Product 1");
        product1.put("price", 10.99);
        product1.put("quantity", 100);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("name", "Product 2");
        product2.put("price", 20.99);
        product2.put("quantity", 50);

        productTable.put("P123", product1);
        productTable.put("P456", product2);
    }

    public static Map<String, Object> getProductDetails(String productId) {
        return productTable.getOrDefault(productId, null);
    }

    // Test cases exactly matching your original logic
    public static void runTests() {
        // Test 1: Existing product P123
        Map<String, Object> product = getProductDetails("P123");
        if (product == null ||
                !"Product 1".equals(product.get("name")) ||
                !product.get("price").equals(10.99) ||
                !product.get("quantity").equals(100)) {
            System.out.println("Test Case 1 Failed");
            return;
        }

        // Test 2: Existing product P456
        product = getProductDetails("P456");
        if (product == null ||
                !"Product 2".equals(product.get("name")) ||
                !product.get("price").equals(20.99) ||
                !product.get("quantity").equals(50)) {
            System.out.println("Test Case 2 Failed");
            return;
        }

        // Test 3: Non-existing product
        product = getProductDetails("P999");
        if (product != null) {
            System.out.println("Test Case 3 Failed");
            return;
        }

        System.out.println("All test cases passed!");
    }

    public static void main(String[] args) {
        runTests();
    }
}
