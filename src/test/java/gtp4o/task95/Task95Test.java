package gtp4o.task95;

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
        Task95_OPENAI_gpt_4o.main(new String[]{});
        String printed = output.toString().trim();

        assertTrue(printed.startsWith("Java: "), "Output should start with 'Java: '");

        String valuePart = printed.replace("Java: ", "").trim();
        try {
            double seconds = Double.parseDouble(valuePart);
            assertTrue(seconds >= 0.0 && seconds < 0.01, "Processor time should be a small positive double");
        } catch (NumberFormatException e) {
            fail("Value part is not a valid double: " + valuePart);
        }
    }
}
