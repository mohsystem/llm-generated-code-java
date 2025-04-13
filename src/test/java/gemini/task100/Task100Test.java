package gemini.task100;

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

        Task100_GEMINI_gemini_1_5_pro_001.main(new String[]{pattern, TEST_FILE});

        System.setOut(originalOut);
        return outContent.toString().trim();
    }

    @Test
    public void testMatchApple() throws IOException {
        String output = runMain("apple");
        // Matches lines that contain "apple" anywhere in them
        assertEquals("apple pie\npineapple tart", output.replace("\r", ""));
    }

    @Test
    public void testMatchSplit() throws IOException {
        String output = runMain("split");
        assertEquals("banana split", output);
    }

    @Test
    public void testMatchNothing() throws IOException {
        String output = runMain("cherry");
        assertEquals("", output);
    }

    @Test
    public void testFileNotFound() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setErr(new PrintStream(outContent)); // because it prints to System.err

        Task100_GEMINI_gemini_1_5_pro_001.main(new String[]{"apple", "missing.txt"});

        System.setErr(originalOut);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Error reading file"));
    }
}
