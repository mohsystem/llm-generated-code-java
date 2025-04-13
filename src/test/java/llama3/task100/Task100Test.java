package llama3.task100;

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
        Path path = Paths.get(TEST_FILE);
        for (int i = 0; i < 5; i++) {
            try {
                Files.deleteIfExists(path);
                break;
            } catch (FileSystemException e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {}
            }
        }
    }



    private String runMain(String pattern) throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Task100_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{pattern, TEST_FILE});

        System.setOut(originalOut);
        return outContent.toString().trim();
    }

    @Test
    public void testMatchApple() throws IOException {
        String output = runMain("apple");
        // Matches "apple" from "apple pie" and "pineapple tart"
        assertEquals("apple\napple", output.replace("\r", ""));
    }

    @Test
    public void testMatchSplit() throws IOException {
        String output = runMain("split");
        assertEquals("split", output);
    }

    @Test
    public void testNoMatch() throws IOException {
        String output = runMain("cherry");
        assertEquals("", output);
    }

    @Test
    public void testMatchWordEnd() throws IOException {
        String output = runMain("tart$");
        assertEquals("tart", output);
    }
}
