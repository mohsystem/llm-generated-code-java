package gemini.task126;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task126Test {

    @Test
    public void testRedirectA() {
        String output = runMainWithInput("A\n");
        assertTrue(output.contains("Redirecting to page A..."));
    }

    @Test
    public void testRedirectB_lowercase() {
        String output = runMainWithInput("b\n");
        assertTrue(output.contains("Redirecting to page B..."));
    }

    @Test
    public void testRedirectC_mixedCase() {
        String output = runMainWithInput("c\n");
        assertTrue(output.contains("Redirecting to page C..."));
    }

    @Test
    public void testInvalidChoice() {
        String output = runMainWithInput("X\n");
        assertTrue(output.contains("Invalid choice. Please enter A, B, or C."));
    }

    @Test
    public void testEmptyInput() {
        String output = runMainWithInput("\n");
        assertTrue(output.contains("Invalid choice. Please enter A, B, or C."));
    }

    private String runMainWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            Task126_GEMINI_gemini_1_5_pro_001.main(new String[0]);
        } catch (Exception ignored) {
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString();
    }
}
