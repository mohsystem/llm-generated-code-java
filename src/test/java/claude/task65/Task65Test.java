package claude.task65;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task65Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Path tempFile;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() throws IOException {
        System.setOut(originalOut);
        if (tempFile != null && Files.exists(tempFile)) {
            Files.delete(tempFile);
        }
        outContent.reset();
    }

    @Test
    public void testFileWithWrongExtension() {
        Task65_CLAUDE_claude_3_5_sonnet_20240620.readFile("data.json");
        assertTrue(outContent.toString().trim().contains("Error: File must have a .txt extension"));
    }

    @Test
    public void testFileDoesNotExist() {
        Task65_CLAUDE_claude_3_5_sonnet_20240620.readFile("nonexistent.txt");
        assertTrue(outContent.toString().trim().contains("Error: File 'nonexistent.txt' does not exist"));
    }

    @Test
    public void testValidTextFile() throws IOException {
        // Arrange
        tempFile = Files.createTempFile("sample", ".txt");
        String content = "Hello Abdulrahman!\nWelcome to the test.";
        Files.write(tempFile, content.getBytes());

        // Act
        Task65_CLAUDE_claude_3_5_sonnet_20240620.readFile(tempFile.toString());

        // Assert
        String output = outContent.toString().trim();
        assertTrue(output.contains("File contents:"));
        assertTrue(output.contains("Hello Abdulrahman!"));
        assertTrue(output.contains("Welcome to the test."));
    }

    @Test
    public void testNoArgument() {
        Task65_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
        assertTrue(outContent.toString().trim().contains("Usage: java Task65_CLAUDE_claude_3_5_sonnet_20240620 <filename>"));
    }
}
