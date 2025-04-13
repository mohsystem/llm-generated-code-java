package gemini.task45;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class Task45Test {

    /** Helper: run main() with the given stdin and capture all stdout. */
    private String runMainWithInput(String input) throws IOException {
        InputStream  stdinBackup  = System.in;
        PrintStream stdoutBackup = System.out;

        ByteArrayInputStream  in  = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        // invoke your main
        Task45_GEMINI_gemini_1_5_pro_001.main(new String[]{});

        // restore originals
        System.setIn(stdinBackup);
        System.setOut(stdoutBackup);

        return out.toString();
    }

    //
    // performOperation(...) tests
    //

    @Test
    void testPerformOperationValid() {
        assertEquals( 5.0, Task45_GEMINI_gemini_1_5_pro_001.performOperation(4, 10, 2));
        assertEquals(-5.0, Task45_GEMINI_gemini_1_5_pro_001.performOperation(4, -10, 2));
        assertEquals( 0.0, Task45_GEMINI_gemini_1_5_pro_001.performOperation(4, 0, 1));
    }

    @Test
    void testPerformOperationZeroDivision() {
        assertThrows(ArithmeticException.class, () ->
                Task45_GEMINI_gemini_1_5_pro_001.performOperation(4, 10, 0)
        );
    }

    //
    // main(...) tests
    //

    @Test
    void testMainValidInput() throws IOException {
        // choose 4 (division), then 10, 2, then exit (5)
        String out = runMainWithInput("4\n10\n2\n5\n");
        assertTrue(out.contains("Result: 5.0"));
    }

    @Test
    void testMainZeroDivision() throws IOException {
        String out = runMainWithInput("4\n10\n0\n5\n");
        assertTrue(out.contains("Error: Cannot divide by zero."));
    }

    @Test
    void testMainInvalidChoiceInput() throws IOException {
        // invalid menu choice ("a"), then exit
        String out = runMainWithInput("a\n5\n");
        assertTrue(out.contains("Error: Invalid input. Please enter an integer."));
    }

    @Test
    void testMainNegativeNumbers() throws IOException {
        String out = runMainWithInput("4\n-10\n2\n5\n");
        assertTrue(out.contains("Result: -5.0"));
    }

    @Test
    void testMainZeroNumerator() throws IOException {
        String out = runMainWithInput("4\n0\n1\n5\n");
        assertTrue(out.contains("Result: 0.0"));
    }

    @Test
    void testMainValidInputMultipleTimes() throws IOException {
        for (int i = 0; i < 10; i++) {
            String out = runMainWithInput("4\n10\n2\n5\n");
            assertTrue(out.contains("Result: 5.0"), "Iteration " + i + " failed");
        }
    }

    @Test
    void testMainSmallNumbersZeroDivision() throws IOException {
        String out = runMainWithInput("4\n1\n0\n5\n");
        assertTrue(out.contains("Error: Cannot divide by zero."));
    }
}
