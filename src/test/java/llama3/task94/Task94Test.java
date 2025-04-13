package llama3.task94;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task94Test {

    private static final String INPUT_FILE = "input.txt";
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void redirectOutput() {
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void cleanUp() throws IOException {
        System.setOut(originalOut);
        Files.deleteIfExists(Paths.get(INPUT_FILE));
    }

    @Test
    void testSortedKeyValueFromFile() throws IOException {
        List<String> lines = Arrays.asList(
                "zebra=zoo",
                "apple=fruit",
                "mango=tropical"
        );
        Files.write(Paths.get(INPUT_FILE), lines);

        Task94_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        String result = output.toString().trim();

        String expected = String.join(System.lineSeparator(),
                "apple=fruit",
                "mango=tropical",
                "zebra=zoo"
        );

        assertEquals(expected, result);
    }

    @Test
    void testFileNotFoundHandled() {
        try {
            Files.deleteIfExists(Paths.get(INPUT_FILE));
        } catch (IOException ignored) {}

        assertThrows(IOException.class, () -> {
            Task94_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        });
    }

    @Test
    void testEmptyFileProducesNoOutput() throws IOException {
        Files.write(Paths.get(INPUT_FILE), Collections.emptyList());

        Task94_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        String result = output.toString().trim();

        assertEquals("", result);
    }
}
