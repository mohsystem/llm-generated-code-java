package gemini.task157;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class Task157Test {

    @Test
    public void testDynamicAllocationWithInput() {
        // Prepare simulated input: user enters 10
        String simulatedInput = "10\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();

        System.setIn(testIn);
        System.setOut(new PrintStream(testOut));

        // Run the main method
        try {
            Task157_GEMINI_gemini_1_5_pro_001.main(null);
        } catch (Exception e) {
            fail("Program threw an exception: " + e.getMessage());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // Validate output
        String output = testOut.toString().trim();
        assertTrue(output.startsWith("Enter the size of the array"), "Expected prompt not found in output.");
    }
}
