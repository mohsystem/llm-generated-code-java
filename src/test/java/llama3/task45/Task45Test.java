package llama3.task45;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class Task45Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private InputStream originalIn;
    private Locale originalLocale;

    @BeforeEach
    public void setUpStreamsAndLocale() {
        originalIn = System.in;
        originalLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    }

    @AfterEach
    public void restoreStreamsAndLocale() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        Locale.setDefault(originalLocale);
    }

    private String runMainWithInput(String... inputs) {
        String simulatedInput = String.join(System.lineSeparator(), inputs) + System.lineSeparator();
        InputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);

        try {
            llama3.task45.Task45_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        } catch (Exception e) {
            System.err.println("Test failed due to unexpected exception during main execution: " + e);
            fail("Exception occurred during main execution: " + e.getMessage());
        } finally {
            System.setIn(originalIn);
        }

        return outContent.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
    }

    @Test
    void testMainDivisionValid() {
        String output = runMainWithInput("10", "2", "/");
        String expectedResult = "Result: 5.0";
        assertTrue(output.contains(expectedResult), "Output should contain: '" + expectedResult + "', but was: '" + output + "'");
    }

    @Test
    void testMainDivisionNegative() {
        String output = runMainWithInput("-10", "2", "/");
        String expectedResult = "Result: -5.0";
        assertTrue(output.contains(expectedResult), "Output should contain: '" + expectedResult + "', but was: '" + output + "'");
    }

    @Test
    void testMainDivisionZeroNumerator() {
        String output = runMainWithInput("0", "1", "/");
        String expectedResult = "Result: 0.0";
        assertTrue(output.contains(expectedResult), "Output should contain: '" + expectedResult + "', but was: '" + output + "'");
    }

    @Test
    void testMainDivisionByZero() {
        String output = runMainWithInput("10", "0", "/");
        String expectedError = "Error: Division by zero!";
        assertTrue(output.contains(expectedError), "Output should contain: '" + expectedError + "', but was: '" + output + "'");
        assertFalse(output.contains("Result:"), "Output should not contain 'Result:' on division by zero error");
    }

    @Test
    void testMainDivisionSmallNumberByZero() {
        String output = runMainWithInput("1", "0", "/");
        String expectedError = "Error: Division by zero!";
        assertTrue(output.contains(expectedError), "Output should contain: '" + expectedError + "', but was: '" + output + "'");
        assertFalse(output.contains("Result:"), "Output should not contain 'Result:' on division by zero error");
    }

    @Test
    void testMainInvalidNumberInput1() {
        String output = runMainWithInput("a", "2", "/");
        String expectedError = "Error: Invalid input!";
        assertTrue(output.contains(expectedError), "Output should contain: '" + expectedError + "', but was: '" + output + "'");
        assertFalse(output.contains("Result:"), "Output should not contain 'Result:' on invalid number input");
    }

    @Test
    void testMainInvalidNumberInput2() {
        String output = runMainWithInput("10", "b", "/");
        String expectedError = "Error: Invalid input!";
        assertTrue(output.contains(expectedError), "Output should contain: '" + expectedError + "', but was: '" + output + "'");
        assertFalse(output.contains("Result:"), "Output should not contain 'Result:' on invalid number input");
    }

    @Test
    void testMainInvalidOperation() {
        String output = runMainWithInput("10", "2", "x");
        String expectedError = "Error: Invalid operation!";
        assertTrue(output.contains(expectedError), "Output should contain: '" + expectedError + "', but was: '" + output + "'");
        assertFalse(output.contains("Result:"), "Output should not contain 'Result:' on invalid operation error");
    }

    @Test
    void testMainAdditionValid() {
        String output = runMainWithInput("10", "5", "+");
        String expectedResult = "Result: 15.0";
        assertTrue(output.contains(expectedResult), "Output should contain: '" + expectedResult + "', but was: '" + output + "'");
    }

    @Test
    void testMainSubtractionValid() {
        String output = runMainWithInput("10", "5", "-");
        String expectedResult = "Result: 5.0";
        assertTrue(output.contains(expectedResult), "Output should contain: '" + expectedResult + "', but was: '" + output + "'");
    }

    @Test
    void testMainMultiplicationValid() {
        String output = runMainWithInput("10", "5", "*");
        String expectedResult = "Result: 50.0";
        assertTrue(output.contains(expectedResult), "Output should contain: '" + expectedResult + "', but was: '" + output + "'");
    }

    @Test
    void testMainDecimalInputs() {
        String output = runMainWithInput("10.5", "2.0", "/");
        String expectedResult = "Result: 5.25";
        assertTrue(output.contains(expectedResult), "Output should contain: '" + expectedResult + "', but was: '" + output + "'");
    }
}