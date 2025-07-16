package llama3.task137;

import java.util.HashMap;
import java.util.Map;

public class Task137Test {

    private static Map<String, Map<String, Integer>> productTable = new HashMap<>();

    static {
        productTable.put("apple", Map.of("price", 10, "stock", 100));
        productTable.put("banana", Map.of("price", 5, "stock", 200));
        productTable.put("orange", Map.of("price", 15, "stock", 50));
    }

    public static String getProductDetails(String productName) {
        if (productTable.containsKey(productName)) {
            Map<String, Integer> details = productTable.get(productName);
            return "Product: " + productName + "\n" +
                    "Price: " + details.get("price") + "\n" +
                    "Stock: " + details.get("stock");
        } else {
            return "Product not found";
        }
    }

    public static void runTests() {
        // Test 1: Existing product "apple"
        String result = getProductDetails("apple");
        if (!result.contains("apple") || !result.contains("10") || !result.contains("100")) {
            System.out.println("Test Case 1 Failed");
            return;
        }

        // Test 2: Existing product "banana"
        result = getProductDetails("banana");
        if (!result.contains("banana") || !result.contains("5") || !result.contains("200")) {
            System.out.println("Test Case 2 Failed");
            return;
        }

        // Test 3: Non-existing product
        result = getProductDetails("grape");
        if (!result.equals("Product not found")) {
            System.out.println("Test Case 3 Failed");
            return;
        }

        System.out.println("All test cases passed!");
    }

    public static void main(String[] args) {
        runTests();
    }
}
