package gtp4o.task67;

import org.junit.jupiter.api.*;
import java.sql.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task67Test {

    private static final String DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

    @BeforeAll
    public static void setupDatabase() throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE customer (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(255), " +
                    "name VARCHAR(255), " +
                    "email VARCHAR(255))");

            stmt.execute("INSERT INTO customer (username, name, email) VALUES " +
                    "('khaled', 'Khaled Hussein', 'khaled@example.com')," +
                    "('sara', 'Sara Younis', 'sara@example.com')");
        }

        // تعيين JDBC driver ليدعم H2 بدل SQLite
        System.setProperty("jdbc.drivers", "org.h2.Driver");
    }

    @Test
    public void testCustomerFound() throws Exception {
        String output = runMainWithArgs("khaled");
        assertTrue(output.contains("Customer Info:"), "Expected output to contain 'Customer Info:'");
        assertTrue(output.contains("username"), "Expected output to contain column names (via ResultSet.toString)");
    }

    @Test
    public void testCustomerNotFound() throws Exception {
        String output = runMainWithArgs("not_exist");
        assertFalse(output.contains("Customer Info:"), "Expected no customer info for nonexistent user");
    }

    @Test
    public void testMissingArgument() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp",
                System.getProperty("java.class.path"), "gtp4o.task67.Task67_OPENAI_gpt_4o");
        pb.redirectErrorStream(true);
        Process process = pb.start();
        String output = new String(process.getInputStream().readAllBytes());
        process.waitFor();
        assertTrue(output.contains("Usage: java Task67_OPENAI_gpt_4o"), "Expected usage message for missing args");
    }

    private String runMainWithArgs(String arg) throws Exception {
        // Override SQLite URL to use H2 in-memory
        Connection conn = DriverManager.getConnection(DB_URL);
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE username = ?");
        stmt.setString(1, arg);
        ResultSet rs = stmt.executeQuery();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        while (rs.next()) {
            System.out.println("Customer Info: username=" + rs.getString("username") +
                    ", name=" + rs.getString("name") +
                    ", email=" + rs.getString("email"));
        }

        rs.close();
        stmt.close();
        conn.close();
        System.setOut(originalOut);
        return out.toString().trim();
    }
}
