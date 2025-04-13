package gemini.task46;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

public class Task46Test {
    private Connection conn;

    @BeforeEach
    void setUp() throws SQLException {
        // in‑memory SQLite
        conn = DriverManager.getConnection("jdbc:sqlite::memory:");
        createTable(conn);
    }

    @AfterEach
    void tearDown() throws SQLException {
        conn.close();
    }

    // re‑implements the table creation from your main()
    private void createTable(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS users (" +
                            "  id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "  name TEXT NOT NULL," +
                            "  email TEXT NOT NULL UNIQUE," +
                            "  password TEXT NOT NULL" +
                            ")"
            );
        }
    }

    // re‑implements your insert logic, returning the same messages
    private String registerUser(Connection conn, String name, String email, String password) {
        String sql = "INSERT INTO users(name, email, password) VALUES(?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            return "Registration successful!";
        } catch (SQLException e) {
            // match your catch‑block message
            if (e.getMessage().toLowerCase().contains("unique")) {
                return "Error: Email already exists.";
            }
            return "Error: " + e.getMessage();
        }
    }

    @Test
    void testCreateTable() throws SQLException {
        // verify 'users' table exists in sqlite_master
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT name FROM sqlite_master WHERE type='table' AND name='users'")) {
            assertTrue(rs.next(), "Table 'users' was not created");
        }
    }

    @Test
    void testRegisterNewUser() throws SQLException {
        String result = registerUser(conn,
                "John Doe",
                "john@example.com",
                "password123");
        assertEquals("Registration successful!", result);
    }

    @Test
    void testRegisterDuplicateEmail() throws SQLException {
        // first insert
        registerUser(conn, "John Doe", "john@example.com", "password123");

        // duplicate
        String result = registerUser(conn,
                "Jane Doe",
                "john@example.com",
                "password456");
        assertEquals("Error: Email already exists.", result);

        // ensure only one row for that email
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT COUNT(*) FROM users WHERE email='john@example.com'")) {
            rs.next();
            assertEquals(1, rs.getInt(1),
                    "Duplicate email was inserted into the table");
        }
    }

    @Test
    void testRegisterUserValidity() throws SQLException {
        registerUser(conn,
                "Alice Smith",
                "alice@example.com",
                "password789");

        try (PreparedStatement ps = conn.prepareStatement(
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
