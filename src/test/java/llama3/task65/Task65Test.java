package llama3.task65;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task65Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private Path tempFile;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void tearDown() throws IOException {
        System.setOut(originalOut);
        System.setErr(originalErr);
        if (tempFile != null && Files.exists(tempFile)) {
            Files.delete(tempFile);
        }
        outContent.reset();
        errContent.reset();
    }

    @Test
    public void testFileExists() throws IOException {
        // Arrange
        tempFile = Files.createTempFile("llama3", ".txt");
        String content = "Hello Abdulrahman\nLine 2";
        Files.write(tempFile, content.getBytes());

        // Act
        Task65_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{tempFile.toString()});

        // Assert
        String output = outContent.toString().trim();
        assertTrue(output.contains("Hello Abdulrahman"));
        assertTrue(output.contains("Line 2"));
    }

    @Test
    public void testFileNotFound() {
        // Act
        Task65_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{"doesnotexist.txt"});

        // Assert
        String error = errContent.toString().trim();
        assertTrue(error.contains("Error: An error occurred while reading file"));
    }

    @Test
    public void testNoArguments() {
        // Act
        Task65_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});

        // Assert
        String output = outContent.toString().trim();
        assertTrue(output.contains("Usage: java Task65_PERPLEXITY_llama_3_sonar_large_32k_chat <filename>"));
    }
}
