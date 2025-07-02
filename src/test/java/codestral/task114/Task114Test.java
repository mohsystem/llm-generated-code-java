package codestral.task114;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

class Task114Test {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testStringOperationsOutput() {
        Task114_MISTRAL_codestral_latest.main(new String[]{});
        String output = outContent.toString().trim();

        String expected = String.join(System.lineSeparator(),
                "Copied string: Hello, ",
                "Concatenated string: Hello, World!",
                "Manipulated string: Hello, Java!"
        ).trim();

        assertEquals(expected, output);
    }
}
