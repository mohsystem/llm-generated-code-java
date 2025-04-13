package claude.task95;

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
    void restore() {
        System.setOut(originalOut);
    }

    @Test
    void testProcessorTimeOutputIsSmallPositiveNumber() {
        Task95_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
        String printed = output.toString().trim();

        try {
            double seconds = Double.parseDouble(printed);
            assertTrue(seconds >= 0.0 && seconds < 0.01,
                    "Expected small processor time, got: " + seconds);
        } catch (NumberFormatException e) {
            fail("Output is not a valid number: " + printed);
        }
    }
}
