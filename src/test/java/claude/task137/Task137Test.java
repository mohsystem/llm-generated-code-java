package claude.task137;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

class Task137Test {

    private static final String H2_DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

    @BeforeAll
    static void setupDatabase() throws Exception {
        // Override the original DB_URL field to use H2
        var dbUrlField = Task137_CLAUDE_claude_3_5_sonnet_20240620.class.getDeclaredField("DB_URL");
        dbUrlField.setAccessible(true);
        dbUrlField.set(null, H2_DB_URL);

        // Create table on H2
        Task137_CLAUDE_claude_3_5_sonnet_20240620.createTable();
    }

    @BeforeEach
    void clearTable() throws Exception {
        try (Connection conn = DriverManager.getConnection(H2_DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM products");
        }
    }

    @Test
    void testAddAndRetrieveProduct() throws Exception {
        Task137_CLAUDE_claude_3_5_sonnet_20240620.addProduct("Laptop", 999.99);

        try (Connection conn = DriverManager.getConnection(H2_DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM products WHERE name = ?")) {
            pstmt.setString(1, "Laptop");
            ResultSet rs = pstmt.executeQuery();
            assertTrue(rs.next());
            assertEquals("Laptop", rs.getString("name"));
            assertEquals(999.99, rs.getDouble("price"), 0.01);
        }
    }

    @Test
    void testGetNonExistentProduct() throws Exception {
        try (Connection conn = DriverManager.getConnection(H2_DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM products WHERE id = ?")) {
            pstmt.setInt(1, 9999); // ID unlikely to exist
            ResultSet rs = pstmt.executeQuery();
            assertFalse(rs.next());
        }
    }

    @Test
    void testMultipleProducts() throws Exception {
        Task137_CLAUDE_claude_3_5_sonnet_20240620.addProduct("Phone", 499.99);
        Task137_CLAUDE_claude_3_5_sonnet_20240620.addProduct("Tablet", 299.99);

        try (Connection conn = DriverManager.getConnection(H2_DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS total FROM products")) {
            ResultSet rs = pstmt.executeQuery();
            assertTrue(rs.next());
            assertEquals(2, rs.getInt("total"));
        }
    }
}
