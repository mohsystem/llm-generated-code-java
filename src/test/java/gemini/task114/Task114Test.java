package gemini.task114;

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
        Task114_GEMINI_gemini_1_5_pro_001.main(new String[]{});
        String output = outContent.toString().trim();

        String expected = String.join(System.lineSeparator(),
                "Concatenated String: Hello World",
                "Copied String: Hello",
                "Length of Concatenated String: 11",
                "Uppercase String: HELLO WORLD",
                "Lowercase String: hello world",
                "Substring: Hello"
        ).trim();

        assertEquals(expected, output);
    }
}
