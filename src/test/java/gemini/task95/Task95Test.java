package gemini.task95;

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
    void testProcessorTimeIsDoubleAndSmall() {
        ProcessorTime.main(new String[]{});
        String printed = output.toString().trim();

        try {
            double seconds = Double.parseDouble(printed);
            assertTrue(seconds >= 0.0 && seconds < 0.01, "Processor time should be a small positive double");
        } catch (NumberFormatException e) {
            fail("Output is not a valid double: " + printed);
        }
    }
}
