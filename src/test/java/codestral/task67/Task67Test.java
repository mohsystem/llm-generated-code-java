package codestral.task67;

import org.junit.jupiter.api.*;

import java.io.File;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task67Test {

    private static final String DB_PATH = "./database";

    @BeforeAll
    public static void setupDatabase() throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:" + DB_PATH);
             Statement stmt = conn.createStatement()) {

            stmt.execute("DROP TABLE IF EXISTS customer");
            stmt.execute("CREATE TABLE customer (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "customerusername VARCHAR(255), " +
                    "other_column VARCHAR(255))");

            stmt.execute("INSERT INTO customer (customerusername, other_column) VALUES " +
                    "('john_doe', 'value1')," +
                    "('alice', 'value2')");
        }
    }

    @AfterAll
    public static void cleanup() {
        for (String ext : new String[]{".mv.db", ".trace.db"}) {
            File file = new File(DB_PATH + ext);
            if (file.exists()) file.delete();
        }
    }

    @Test
    public void testCustomerFound() throws Exception {
        String output = runMain("john_doe");
        assertTrue(output.contains("Customer Info: john_doe, value1"));
    }

    @Test
    public void testCustomerNotFound() throws Exception {
        String output = runMain("not_found");
        assertTrue(output.contains("No customer found with username: not_found"));
    }

    @Test
    public void testNoArguments() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp",
                System.getProperty("java.class.path"),
                "codestral.task67.Task67_MISTRAL_codestral_latest");
        pb.redirectErrorStream(true);
        Process process = pb.start();

        String output = new String(process.getInputStream().readAllBytes());
        process.waitFor();
        assertTrue(output.contains("Usage: java Task67_MISTRAL_codestral_latest"));
    }

    private String runMain(String arg) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp",
                System.getProperty("java.class.path"),
                "codestral.task67.Task67_MISTRAL_codestral_latest", arg);
        pb.redirectErrorStream(true);
        Process process = pb.start();
        String output = new String(process.getInputStream().readAllBytes());
        process.waitFor();
        return output.trim();
    }
}
