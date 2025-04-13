package claude.task45;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

 class Task45Test {

     private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

     private InputStream originalIn;

     @BeforeEach
    public void setUpStreams() {
        originalIn = System.in;
        System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    }

     @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }


    @Test
    void testDivideNumbersValid() {
         assertEquals(5.0, Task45_CLAUDE_claude_3_5_sonnet_20240620.divideNumbers(10, 2), 0.001);
        assertEquals(-5.0, Task45_CLAUDE_claude_3_5_sonnet_20240620.divideNumbers(-10, 2), 0.001);
        assertEquals(0.0, Task45_CLAUDE_claude_3_5_sonnet_20240620.divideNumbers(0, 1), 0.001);
    }

    @Test
    void testDivideNumbersZeroDivisionJavaBehavior() {
         assertEquals(Double.POSITIVE_INFINITY, Task45_CLAUDE_claude_3_5_sonnet_20240620.divideNumbers(10, 0));
        assertEquals(Double.NEGATIVE_INFINITY, Task45_CLAUDE_claude_3_5_sonnet_20240620.divideNumbers(-10, 0));
        assertTrue(Double.isNaN(Task45_CLAUDE_claude_3_5_sonnet_20240620.divideNumbers(0, 0)));
    }



     private String runMainWithInput(String... inputs) {
        String simulatedInput = String.join(System.lineSeparator(), inputs) + System.lineSeparator();
        InputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);

        try {
            Task45_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
        } catch (Exception e) {
             fail("Exception occurred during main execution: " + e.getMessage());
        } finally {
             System.setIn(originalIn);
        }

        return outContent.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
    }

    @Test
    void testMainValidInput() {
        String output = runMainWithInput("10", "2");
        String expectedResult = "Result: 5.0";
        String expectedCompletion = "Program execution completed.";
         assertTrue(output.contains(expectedResult), "Output should contain: " + expectedResult);
        assertTrue(output.contains(expectedCompletion), "Output should contain: " + expectedCompletion);
    }

    @Test
    void testMainZeroDivision() {
        String output = runMainWithInput("10", "0");
        String expectedError = "Error: Cannot divide by zero.";
        String expectedCompletion = "Program execution completed.";
          assertTrue(output.contains(expectedError), "Output should contain the specific error message for zero division (as per Python test): " + expectedError);
        assertTrue(output.contains(expectedCompletion), "Output should contain: " + expectedCompletion);
    }

    @Test
    void testMainInvalidInput() {
        String output = runMainWithInput("a", "2");
        String expectedError = "Error: Please enter valid numbers.";
        String expectedCompletion = "Program execution completed.";
        assertTrue(output.contains(expectedError), "Output should contain: " + expectedError);
        assertTrue(output.contains(expectedCompletion), "Output should contain: " + expectedCompletion);
    }

    @Test
    void testMainNegativeNumbers() {
        String output = runMainWithInput("-10", "2");
        String expectedResult = "Result: -5.0";
        String expectedCompletion = "Program execution completed.";
        assertTrue(output.contains(expectedResult), "Output should contain: " + expectedResult);
        assertTrue(output.contains(expectedCompletion), "Output should contain: " + expectedCompletion);
    }

    @Test
    void testMainZeroNumerator() {
        String output = runMainWithInput("0", "1");
        String expectedResult = "Result: 0.0";
        String expectedCompletion = "Program execution completed.";
        assertTrue(output.contains(expectedResult), "Output should contain: " + expectedResult);
        assertTrue(output.contains(expectedCompletion), "Output should contain: " + expectedCompletion);
    }

    @Test
    void testMainSmallNumbersZeroDivision() {
        String output = runMainWithInput("1", "0");
        String expectedError = "Error: Cannot divide by zero.";
        String expectedCompletion = "Program execution completed.";
         assertTrue(output.contains(expectedError), "Output should contain the specific error message for zero division (as per Python test): " + expectedError);
        assertTrue(output.contains(expectedCompletion), "Output should contain: " + expectedCompletion);
    }



}