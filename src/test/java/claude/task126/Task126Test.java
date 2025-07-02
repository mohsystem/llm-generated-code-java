package claude.task126;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task126Test {

    @Test
    public void testChoice1_Google() {
        String input = "1\n";
        String output = runWithInput(input);
        assertTrue(output.contains("Select a destination:"));
        assertTrue(output.contains("Enter your choice"));
    }

    @Test
    public void testChoice2_YouTube() {
        String input = "2\n";
        String output = runWithInput(input);
        assertTrue(output.contains("Select a destination:"));
        assertTrue(output.contains("Enter your choice"));
    }

    @Test
    public void testChoice3_Wikipedia() {
        String input = "3\n";
        String output = runWithInput(input);
        assertTrue(output.contains("Select a destination:"));
        assertTrue(output.contains("Enter your choice"));
    }

    @Test
    public void testInvalidChoice() {
        String input = "0\n";
        String output = runWithInput(input);
        assertTrue(output.contains("Invalid choice. Please try again."));
    }

    private String runWithInput(String inputData) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            Task126_CLAUDE_claude_3_5_sonnet_20240620.main(new String[0]);
        } catch (Exception e) {
            // ignore any exceptions from Desktop.browse
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString();
    }
}
