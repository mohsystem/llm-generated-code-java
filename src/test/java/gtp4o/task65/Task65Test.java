package gtp4o.task65;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
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
        String content = "Hello from GPT-4o!\nLine 2";
        Files.writeString(tempFile, content, StandardCharsets.UTF_8);

        // Act
        Task65_OPENAI_gpt_4o.main(new String[]{tempFile.toString()});

        // Assert
        String output = outContent.toString().trim();
        assertTrue(output.contains("Hello from GPT-4o!"));
        assertTrue(output.contains("Line 2"));
    }

    @Test
    public void testFileDoesNotExist() {
        // Act
        Task65_OPENAI_gpt_4o.main(new String[]{"missing_file.txt"});

        // Assert
        assertTrue(outContent.toString().trim().contains("File does not exist"));
    }

    @Test
    public void testNoArguments() {
        // Act
        Task65_OPENAI_gpt_4o.main(new String[]{});

        // Assert
        assertTrue(outContent.toString().trim().contains("Usage: java Task65_OPENAI_gpt_4o <filename>"));
    }
}
