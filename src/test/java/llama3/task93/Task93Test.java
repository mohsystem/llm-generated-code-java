package llama3.task93;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task93Test {

    private static final String INPUT_FILE = "input.txt";
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void redirectOutput() {
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreOutput() throws IOException {
        System.setOut(originalOut);
        Files.deleteIfExists(Paths.get(INPUT_FILE));
    }

    @Test
    void testSortedRecordsFromFile() throws IOException {
        List<String> lines = Arrays.asList(
                "z=last",
                "a=first",
                "m=middle"
        );
        Files.write(Paths.get(INPUT_FILE), lines);

        Task93_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        String result = output.toString().trim();

        String expected = String.join(System.lineSeparator(),
                "a=first",
                "m=middle",
                "z=last"
        );

        assertEquals(expected, result);
    }

    @Test
    void testFileNotFoundHandledGracefully() throws IOException {
        Files.deleteIfExists(Paths.get(INPUT_FILE)); // تأكد أنه مش موجود

         assertDoesNotThrow(() ->
                Task93_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{}));
    }

    @Test
    void testInvalidFormatIsHandledSilently() throws IOException {
        List<String> lines = Arrays.asList(
                "apple",
                "banana=yellow",
                "carrot=orange"
        );
        Files.write(Paths.get(INPUT_FILE), lines);

         assertDoesNotThrow(() ->
                Task93_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{}));
    }
}
