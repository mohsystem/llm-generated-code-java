package claude.task157;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task157Test {

    @Test
    public void testMemoryAllocationAndUsage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(output));

        Task157_CLAUDE_claude_3_5_sonnet_20240620.main(null);

        System.setOut(original);
        String result = output.toString().trim();
        assertEquals("5", result);
    }
}
