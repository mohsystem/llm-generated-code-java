package gtp4o.task100;

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

        Task100_OPENAI_gpt_4o.main(new String[]{pattern, TEST_FILE});

        System.setOut(originalOut);
        return outContent.toString().trim();
    }

    @Test
    public void testMatchAppleAnywhereInFile() throws IOException {
        String output = runMain("apple");
        // Matches: "apple" in "apple pie" and "pineapple tart"
        assertEquals("apple\napple", output.replace("\r", ""));
    }

    @Test
    public void testExactWordFruit() throws IOException {
        String output = runMain("fruit");
        // Matches: "fruit" from "grape fruit"
        assertEquals("fruit", output);
    }

    @Test
    public void testNoMatch() throws IOException {
        String output = runMain("cherry");
        assertEquals("", output);
    }

    @Test
    public void testFileNotFound() {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errContent));

        Task100_OPENAI_gpt_4o.main(new String[]{"apple", "notfound.txt"});

        System.setErr(originalErr);
        assertTrue(errContent.toString().contains("NoSuchFileException"));
    }
}
