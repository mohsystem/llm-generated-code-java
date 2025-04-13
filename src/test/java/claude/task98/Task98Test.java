package claude.task98;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task98Test {

    private String runMainWithInput(String input) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();

        System.setIn(testIn);
        System.setOut(new PrintStream(testOut));

        Task98_CLAUDE_claude_3_5_sonnet_20240620.main(null);

        System.setIn(originalIn);
        System.setOut(originalOut);

        return testOut.toString().trim(); // remove trailing newlines
    }

    @Test
    public void testValidIntegerInput() throws Exception {
        String output = runMainWithInput("42\n");
        assertEquals("Enter a number: Successfully converted to integer: 42", output);
    }

    @Test
    public void testNegativeIntegerInput() throws Exception {
        String output = runMainWithInput("-123\n");
        assertEquals("Enter a number: Successfully converted to integer: -123", output);
    }

    @Test
    public void testInvalidInput() throws Exception {
        String output = runMainWithInput("abc\n");
        assertEquals("Enter a number: Invalid input. Please enter a valid integer.", output);
    }

    @Test
    public void testEmptyInput() throws Exception {
        String output = runMainWithInput("\n");
        assertEquals("Enter a number: Invalid input. Please enter a valid integer.", output);
    }
}
