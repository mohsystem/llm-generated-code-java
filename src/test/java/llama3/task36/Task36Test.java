package llama3.task36;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class Task36Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private void simulateUserInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void createTempFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
    }

    @Test
    void testReadFileSuccess() throws Exception {
        String filename = "test_file.txt";
        createTempFile(filename, "Hello, World!");
        simulateUserInput(filename + "\n");
        Task36_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        assertTrue(outContent.toString().contains("Hello, World!"));
        new File(filename).delete();
    }

    @Test
    void testFileNotFound() {
        String filename = "missing_file.txt";
        simulateUserInput(filename + "\n");
        Exception exception = assertThrows(Exception.class, () -> {
            Task36_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        });
        assertTrue(exception instanceof FileNotFoundException);
    }

    @Test
    void testReadEmptyFile() throws Exception {
        String filename = "empty_file.txt";
        createTempFile(filename, "");
        simulateUserInput(filename + "\n");
        Task36_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        assertEquals(1, outContent.toString().split("\\R").length); // فقط سطر الإدخال
        new File(filename).delete();
    }

    @Test
    void testNumericContent() throws Exception {
        String filename = "numeric_file.txt";
        createTempFile(filename, "12345");
        simulateUserInput(filename + "\n");
        Task36_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        assertTrue(outContent.toString().contains("12345"));
        new File(filename).delete();
    }

    @Test
    void testSpecialCharacters() throws Exception {
        String filename = "special_chars.txt";
        createTempFile(filename, "Special Characters !@#$%^&*()");
        simulateUserInput(filename + "\n");
        Task36_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        assertTrue(outContent.toString().contains("Special Characters !@#$%^&*()"));
        new File(filename).delete();
    }

    @Test
    void testMultilineContent() throws Exception {
        String filename = "multiline_file.txt";
        createTempFile(filename, "Line 1\nLine 2");
        simulateUserInput(filename + "\n");
        Task36_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Line 1"));
        assertTrue(output.contains("Line 2"));
        new File(filename).delete();
    }

    @Test
    void testTrailingSpaces() throws Exception {
        String filename = "trailing_spaces.txt";
        createTempFile(filename, "Trailing spaces    ");
        simulateUserInput(filename + "\n");
        Task36_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        assertTrue(outContent.toString().contains("Trailing spaces"));
        new File(filename).delete();
    }

    @Test
    void testContentWithNewlines() throws Exception {
        String filename = "newlines_file.txt";
        createTempFile(filename, "File\nWith\nNewlines");
        simulateUserInput(filename + "\n");
        Task36_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("File"));
        assertTrue(output.contains("With"));
        assertTrue(output.contains("Newlines"));
        new File(filename).delete();
    }
}
