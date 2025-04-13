package llama3.task67;

import org.junit.jupiter.api.*;
import java.sql.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task67Test{

    private static final String DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

    @BeforeAll
    public static void setupDatabase() throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        Statement stmt = conn.createStatement();

        stmt.execute("CREATE TABLE customer (" +
                "customerusername VARCHAR(255), " +
                "name VARCHAR(255), " +
                "email VARCHAR(255))");

        stmt.execute("INSERT INTO customer (customerusername, name, email) VALUES " +
                "('osama', 'Osama Khalil', 'osama@example.com')," +
                "('nour', 'Nour Hasan', 'nour@example.com')");

        stmt.close();
        conn.close();

         System.setProperty("jdbc.drivers", "org.h2.Driver");
    }

    @Test
    public void testCustomerFound() throws Exception {
        String output = runWithArgs("osama");
        assertTrue(output.contains("osama"), "Expected output to contain username 'osama'");
    }

    @Test
    public void testCustomerNotFound() throws Exception {
        String output = runWithArgs("not_found");
        assertTrue(output.contains("Customer not found"), "Expected 'Customer not found' message");
    }

    @Test
    public void testMissingArgument() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp",
                System.getProperty("java.class.path"),
                "llama3.task67.Task67_PERPLEXITY_llama_3_sonar_large_32k_chat");
        pb.redirectErrorStream(true);
        Process process = pb.start();
        String output = new String(process.getInputStream().readAllBytes());
        process.waitFor();
        assertTrue(output.contains("Usage: java Task67_PERPLEXITY_llama_3_sonar_large_32k_chat"), "Expected usage message");
    }

    private String runWithArgs(String username) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE customerusername = ?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        if (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " ...");
        } else {
            System.out.println("Customer not found");
        }

        System.setOut(originalOut);
        rs.close();
        stmt.close();
        conn.close();

        return out.toString().trim();
    }
}
