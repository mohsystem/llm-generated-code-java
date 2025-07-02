package codestral.task102;

import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task102Test {

    private final String DB_URL = "jdbc:sqlite:user_database.db";

    @BeforeEach
    public void setup() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS users");
            stmt.execute("CREATE TABLE users (username TEXT PRIMARY KEY, password TEXT)");
        }
    }

    @Test
    public void testUpdatePassword_alice() throws Exception {
        insertUser("alice", "oldhash");
        runAndAssert("alice", "mypassword123", "6e659deaa85842cdabb5c6305fcc40033ba43772ec00d45c2a3c921741a5e377");
    }

    @Test
    public void testUpdatePassword_bob() throws Exception {
        insertUser("bob", "oldhash");
        runAndAssert("bob", "Secure!Pass456", "9acd647df4d52296793a7b295c4be95cc11ecb2a9d7671a8dac5ea09a6ba67a3");
    }

    @Test
    public void testUpdatePassword_charlie() throws Exception {
        insertUser("charlie", "oldhash");
        runAndAssert("charlie", "123456", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");
    }

    private void insertUser(String username, String dummyHash) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)")) {
            pstmt.setString(1, username);
            pstmt.setString(2, dummyHash);
            pstmt.executeUpdate();
        }
    }

    private void runAndAssert(String username, String password, String expectedHash) throws Exception {
        Task102_MISTRAL_codestral_latest.updatePassword(username, password);

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT password FROM users WHERE username = ?")) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            assertTrue(rs.next(), "User should exist in DB");
            String actualHash = rs.getString("password");
            assertEquals(expectedHash, actualHash, "Password hash does not match expected");
        }
    }
}
