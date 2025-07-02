package gtp4o.task114;

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
        Task114_OPENAI_gpt_4o.main(new String[]{});
        String output = outContent.toString().trim();

        String expected = String.join(System.lineSeparator(),
                "Java copied string: Hello, Java!",
                "Java concatenated string: Hello, Java! How are you?"
        ).trim();

        assertEquals(expected, output);
    }
}
