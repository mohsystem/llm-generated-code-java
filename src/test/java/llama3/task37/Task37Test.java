package llama3.task37;

import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task37Test {

    private static Connection connection;

    @BeforeAll
    public static void setupDatabase() throws Exception {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE users (username VARCHAR(255), email VARCHAR(255))");
            stmt.execute("INSERT INTO users (username, email) VALUES " +
                    "('ahmad', 'ahmad@gmail.com'), " +
                    "('sara', 'sara@gmail.com')");
        }
    }

    public String getUserInfo(String username) throws SQLException {
        String result;
        String query = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                result = "User found: " + rs.getString("username") + ", " + rs.getString("email");
            } else {
                result = "User not found";
            }
        }

        return result;
    }

    @Test
    public void testUserFound_Ahmad() throws SQLException {
        assertEquals("User found: ahmad, ahmad@gmail.com", getUserInfo("ahmad"));
    }

    @Test
    public void testUserFound_Sara() throws SQLException {
        assertEquals("User found: sara, sara@gmail.com", getUserInfo("sara"));
    }

    @Test
    public void testUserNotFound() throws SQLException {
        assertEquals("User not found", getUserInfo("john"));
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (connection != null) connection.close();
    }
}
