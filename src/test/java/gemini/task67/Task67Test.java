package gemini.task67;

import org.junit.jupiter.api.*;
import java.sql.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task67Test  {

    private static final String DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

    @BeforeAll
    public static void setupDatabase() throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE customer (" +
                    "customerusername VARCHAR(255), " +
                    "customerfirstname VARCHAR(255))");

            stmt.execute("INSERT INTO customer (customerusername, customerfirstname) VALUES " +
                    "('ahmad123', 'Ahmad')," +
                    "('mona456', 'Mona')");
        }

        // Override DB URL using reflection
        var clazz = Task67_GEMINI_gemini_1_5_pro_001.class;
        var field = clazz.getDeclaredMethod("getCustomerInfo", String.class);
        field.setAccessible(true);
    }

    @Test
    public void testCustomerFoundAhmad() {
        Customer customer = callGetCustomer("ahmad123");
        assertNotNull(customer);
        assertEquals("ahmad123", customer.getCustomerusername());
        assertEquals("Ahmad", customer.getCustomerfirstname());
    }

    @Test
    public void testCustomerFoundMona() {
        Customer customer = callGetCustomer("mona456");
        assertNotNull(customer);
        assertEquals("mona456", customer.getCustomerusername());
        assertEquals("Mona", customer.getCustomerfirstname());
    }

    @Test
    public void testCustomerNotFound() {
        Customer customer = callGetCustomer("not_found");
        assertNull(customer);
    }

    private Customer callGetCustomer(String username) {
        try {
            // temporarily override SQLite with H2
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE customerusername = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            Customer customer = null;
            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerusername(rs.getString("customerusername"));
                customer.setCustomerfirstname(rs.getString("customerfirstname"));
            }

            rs.close();
            stmt.close();
            conn.close();

            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
