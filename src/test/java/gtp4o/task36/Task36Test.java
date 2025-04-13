package gtp4o.task36;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class Task36Test {

    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
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
        Task36_OPENAI_gpt_4o.main(new String[]{filename});
        assertTrue(outContent.toString().contains("Hello, World!"));
        new File(filename).delete();
    }

    @Test
    void testFileNotFound() {
        String filename = "missing_file.txt";
        Task36_OPENAI_gpt_4o.main(new String[]{filename});
        assertTrue(errContent.toString().contains("FileNotFoundException"));
    }

    @Test
    void testUsageMessage() {
        Task36_OPENAI_gpt_4o.main(new String[]{});
        assertTrue(outContent.toString().contains("Usage: java Task36_OPENAI_gpt_4o <file_name>"));
    }

    @Test
    void testReadEmptyFile() throws IOException {
        String filename = "empty_file.txt";
        createTempFile(filename, "");
        Task36_OPENAI_gpt_4o.main(new String[]{filename});
        assertEquals("", outContent.toString().trim());
        new File(filename).delete();
    }

    @Test
    void testNumericContent() throws IOException {
        String filename = "numeric_file.txt";
        createTempFile(filename, "12345");
        Task36_OPENAI_gpt_4o.main(new String[]{filename});
        assertTrue(outContent.toString().contains("12345"));
        new File(filename).delete();
    }

    @Test
    void testSpecialCharacters() throws IOException {
        String filename = "special_chars.txt";
        createTempFile(filename, "Special Characters !@#$%^&*()");
        Task36_OPENAI_gpt_4o.main(new String[]{filename});
        assertTrue(outContent.toString().contains("Special Characters !@#$%^&*()"));
        new File(filename).delete();
    }

    @Test
    void testMultilineContent() throws IOException {
        String filename = "multiline_file.txt";
        createTempFile(filename, "Line 1\nLine 2");
        Task36_OPENAI_gpt_4o.main(new String[]{filename});
        String output = outContent.toString();
        assertTrue(output.contains("Line 1"));
        assertTrue(output.contains("Line 2"));
        new File(filename).delete();
    }

    @Test
    void testTrailingSpaces() throws IOException {
        String filename = "trailing_spaces.txt";
        createTempFile(filename, "Trailing spaces    ");
        Task36_OPENAI_gpt_4o.main(new String[]{filename});
        assertTrue(outContent.toString().contains("Trailing spaces"));
        new File(filename).delete();
    }

    @Test
    void testContentWithNewlines() throws IOException {
        String filename = "newlines_file.txt";
        createTempFile(filename, "File\nWith\nNewlines");
        Task36_OPENAI_gpt_4o.main(new String[]{filename});
        String output = outContent.toString();
        assertTrue(output.contains("File"));
        assertTrue(output.contains("With"));
        assertTrue(output.contains("Newlines"));
        new File(filename).delete();
    }
}
