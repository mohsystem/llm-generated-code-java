package gtp4o.task157;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task157Test {

    @Test
    public void testMemoryAllocationOutput() {
        // Capture System.out
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        // Run the main method
        try {
            MemoryAllocation.main(null);
        } catch (Exception e) {
            fail("Program threw an exception: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }

        // Check output
        String result = output.toString().trim();
        assertEquals("Value at allocated memory: 10", result);
    }
}
