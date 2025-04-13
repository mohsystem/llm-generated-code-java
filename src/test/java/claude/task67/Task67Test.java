package claude.task67;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;

public class Task67Test {

    private static Connection connection;

    @BeforeAll
    public static void setupDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE customer (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "customerusername VARCHAR(255), " +
                    "name VARCHAR(255), " +
                    "email VARCHAR(255), " +
                    "phone VARCHAR(255))");

            stmt.execute("INSERT INTO customer (customerusername, name, email, phone) VALUES " +
                    "('john_doe', 'John Doe', 'john@example.com', '123456789')," +
                    "('jane_smith', 'Jane Smith', 'jane@example.com', '987654321')");
        }

         System.setProperty("jdbc.drivers", "org.h2.Driver");
    }

    @Test
    public void testCustomerFoundJohn() {
        Task67_CLAUDE_claude_3_5_sonnet_20240620 customer = callGetCustomerInfo("john_doe");
        assertNotNull(customer);
        assertEquals("john_doe", customer.getUsername());
        assertEquals("John Doe", customer.getName());
        assertEquals("john@example.com", customer.getEmail());
        assertEquals("123456789", customer.getPhone());
    }

    @Test
    public void testCustomerFoundJane() {
        Task67_CLAUDE_claude_3_5_sonnet_20240620 customer = callGetCustomerInfo("jane_smith");
        assertNotNull(customer);
        assertEquals("jane_smith", customer.getUsername());
        assertEquals("Jane Smith", customer.getName());
        assertEquals("jane@example.com", customer.getEmail());
        assertEquals("987654321", customer.getPhone());
    }

    @Test
    public void testCustomerNotFound() {
        Task67_CLAUDE_claude_3_5_sonnet_20240620 customer = callGetCustomerInfo("not_exist");
        assertNull(customer);
    }

    private Task67_CLAUDE_claude_3_5_sonnet_20240620 callGetCustomerInfo(String username) {
        try {
            String url = "jdbc:h2:mem:testdb";
            String sql = "SELECT * FROM customer WHERE customerusername = ?";

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, username);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    Task67_CLAUDE_claude_3_5_sonnet_20240620 customer = new Task67_CLAUDE_claude_3_5_sonnet_20240620();
                    customer.setId(rs.getInt("id"));
                    customer.setUsername(rs.getString("customerusername"));
                    customer.setName(rs.getString("name"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhone(rs.getString("phone"));
                    return customer;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
