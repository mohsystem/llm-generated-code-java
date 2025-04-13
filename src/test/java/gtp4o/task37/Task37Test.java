package gtp4o.task37;

import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task37Test {

    private static Connection connection;

    @BeforeAll
    public static void setUpDatabase() throws Exception {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE users (username VARCHAR(255), info VARCHAR(255))");
            stmt.execute("INSERT INTO users (username, info) VALUES ('ahmad', 'Engineer'), ('sara', 'Designer')");
        }
    }

    public String getUserInfo(String username) throws SQLException {
        StringBuilder result = new StringBuilder();

        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result.append("User: ").append(rs.getString("username"))
                        .append(" - Info: ").append(rs.getString("info")).append("\n");
            }
        }

        return result.toString().trim();
    }

    @Test
    public void testUserAhmad() throws SQLException {
        assertEquals("User: ahmad - Info: Engineer", getUserInfo("ahmad"));
    }

    @Test
    public void testUserSara() throws SQLException {
        assertEquals("User: sara - Info: Designer", getUserInfo("sara"));
    }

    @Test
    public void testUserNotFound() throws SQLException {
        assertEquals("", getUserInfo("john"));
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (connection != null) connection.close();
    }
}
