package claude.task93;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task93Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testValidSortedRecords() throws IOException {
        String content = String.join("\n",
                "banana: yellow",
                "apple: red",
                "carrot: orange"
        );
        Path tempFile = Files.createTempFile("records", ".txt");
        Files.write(tempFile, content.getBytes());

        Task93_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{tempFile.toString()});

        String expected = String.join(System.lineSeparator(),
                "apple: red",
                "banana: yellow",
                "carrot: orange"
        ) + System.lineSeparator();

        assertEquals(expected, outContent.toString());

        Files.deleteIfExists(tempFile);
    }

    @Test
    void testInvalidLineFormat() throws IOException {
        String content = String.join("\n",
                "banana: yellow",
                "invalid line",
                "apple: red"
        );
        Path tempFile = Files.createTempFile("records", ".txt");
        Files.write(tempFile, content.getBytes());

        Task93_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{tempFile.toString()});

        String output = outContent.toString();
        assertTrue(output.contains("Warning: Skipping invalid line: invalid line"));
        assertTrue(output.contains("apple: red"));
        assertTrue(output.contains("banana: yellow"));

        Files.deleteIfExists(tempFile);
    }

    @Test
    void testMissingFile() {
        String fakePath = "nonexistent_file.txt";
        Task93_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{fakePath});
        String output = outContent.toString();
        assertTrue(output.startsWith("Error reading file:"));
    }

    @Test
    void testMissingArgument() {
        Task93_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
        String expected = "Usage: java Task93_CLAUDE_claude_3_5_sonnet_20240620 <filename>";
        assertEquals(expected, outContent.toString().trim());
    }

}
