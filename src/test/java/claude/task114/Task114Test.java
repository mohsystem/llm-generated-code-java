package claude.task114;

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
        Task114_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
        String output = outContent.toString().trim();

        String expected = String.join(System.lineSeparator(),
                "Original: Hello, World!",
                "Copied: Hello, World!",
                "Concatenated: Java is awesome!",
                "Stripped: 'Java Programming'",
                "Uppercase:    JAVA PROGRAMMING   ",
                "Lowercase:    java programming   ",
                "Replaced:    Python Programming   "
        ).trim();

        assertEquals(expected, output);
    }
}
