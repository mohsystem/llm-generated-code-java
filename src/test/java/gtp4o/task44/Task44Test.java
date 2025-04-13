package gtp4o.task44;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task44Test {

    private String runMainWithInput(String input) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();

        System.setIn(testIn);
        System.setOut(new PrintStream(testOut));

        Task44_OPENAI_gpt_4o.main(new String[]{});

        System.setIn(originalIn);
        System.setOut(originalOut);

        return testOut.toString();
    }

    @Test
    void testValidNumber() throws Exception {
        String output = runMainWithInput("7\n");
        assertTrue(output.contains("You entered: 7"));
        assertTrue(output.contains("Square of the number: 49"));
    }

    @Test
    void testZero() throws Exception {
        String output = runMainWithInput("0\n");
        assertTrue(output.contains("You entered: 0"));
        assertTrue(output.contains("Square of the number: 0"));
    }

    @Test
    void testNegativeNumber() throws Exception {
        String output = runMainWithInput("-4\n");
        assertTrue(output.contains("You entered: -4"));
        assertTrue(output.contains("Square of the number: 16"));
    }

    @Test
    void testInvalidThenValidInput() throws Exception {
        String output = runMainWithInput("abc\n10\n");
        assertTrue(output.contains("Invalid input. Please enter a number."));
        assertTrue(output.contains("You entered: 10"));
        assertTrue(output.contains("Square of the number: 100"));
    }

    @Test
    void testMultipleInvalidThenValidInput() throws Exception {
        String output = runMainWithInput("xyz\n-1.5\nhello\n5\n");
        assertTrue(output.contains("Invalid input. Please enter a number."));
        assertTrue(output.contains("You entered: 5"));
        assertTrue(output.contains("Square of the number: 25"));
    }
}
