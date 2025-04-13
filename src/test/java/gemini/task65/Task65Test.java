package gemini.task65;

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
    public void testReadValidFile() throws IOException {
        // Arrange
        tempFile = Files.createTempFile("validfile", ".txt");
        String content = "Line 1\nLine 2\n";
        Files.write(tempFile, content.getBytes());

        // Act
        String result = Task65_GEMINI_gemini_1_5_pro_001.readFile(tempFile.toString());

        // Assert
        assertNotNull(result);
        assertEquals(content, result);
    }

    @Test
    public void testFileNotFound() {
        // Act
        String result = Task65_GEMINI_gemini_1_5_pro_001.readFile("nonexistent.txt");

        // Assert
        assertNull(result);
        assertTrue(errContent.toString().contains("Error reading file 'nonexistent.txt'"));
    }

    @Test
    public void testMainWithValidFile() throws IOException {
        // Arrange
        tempFile = Files.createTempFile("validfile", ".txt");
        String content = "Gemini testing line\nSecond line\n";
        Files.write(tempFile, content.getBytes());

        // Act
        Task65_GEMINI_gemini_1_5_pro_001.main(new String[]{tempFile.toString()});

        // Assert
        assertTrue(outContent.toString().contains("Gemini testing line"));
        assertTrue(outContent.toString().contains("Second line"));
    }

    @Test
    public void testMainWithNoArgs() {
        // Act
        Task65_GEMINI_gemini_1_5_pro_001.main(new String[]{});

        // Assert
        assertTrue(outContent.toString().contains("Usage: java Task65_GEMINI_gemini_1_5_pro_001 <filename>"));
    }
}
