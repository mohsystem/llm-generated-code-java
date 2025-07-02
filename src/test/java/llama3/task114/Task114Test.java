package llama3.task114;

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
        Task114_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        String output = outContent.toString().trim();

        String expected =
                "Original Strings:\n" +
                        "s1: Hello\n" +
                        "s2: World\n" +
                        "\n" +
                        "Copied String:\n" +
                        "s3: Hello\n" +
                        "\n" +
                        "Concatenated String:\n" +
                        "s4: Hello World\n" +
                        "\n" +
                        "Upper Case String:\n" +
                        "s5: HELLO\n" +
                        "\n" +
                        "Lower Case String:\n" +
                        "s6: world";

        // Important: replace to system-specific line separator
        expected = expected.replace("\n", System.lineSeparator());

        assertEquals(expected, output);
    }
}
