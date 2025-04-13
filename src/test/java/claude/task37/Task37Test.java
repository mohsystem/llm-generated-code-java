package claude.task37;

import org.junit.jupiter.api.*;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task37Test {

    private static Connection connection;

    @BeforeAll
    public static void setUpDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:test_db;DB_CLOSE_DELAY=-1");
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255))");
            statement.execute("INSERT INTO users (username) VALUES ('ahmad'), ('mohamed'), ('sara')");
        }
    }

    public String getUserInfo(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return "User found: " + resultSet.getString("username");
                } else {
                    return "User not found";
                }
            }
        }
    }

    @Test
    public void testUserFound() throws SQLException {
        String result = getUserInfo("ahmad");
        assertEquals("User found: ahmad", result);
    }

    @Test
    public void testUserNotFound() throws SQLException {
        String result = getUserInfo("john");
        assertEquals("User not found", result);
    }

    @AfterAll
    public static void closeDatabase() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
