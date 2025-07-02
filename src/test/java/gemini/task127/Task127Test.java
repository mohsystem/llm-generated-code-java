package gemini.task127;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task127Test {

    private static final String SOURCE_FILE = "gemini_test_input.txt";

    @BeforeEach
    public void setup() throws IOException {
        try (FileWriter writer = new FileWriter(SOURCE_FILE)) {
            writer.write("Test data from Gemini.");
        }
    }

    @AfterEach
    public void cleanup() {
        new File(SOURCE_FILE).delete();
    }

    @Test
    public void testSuccessfulCopyToTempFile() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        Task127_GEMINI_gemini_1_5_pro_001.processFile(SOURCE_FILE);

        System.setOut(originalOut);

        String output = out.toString();
        assertTrue(output.contains("File copied successfully to:"), "Should print success message with temp file location.");
    }

    @Test
    public void testFileNotFound() {
        String fakePath = "nonexistent_file.txt";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Task127_GEMINI_gemini_1_5_pro_001.processFile(fakePath);

        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("Error: File not found at"), "Should print file not found message.");
    }

    @Test
    public void testNullInputPath() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Task127_GEMINI_gemini_1_5_pro_001.processFile(null);

        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("An unexpected error occurred") || output.contains("null"), "Should handle null input gracefully.");
    }
}
