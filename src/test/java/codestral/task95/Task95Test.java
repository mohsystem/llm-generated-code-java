package codestral.task95;

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
    void testProcessorTimeOutputFormat() {
        Task95_MISTRAL_codestral_latest.main(new String[]{});
        String printed = output.toString().trim();

        assertTrue(printed.startsWith("Processor time: "), "Output should start with 'Processor time: '");
        assertTrue(printed.endsWith(" seconds"), "Output should end with ' seconds'");

        // Extract number in the middle
        String middle = printed.replace("Processor time: ", "").replace(" seconds", "").trim();
        try {
            long seconds = Long.parseLong(middle);
            assertTrue(seconds >= 0, "Processor time should be non-negative");
        } catch (NumberFormatException e) {
            fail("Middle part is not a valid integer: " + middle);
        }
    }
}
