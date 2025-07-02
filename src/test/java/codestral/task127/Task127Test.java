package codestral.task127;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task127Test {

    private static final String SOURCE = "source_file.txt";
    private static final String DEST = "destination_file.txt";

    @BeforeEach
    public void setup() throws IOException {
        // Create source file with sample content
        try (FileWriter writer = new FileWriter(SOURCE)) {
            writer.write("This is a test.");
        }
    }

    @AfterEach
    public void cleanup() {
        new File(SOURCE).delete();
        new File(DEST).delete();
    }

    @Test
    public void testFileCopySuccess() throws IOException {
        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        // Run main
        Task127_MISTRAL_codestral_latest.main(new String[0]);

        System.setOut(originalOut);

        // Assert that destination file was created and content matches
        File destFile = new File(DEST);
        assertTrue(destFile.exists(), "Destination file should exist.");

        String content = new String(java.nio.file.Files.readAllBytes(destFile.toPath()));
        assertEquals("This is a test.", content);
    }

    @Test
    public void testSourceFileNotFound() {
        // Delete the source file to trigger error
        new File(SOURCE).delete();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Task127_MISTRAL_codestral_latest.main(new String[0]);

        System.setOut(System.out);

        String consoleOutput = out.toString();
        assertTrue(consoleOutput.contains("An error occurred:"), "Should print error message.");
    }
}
