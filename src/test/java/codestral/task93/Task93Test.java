package codestral.task93;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task93Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String HARDCODED_FILENAME = "path_to_your_file.txt";

    @BeforeEach
    void setUp() throws IOException {
        System.setOut(new PrintStream(outContent));
        // Ensure no old file is present
        Files.deleteIfExists(Paths.get(HARDCODED_FILENAME));
    }

    @AfterEach
    void tearDown() throws IOException {
        System.setOut(originalOut);
        Files.deleteIfExists(Paths.get(HARDCODED_FILENAME));
    }

    @Test
    void testValidSortedLines() throws IOException {
        List<String> lines = Arrays.asList(
                "banana: yellow",
                "apple: red",
                "carrot: orange"
        );
        Files.write(Paths.get(HARDCODED_FILENAME), lines);

        Task93_MISTRAL_codestral_latest.main(new String[0]);

        String expected = String.join(System.lineSeparator(),
                "apple: red",
                "banana: yellow",
                "carrot: orange"
        ) + System.lineSeparator();

        assertEquals(expected, outContent.toString());
    }

    @Test
    void testEmptyFile() throws IOException {
        Files.createFile(Paths.get(HARDCODED_FILENAME));

        Task93_MISTRAL_codestral_latest.main(new String[0]);

        assertEquals("", outContent.toString());
    }
    @Test
    void testFileNotFound() {
        // Ensure file does not exist
        File file = new File("path_to_your_file.txt");
        file.delete();

        // Run the main method without args
        assertDoesNotThrow(() -> {
            Task93_MISTRAL_codestral_latest.main(new String[0]);
        });

        // Check if output contains at least the word "at " from stack trace
        String output = outContent.toString();
        assertTrue(output.contains("at "), "Expected stack trace in output when file is missing");
    }

}
