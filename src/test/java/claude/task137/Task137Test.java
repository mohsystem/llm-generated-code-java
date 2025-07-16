package claude.task137;

import java.sql.*;
import java.util.Scanner;

public class Task137Test {
    // Use your exact DB file path
    private static final String DB_URL = "jdbc:sqlite:C:/Users/1/OneDrive/Desktop/llm-generated-code-java/src/test/java/claude/task137/products.db";

    public static void createTable() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS products " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT, " +
                    " price REAL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public static void addProduct(String name, double price) {
        String sql = "INSERT INTO products(name, price) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public static String getProduct(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return String.format("ID: %d, Name: %s, Price: $%.2f",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"));
            } else {
                return "Product not found.";
            }
        } catch (SQLException e) {
            return "Error retrieving product: " + e.getMessage();
        }
    }

    public static void runTests() {
        createTable();

        try {
            addProduct("TestProduct1", 10.0);
            String result = getProduct(1);
            if (!result.contains("TestProduct1")) {
                System.out.println("Test Case 1 Failed");
            }
            System.out.println("Test Case 1 Passed");

            addProduct("TestProduct2", 20.0);
            addProduct("TestProduct3", 30.5);

            result = getProduct(2);
            if (!result.contains("TestProduct2")) {
                System.out.println("Test Case 2 Failed");
            }
            System.out.println("Test Case 2 Passed");

            result = getProduct(3);
            if (!result.contains("TestProduct3")) {
                System.out.println("Test Case 3 Failed");
            }
            System.out.println("Test Case 3 Passed");


            result = getProduct(9999);
            if (!result.equals("Product not found.")) {
                System.out.println("Test Case 4 Failed");
            }
            System.out.println("Test Case 4 Passed");


        } catch (Exception e) {
            System.out.println("Exception during tests: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
