package gtp4o.task98;

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

        Task98_OPENAI_gpt_4o.main(null);

        System.setIn(originalIn);
        System.setOut(originalOut);

        return testOut.toString().trim();
    }

    @Test
    public void testValidInput() throws Exception {
        String output = runMainWithInput("77\n");
        assertEquals("Enter a number: Converted Integer: 77", output);
    }

    @Test
    public void testNegativeInput() throws Exception {
        String output = runMainWithInput("-10\n");
        assertEquals("Enter a number: Converted Integer: -10", output);
    }

    @Test
    public void testInvalidInput() throws Exception {
        String output = runMainWithInput("abc\n");
        assertEquals("Enter a number: Error: Not a valid integer", output);
    }

    @Test
    public void testEmptyInput() throws Exception {
        String output = runMainWithInput("\n");
        assertEquals("Enter a number: Error: Not a valid integer", output);
    }
}
