package claude.task94;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task94Test {

    private static final String TEST_FILE = "test_input.txt";
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() throws IOException {
        System.setOut(originalOut);
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testSortedRecordsFromFile() throws IOException {
        List<String> lines = Arrays.asList(
                "zebra: zoo",
                "apple: fruit",
                "mango: tropical"
        );
        Files.write(Paths.get(TEST_FILE), lines);

        Task94_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{TEST_FILE});
        String result = output.toString().trim();

        String expected = String.join(System.lineSeparator(),
                "apple: fruit",
                "mango: tropical",
                "zebra: zoo"
        );

        assertEquals(expected, result);
    }

    @Test
    void testFileNotFoundHandledGracefully() {
        String missingFile = "nonexistent_file.txt";
        assertDoesNotThrow(() ->
                Task94_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{missingFile}));
    }

    @Test
    void testInvalidLineHandled() throws IOException {
        List<String> lines = Arrays.asList(
                "banana - yellow", // invalid
                "pear: green",     // valid
                "invalid line"     // invalid
        );
        Files.write(Paths.get(TEST_FILE), lines);

        Task94_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{TEST_FILE});
        String result = output.toString().trim();

        assertTrue(result.contains("Warning: Skipping invalid line: banana - yellow"));
        assertTrue(result.contains("Warning: Skipping invalid line: invalid line"));
        assertTrue(result.contains("pear: green"));
    }
}
