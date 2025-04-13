package claude.task100;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task100Test {

    private static final String TEST_FILE = "test_input.txt";

    @BeforeEach
    public void setup() throws IOException {
        List<String> lines = Arrays.asList(
                "apple pie",
                "banana split",
                "grape fruit",
                "pineapple tart"
        );
        Files.write(Paths.get(TEST_FILE), lines);
    }

    @AfterEach
    public void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    private String runMain(String pattern) throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Task100_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{pattern, TEST_FILE});

        System.setOut(originalOut);
        return outContent.toString().trim();
    }

    @Test
    public void testMatchPine() throws IOException {
        String output = runMain("pine");
        assertEquals("pineapple tart", output);
    }

    @Test
    public void testMatchFruit() throws IOException {
        String output = runMain("fruit");
        assertEquals("grape fruit", output);
    }

    @Test
    public void testMatchNothing() throws IOException {
        String output = runMain("cherry");
        assertEquals("", output);
    }

    @Test
    public void testInvalidRegex() throws IOException {
        String output = runMain("[a-z");
        assertTrue(output.contains("Error"));
    }

    @Test
    public void testFileNotFound() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Task100_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{"apple", "nonexistent.txt"});

        System.setOut(originalOut);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Error"));
    }
}
