package codestral.task45;

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

    private String runMainWithInput(String input) {
        InputStream testInput = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);
        try {
            codestral.task45.Task45_MISTRAL_codestral_latest.main(new String[]{});
        } catch (Exception e) {
            fail("Exception occurred during main execution: " + e.getMessage());
        } finally {
            System.setIn(originalIn);
        }
        return outContent.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
    }

    @Test
    void testMainValidInputPositive() {
        String output = runMainWithInput("10\n");
        String expectedResult = "The result is: 20.0";
        assertTrue(output.contains(expectedResult), "Output should contain: " + expectedResult + ", but was: " + output);
    }

    @Test
    void testMainValidInputNegative() {
        String output = runMainWithInput("-5.5\n");
        String expectedResult = "The result is: -11.0";
        assertTrue(output.contains(expectedResult), "Output should contain: " + expectedResult + ", but was: " + output);
    }

    @Test
    void testMainValidInputZero() {
        String output = runMainWithInput("0\n");
        String expectedResult = "The result is: 0.0";
        assertTrue(output.contains(expectedResult), "Output should contain: " + expectedResult + ", but was: " + output);
    }

    @Test
    void testMainInvalidInputString() {
        String output = runMainWithInput("abc\n");
        String expectedError = "Invalid input. Please enter a number.";
        assertTrue(output.contains(expectedError), "Output should contain: " + expectedError + ", but was: " + output);
    }

    @Test
    void testMainInvalidInputEmpty() {
        String output = runMainWithInput("\n");
        String expectedError = "Invalid input. Please enter a number.";
        assertTrue(output.contains(expectedError), "Output should contain: " + expectedError + ", but was: " + output);
    }

    @Test
    void testMainValidInputDecimal() {
        String output = runMainWithInput("3.14\n");
        String expectedResult = "The result is: 6.28";
        assertTrue(output.contains(expectedResult), "Output should contain: " + expectedResult + ", but was: " + output);
    }

    @Test
    void testMainValidInputLargeNumber() {
        String output = runMainWithInput("1000000\n");
        String expectedResult = "The result is: 2000000.0";
        assertTrue(output.contains(expectedResult), "Output should contain: " + expectedResult + ", but was: " + output);
    }
}