package codestral.task65;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task65Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Path tempFile;

    @BeforeEach
    public void redirectOutput() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreOutput() throws IOException {
        System.setOut(originalOut);
        if (tempFile != null && Files.exists(tempFile)) {
            Files.delete(tempFile);
        }
        outContent.reset();
    }

    @Test
    public void testFileExistsAndReadable() throws IOException {
        // Arrange
        tempFile = Files.createTempFile("testfile", ".txt");
        Files.write(tempFile, "Line 1\nLine 2\n".getBytes());

        // Act
        Task65_MISTRAL_codestral_latest.main(new String[]{tempFile.toString()});

        // Assert
        String output = outContent.toString().trim();
        assertTrue(output.contains("Line 1"));
        assertTrue(output.contains("Line 2"));
    }

    @Test
    public void testFileNotFound() {
        // Act
        Task65_MISTRAL_codestral_latest.main(new String[]{"notfound.txt"});

        // Assert
        String output = outContent.toString().trim();
        assertTrue(output.contains("Error: File not found."));
    }

    @Test
    public void testNoArgument() {
        // Act
        Task65_MISTRAL_codestral_latest.main(new String[]{});

        // Assert
        String output = outContent.toString().trim();
        assertTrue(output.contains("Usage: java Task65_MISTRAL_codestral_latest <filename>"));
    }
}
