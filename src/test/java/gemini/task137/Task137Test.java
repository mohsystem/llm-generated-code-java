package gemini.task137;

import java.util.HashMap;
import java.util.Map;

public class Task137Test {

    public static String getProductDetails(Map<String, Map<String, Object>> products, String productId) {
        Map<String, Object> product = products.get(productId);
        if (product != null) {
            return String.format("Product Name: %s\nPrice: $%.2f\nStock: %d",
                    product.get("name"), product.get("price"), product.get("stock"));
        } else {
            return "Product not found.";
        }
    }

    public static void runTests() {
        Map<String, Map<String, Object>> products = new HashMap<>();
        products.put("001", Map.of("name", "Apple", "price", 1.00, "stock", 100));
        products.put("002", Map.of("name", "Banana", "price", 0.50, "stock", 50));
        products.put("003", Map.of("name", "Orange", "price", 1.20, "stock", 75));

        // Test 1: existing product "001"
        String result = getProductDetails(products, "001");
        if (!result.contains("Apple") || !result.contains("1.00") || !result.contains("100")) {
            System.out.println("Test Case 1 Failed");
            return;
        }

        // Test 2: existing product "002"
        result = getProductDetails(products, "002");
        if (!result.contains("Banana") || !result.contains("0.50") || !result.contains("50")) {
            System.out.println("Test Case 2 Failed");
            return;
        }

        // Test 3: non-existent product
        result = getProductDetails(products, "999");
        if (!result.equals("Product not found.")) {
            System.out.println("Test Case 3 Failed");
            return;
        }

        System.out.println("All test cases passed!");
    }

    public static void main(String[] args) {
        runTests();
    }
}
