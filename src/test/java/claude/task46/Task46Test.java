package claude.task46;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.sql.*;

public class Task46Test {
    // Must match the DB_URL in your Task46 class
    private static final String DB_URL = "jdbc:sqlite:users.db";

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUp() throws Exception {
        // Ensure a clean slate by deleting any existing database file
        File dbFile = new File("users.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }
        // Create the users table
        Task46_CLAUDE_claude_3_5_sonnet_20240620.createTable();
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Restore original streams
        System.setOut(originalOut);
        System.setIn(originalIn);
        // Clean up the database file again
        File dbFile = new File("users.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }
    }

    @Test
    public void testRegisterNewUser() throws Exception {
        // Simulate user entering name, email, password
        String input = String.join("\n",
                "John Doe",
                "john@example.com",
                "password123"
        ) + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method under test
        Task46_CLAUDE_claude_3_5_sonnet_20240620.registerUser();

        String output = outContent.toString();
        assertTrue(output.contains("Registration successful!"),
                "Expected success message, but got:\n" + output);
    }

    @Test
    public void testRegisterDuplicateEmail() throws Exception {
        // First registration (should succeed)
        String firstInput = String.join("\n",
                "John Doe",
                "john@example.com",
                "password123"
        ) + "\n";
        System.setIn(new ByteArrayInputStream(firstInput.getBytes()));
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
        Task46_CLAUDE_claude_3_5_sonnet_20240620.registerUser();

        // Attempt to register with the same email
        String secondInput = String.join("\n",
                "Jane Doe",
                "john@example.com",
                "password456"
        ) + "\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream(secondInput.getBytes()));
        System.setOut(new PrintStream(outContent));

        Task46_CLAUDE_claude_3_5_sonnet_20240620.registerUser();

        String output = outContent.toString();
        assertTrue(output.contains("Email already exists. Registration failed."),
                "Expected duplicate-email failure, but got:\n" + output);
    }

    @Test
    public void testCreateTable() throws Exception {
        // Verify that the 'users' table exists in sqlite_master
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT name FROM sqlite_master WHERE type='table' AND name='users'")) {
            assertTrue(rs.next(), "Table 'users' was not created");
        }
    }

    @Test
    public void testRegisterUserValidity() throws Exception {
        // Register a new user
        String input = String.join("\n",
                "Alice Smith",
                "alice@example.com",
                "password789"
        ) + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
        Task46_CLAUDE_claude_3_5_sonnet_20240620.registerUser();

        // Query the database directly to ensure the row was inserted correctly
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT name, email, password FROM users WHERE email = ?")) {
            pstmt.setString(1, "alice@example.com");
            try (ResultSet rs = pstmt.executeQuery()) {
                assertTrue(rs.next(), "User was not registered in the database");
                assertEquals("Alice Smith",       rs.getString("name"));
                assertEquals("alice@example.com", rs.getString("email"));
                assertEquals("password789",       rs.getString("password"));
            }
        }
    }
}
