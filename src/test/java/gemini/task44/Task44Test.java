package gemini.task44;

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

        Task44_GEMINI_gemini_1_5_pro_001.main(new String[]{});

        System.setIn(originalIn);
        System.setOut(originalOut);

        return testOut.toString();
    }

    @Test
    void testValidInput() throws Exception {
        String output = runMainWithInput("10\n5\n");
        assertTrue(output.contains("The sum is: 15"));
        assertTrue(output.contains("The difference is: 5"));
        assertTrue(output.contains("The product is: 50"));
    }

    @Test
    void testNegativeNumbers() throws Exception {
        String output = runMainWithInput("-7\n-3\n");
        assertTrue(output.contains("The sum is: -10"));
        assertTrue(output.contains("The difference is: -4"));
        assertTrue(output.contains("The product is: 21"));
    }

    @Test
    void testZeroInput() throws Exception {
        String output = runMainWithInput("0\n0\n");
        assertTrue(output.contains("The sum is: 0"));
        assertTrue(output.contains("The difference is: 0"));
        assertTrue(output.contains("The product is: 0"));
    }

    @Test
    void testInputWithLeadingAndTrailingSpaces() throws Exception {
        String output = runMainWithInput("   8\n  2\n");
        assertTrue(output.contains("The sum is: 10"));
        assertTrue(output.contains("The difference is: 6"));
        assertTrue(output.contains("The product is: 16"));
    }

    @Test
    void testInvalidInputSpecialCharacters() throws Exception {
        String output = runMainWithInput("abc\n2\n3\n");
        assertTrue(output.contains("Invalid input. Please enter an integer."));
        assertTrue(output.contains("The sum is: 5"));
        assertTrue(output.contains("The difference is: -1"));
        assertTrue(output.contains("The product is: 6"));
    }

    @Test
    void testInvalidInputNewlineThenValid() throws Exception {
        String output = runMainWithInput("\n\n5\n5\n");
        assertTrue(output.contains("Invalid input. Please enter an integer."));
        assertTrue(output.contains("The sum is: 10"));
        assertTrue(output.contains("The difference is: 0"));
        assertTrue(output.contains("The product is: 25"));
    }

    @Test
    void testLongInputNumbers() throws Exception {
        String big1 = "1000000";
        String big2 = "999999";
        String output = runMainWithInput(big1 + "\n" + big2 + "\n");
        assertTrue(output.contains("The sum is: 1999999"));
        assertTrue(output.contains("The difference is: 1"));
        assertTrue(output.contains("The product is: 999999000000"));
    }
}
