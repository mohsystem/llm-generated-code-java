package gemini.task98;

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

        Task98_GEMINI_gemini_1_5_pro_001.main(null);

        System.setIn(originalIn);
        System.setOut(originalOut);

        return testOut.toString().trim();
    }

    @Test
    public void testValidIntegerInput() throws Exception {
        String output = runMainWithInput("100\n");
        assertEquals("Enter an integer: Successfully converted to integer: 100", output);
    }

    @Test
    public void testNegativeIntegerInput() throws Exception {
        String output = runMainWithInput("-45\n");
        assertEquals("Enter an integer: Successfully converted to integer: -45", output);
    }

    @Test
    public void testInvalidInput() throws Exception {
        String output = runMainWithInput("abc\n");
        assertEquals("Enter an integer: Invalid input. Please enter a valid integer.", output);
    }

    @Test
    public void testEmptyInput() throws Exception {
        String output = runMainWithInput("\n");
        assertEquals("Enter an integer: Invalid input. Please enter a valid integer.", output);
    }
}
