package gemini.task37;

import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task37Test {

    private static Connection connection;

    @BeforeAll
    public static void setUpDatabase() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE users (id INTEGER PRIMARY KEY, username TEXT, email TEXT)");
            stmt.execute("INSERT INTO users (username, email) VALUES ('ahmad', 'ahmad@gmail.com'), ('sara', 'sara@gmail.com')");
        }
    }

    public String findUser(String username) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = "SELECT * FROM users WHERE username='" + username + "'";
        ResultSet rs = stmt.executeQuery(query);

        String result;
        if (rs.next()) {
            result = rs.getString("username") + " " + rs.getString("email");
        } else {
            result = "User not found.";
        }

        rs.close();
        stmt.close();

        return result;
    }

    @Test
    public void testUserFound_Ahmad() throws SQLException {
        String result = findUser("ahmad");
        assertEquals("ahmad ahmad@gmail.com", result);
    }

    @Test
    public void testUserFound_Sara() throws SQLException {
        String result = findUser("sara");
        assertEquals("sara sara@gmail.com", result);
    }

    @Test
    public void testUserNotFound() throws SQLException {
        String result = findUser("john");
        assertEquals("User not found.", result);
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (connection != null) connection.close();
    }
}
