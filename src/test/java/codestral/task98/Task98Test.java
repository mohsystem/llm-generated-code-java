package codestral.task98;

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

        Task98_MISTRAL_codestral_latest.main(null);

        System.setIn(originalIn);
        System.setOut(originalOut);

        return testOut.toString().trim(); // remove trailing newlines
    }

    @Test
    public void testValidIntegerInput() throws Exception {
        String output = runMainWithInput("42\n");
        assertEquals("Enter a number: You entered: 42", output);
    }

    @Test
    public void testNegativeIntegerInput() throws Exception {
        String output = runMainWithInput("-99\n");
        assertEquals("Enter a number: You entered: -99", output);
    }

    @Test
    public void testInvalidInput() throws Exception {
        String output = runMainWithInput("hello\n");
        assertEquals("Enter a number: Invalid input. Please enter an integer.", output);
    }

    @Test
    public void testEmptyInput() throws Exception {
        String output = runMainWithInput("\n");
        assertEquals("Enter a number: Invalid input. Please enter an integer.", output);
    }
}
