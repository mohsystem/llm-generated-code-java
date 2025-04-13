package claude.task36;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class Task36Test {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    private void createTempFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
    }

    @Test
    void testReadFileSuccess() throws IOException {
        String filename = "test_file.txt";
        createTempFile(filename, "Hello, World!");
        Task36_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{filename});
        assertEquals("Hello, World!", outContent.toString().trim());
        new File(filename).delete();
    }

    @Test
    void testFileNotFound() {
        String filename = "missing_file.txt";
        Task36_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{filename});
        assertTrue(outContent.toString().contains("Error reading file"));
    }

    @Test
    void testReadEmptyFile() throws IOException {
        String filename = "empty_file.txt";
        createTempFile(filename, "");
        Task36_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{filename});
        assertEquals("", outContent.toString().trim());
        new File(filename).delete();
    }

    @Test
    void testNumericContent() throws IOException {
        String filename = "numeric_file.txt";
        createTempFile(filename, "12345");
        Task36_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{filename});
        assertEquals("12345", outContent.toString().trim());
        new File(filename).delete();
    }

    @Test
    void testSpecialCharacters() throws IOException {
        String filename = "special_chars.txt";
        createTempFile(filename, "Special Characters !@#$%^&*()");
        Task36_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{filename});
        assertEquals("Special Characters !@#$%^&*()", outContent.toString().trim());
        new File(filename).delete();
    }

    @Test
    void testMultilineContent() throws IOException {
        String filename = "multiline_file.txt";
        createTempFile(filename, "Line 1\nLine 2");
        Task36_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{filename});
        String[] lines = outContent.toString().split("\\R"); // \R matches any line break
        assertEquals("Line 1", lines[0]);
        assertEquals("Line 2", lines[1]);
        new File(filename).delete();
    }

    @Test
    void testContentWithNewlines() throws IOException {
        String filename = "newlines_file.txt";
        createTempFile(filename, "File\nWith\nNewlines");
        Task36_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{filename});
        String[] lines = outContent.toString().split("\\R");
        assertEquals("File", lines[0]);
        assertEquals("With", lines[1]);
        assertEquals("Newlines", lines[2]);
        new File(filename).delete();
    }

    @Test
    void testTrailingSpaces() throws IOException {
        String filename = "trailing_spaces.txt";
        createTempFile(filename, "Trailing spaces    ");
        Task36_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{filename});
        assertEquals("Trailing spaces", outContent.toString().trim());
        new File(filename).delete();
    }


}
