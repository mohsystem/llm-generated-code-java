package gtp4o.task46;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.*;

public class Task46Test {
    private static final String DB_URL = "jdbc:sqlite:users.db";

    @BeforeEach
    void setUp() throws Exception {
        // Remove any existing database file so each test starts fresh
        File dbFile = new File("users.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }
        // Create the table as in your main code
        Task46_OPENAI_gpt_4o.createTable();
    }

    @AfterEach
    void tearDown() {
        // Clean up database file after each test
        File dbFile = new File("users.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }
    }

    @Test
    void testCreateTable() throws SQLException {
        // Verify that the 'users' table exists
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT name FROM sqlite_master WHERE type='table' AND name='users'")) {
            assertTrue(rs.next(), "Table 'users' was not created");
        }
    }

    @Test
    void testRegisterNewUser() throws SQLException {
        // Register a new user
        Task46_OPENAI_gpt_4o.registerUser("John Doe", "john@example.com", "password123");

        // Verify that the row was inserted correctly
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT name, email, password FROM users WHERE email = ?")) {
            ps.setString(1, "john@example.com");
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue(rs.next(), "User was not registered");
                assertEquals("John Doe",        rs.getString("name"));
                assertEquals("john@example.com", rs.getString("email"));
                assertEquals("password123",     rs.getString("password"));
            }
        }
    }

    @Test
    void testRegisterDuplicateEmail() {
        // First registration should succeed
        assertDoesNotThrow(() ->
                Task46_OPENAI_gpt_4o.registerUser("John Doe", "john@example.com", "password123")
        );

        // Second registration with same email should throw a UNIQUE constraint violation
        SQLException ex = assertThrows(SQLException.class, () ->
                Task46_OPENAI_gpt_4o.registerUser("Jane Doe", "john@example.com", "password456")
        );
        assertTrue(ex.getMessage().toLowerCase().contains("unique"),
                "Expected a UNIQUE constraint error, but got: " + ex.getMessage());

        // And ensure only one record exists for that email
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT COUNT(*) FROM users WHERE email = ?")) {
            ps.setString(1, "john@example.com");
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                assertEquals(1, rs.getInt(1), "Duplicate email was inserted");
            }
        } catch (SQLException e) {
            fail("Error querying the database: " + e.getMessage());
        }
    }

    @Test
    void testRegisterUserValidity() throws SQLException {
        // Register another user
        Task46_OPENAI_gpt_4o.registerUser("Alice Smith", "alice@example.com", "password789");

        // Verify all fields are stored correctly
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT name, email, password FROM users WHERE email = ?")) {
            ps.setString(1, "alice@example.com");
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue(rs.next(), "User was not registered");
                assertEquals("Alice Smith",       rs.getString("name"));
                assertEquals("alice@example.com", rs.getString("email"));
                assertEquals("password789",       rs.getString("password"));
            }
        }
    }
}
