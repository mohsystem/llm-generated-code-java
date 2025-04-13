package codestral.task37;

import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task37Test {

    private static Connection connection;

    @BeforeAll
    public static void setUpDatabase() throws Exception {
        // تحميل درايفر H2
        Class.forName("org.h2.Driver");

        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE users (id INT PRIMARY KEY, username VARCHAR(255), email VARCHAR(255))");
            stmt.execute("INSERT INTO users VALUES (1, 'ahmad', 'ahmad@gmail.com'), " +
                    "(2, 'mona', 'mona@gmail.com')");
        }
    }

    public String findUserByUsername(String username) throws SQLException {
        StringBuilder output = new StringBuilder();

        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                output.append(rs.getInt("id")).append(" ")
                        .append(rs.getString("username")).append(" ")
                        .append(rs.getString("email")).append("\n");
            }
        }
        return output.toString().trim();
    }

    @Test
    public void testUserAhmadExists() throws SQLException {
        String result = findUserByUsername("ahmad");
        assertEquals("1 ahmad ahmad@gmail.com", result);
    }

    @Test
    public void testUserMonaExists() throws SQLException {
        String result = findUserByUsername("mona");
        assertEquals("2 mona mona@gmail.com", result);
    }

    @Test
    public void testUserNotFound() throws SQLException {
        String result = findUserByUsername("john");
        assertEquals("", result);
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
