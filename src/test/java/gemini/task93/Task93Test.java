package gemini.task93;

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
    void tearDown() throws IOException {
        System.setOut(originalOut);
        Files.deleteIfExists(Paths.get("path_to_temp_file.txt"));
    }

    @Test
    void testValidSortedRecords() throws IOException {
        String content = String.join("\n",
                "banana=yellow",
                "apple=red",
                "carrot=orange"
        );
        Path file = Paths.get("path_to_temp_file.txt");
        Files.write(file, content.getBytes());

        Task93_GEMINI_gemini_1_5_pro_001.main(new String[]{file.toString()});

        String expected = String.join(System.lineSeparator(),
                "apple=red",
                "banana=yellow",
                "carrot=orange"
        ) + System.lineSeparator();

        assertEquals(expected, outContent.toString());
    }

    @Test
    void testMissingArgument() {
        Task93_GEMINI_gemini_1_5_pro_001.main(new String[]{});
        String output = outContent.toString().trim();
        assertEquals("Usage: java Task93_GEMINI_gemini_1_5_pro_001 <file_path>", output);
    }
    @Test
    void testFileNotFound() {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        Task93_GEMINI_gemini_1_5_pro_001.main(new String[]{"non_existent_file.txt"});

        String errorOutput = errContent.toString();
        assertTrue(errorOutput.contains("Error reading file:"), "Should print file error message to stderr");

        System.setErr(System.err);
    }

    @Test
    void testInvalidLinesIgnored() throws IOException {
        String content = String.join("\n",
                "banana=yellow",
                "invalid_line",
                "apple=red"
        );
        Path file = Paths.get("path_to_temp_file.txt");
        Files.write(file, content.getBytes());

        Task93_GEMINI_gemini_1_5_pro_001.main(new String[]{file.toString()});

        String output = outContent.toString();
        assertTrue(output.contains("apple=red"));
        assertTrue(output.contains("banana=yellow"));
        assertFalse(output.contains("invalid_line"));
    }
}
