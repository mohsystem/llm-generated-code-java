package gtp4o.task94;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task94Test {

    private static final String FILE_NAME = "test_input.txt";
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
        Files.deleteIfExists(Paths.get(FILE_NAME));
    }

    @Test
    void testSortedKeyValueOutput() throws IOException {
        List<String> lines = Arrays.asList(
                "zebra=zoo",
                "apple=fruit",
                "mango=tropical"
        );
        Files.write(Paths.get(FILE_NAME), lines);

        Task94_OPENAI_gpt_4o.main(new String[]{FILE_NAME});
        String result = output.toString().trim();

        String expected = String.join(System.lineSeparator(),
                "apple = fruit",
                "mango = tropical",
                "zebra = zoo"
        );

        assertEquals(expected, result);
    }

    @Test
    void testFileNotFoundIsHandled() {
        try {
            Files.deleteIfExists(Paths.get(FILE_NAME));
        } catch (IOException ignored) {}

        assertDoesNotThrow(() -> Task94_OPENAI_gpt_4o.main(new String[]{FILE_NAME}));
    }

    @Test
    void testEmptyFileProducesNoOutput() throws IOException {
        Files.write(Paths.get(FILE_NAME), Collections.emptyList());

        Task94_OPENAI_gpt_4o.main(new String[]{FILE_NAME});
        String result = output.toString().trim();

        assertEquals("", result);
    }
}
