package codestral.task46;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.sql.*;

public class Task46Test {
    private static final String DB_URL = "jdbc:sqlite:user_database.db";
    private final PrintStream originalOut = System.out;
    private Task46_MISTRAL_codestral_latest app;

    @BeforeEach
    public void setUp() throws Exception {
        // Delete existing database file to start fresh
        File dbFile = new File("user_database.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }
        // Create the users table
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "name TEXT, email TEXT PRIMARY KEY, password TEXT)");
        }
        app = new Task46_MISTRAL_codestral_latest();
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Restore System.out
        System.setOut(originalOut);
        // Clean up database file
        File dbFile = new File("user_database.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }
    }

    @Test
    public void testCreateTable() throws Exception {
        // Verify that the 'users' table exists
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT name FROM sqlite_master WHERE type='table' AND name='users'")) {
            assertTrue(rs.next(), "Table 'users' was not created");
        }
    }

    @Test
    public void testRegisterNewUser() throws Exception {
        // Register a new user
        app.registerUser("John Doe", "john@example.com", "password123");

        // Verify insertion
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
    public void testRegisterDuplicateEmail() throws Exception {
        // First registration
        app.registerUser("John Doe", "john@example.com", "password123");

        // Capture stdout for the duplicate attempt
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Attempt to register with the same email again
        app.registerUser("Jane Doe", "john@example.com", "password456");
        String output = outContent.toString();

        // Expect an SQLite constraint failure message
        assertTrue(output.contains("constraint failed"),
                "Expected constraint failure message, but got:\n" + output);

        // Ensure only one record exists for that email
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT COUNT(*) FROM users WHERE email = ?")) {
            ps.setString(1, "john@example.com");
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                assertEquals(1, rs.getInt(1), "Duplicate email was inserted");
            }
        }
    }

    @Test
    public void testRegisterUserValidity() throws Exception {
        // Register another user
        app.registerUser("Alice Smith", "alice@example.com", "password789");

        // Verify all fields stored correctly
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
