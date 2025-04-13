package llama3.task46;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.sql.*;

public class Task46Test {
    private static final String DB_URL = "jdbc:sqlite:users.db";
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() throws Exception {
        // Delete any existing database file so each test starts fresh
        File dbFile = new File("users.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }
        // Create the users table exactly as in your production code
        Task46_PERPLEXITY_llama_3_sonar_large_32k_chat.createTable();
    }

    @AfterEach
    void tearDown() {
        // Restore System.out in case a test captured it
        System.setOut(originalOut);
        // Clean up the database file
        File dbFile = new File("users.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }
    }

    @Test
    void testCreateTable() throws SQLException {
        // Verify that the 'users' table exists in sqlite_master
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT name FROM sqlite_master WHERE type='table' AND name='users'")) {
            assertTrue(rs.next(), "Table 'users' should have been created");
        }
    }

    @Test
    void testRegisterNewUser() throws SQLException {
        // Capture any console output (there should be none on success)
        System.setOut(new PrintStream(new ByteArrayOutputStream()));

        // Register a fresh user
        Task46_PERPLEXITY_llama_3_sonar_large_32k_chat.registerUser(
                "John Doe", "john@example.com", "password123"
        );

        // Verify insertion by querying the database
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT name, email, password FROM users WHERE email = ?"
             )) {
            ps.setString(1, "john@example.com");
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue(rs.next(), "User was not inserted into the database");
                assertEquals("John Doe",         rs.getString("name"));
                assertEquals("john@example.com", rs.getString("email"));
                assertEquals("password123",      rs.getString("password"));
            }
        }
    }

    @Test
    void testRegisterDuplicateEmail() throws SQLException {
        // First registration should succeed
        Task46_PERPLEXITY_llama_3_sonar_large_32k_chat.registerUser(
                "John Doe", "john@example.com", "password123"
        );

        // Capture System.out to inspect the duplicate‐email error message
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Attempt to register a different user with the same email
        Task46_PERPLEXITY_llama_3_sonar_large_32k_chat.registerUser(
                "Jane Doe", "john@example.com", "password456"
        );

        String output = outContent.toString();
        assertTrue(
                output.contains("Error registering user:"),
                "Expected an error message on duplicate email, but got:\n" + output
        );

        // Ensure only one record exists for that email
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT COUNT(*) FROM users WHERE email = ?"
             )) {
            ps.setString(1, "john@example.com");
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                assertEquals(1, rs.getInt(1),
                        "Duplicate email should not have been inserted");
            }
        }
    }

    @Test
    void testRegisterUserValidity() throws SQLException {
        // Register another user
        Task46_PERPLEXITY_llama_3_sonar_large_32k_chat.registerUser(
                "Alice Smith", "alice@example.com", "password789"
        );

        // Query and verify all fields are stored correctly
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT name, email, password FROM users WHERE email = ?"
             )) {
            ps.setString(1, "alice@example.com");
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue(rs.next(), "User was not registered");
                assertEquals("Alice Smith",        rs.getString("name"));
                assertEquals("alice@example.com",  rs.getString("email"));
                assertEquals("password789",        rs.getString("password"));
            }
        }
    }
}
