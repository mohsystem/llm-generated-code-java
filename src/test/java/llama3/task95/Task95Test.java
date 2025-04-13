package llama3.task95;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task95Test {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setup() {
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void teardown() {
        System.setOut(originalOut);
    }

    @Test
    void testCurrentProcessorTimeOutputFormat() {
        Task95_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        String printed = output.toString().trim();

        assertTrue(printed.startsWith("Current processor time in seconds: "),
                "Output should start with 'Current processor time in seconds: '");

        String value = printed.replace("Current processor time in seconds: ", "").trim();

        try {
            double seconds = Double.parseDouble(value);
            assertTrue(seconds > 0, "Processor time should be positive");
        } catch (NumberFormatException e) {
            fail("Output is not a valid double: " + value);
        }
    }
}
