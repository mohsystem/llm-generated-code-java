package llama3.task157;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task157Test {

    @Test
    public void testMemoryAllocationOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            Task157_PERPLEXITY_llama_3_sonar_large_32k_chat.main(null);
        } catch (Exception e) {
            fail("Program threw an exception: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }

        String result = output.toString().trim();
        assertEquals("10", result);
    }
}
