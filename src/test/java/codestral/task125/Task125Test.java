package codestral.task125;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task125Test {

    @Test
    public void testValidKeyA() {
        String output = runMainWithInput("A\n");
        assertTrue(output.contains("Access granted to: Resource A"));
    }

    @Test
    public void testValidKeyB() {
        String output = runMainWithInput("B\n");
        assertTrue(output.contains("Access granted to: Resource B"));
    }

    @Test
    public void testValidKeyC() {
        String output = runMainWithInput("C\n");
        assertTrue(output.contains("Access granted to: Resource C"));
    }

    @Test
    public void testInvalidKey() {
        String output = runMainWithInput("X\n");
        assertTrue(output.contains("Access denied. Invalid key."));
    }

    @Test
    public void testEmptyKey() {
        String output = runMainWithInput("\n");
        assertTrue(output.contains("Access denied. Invalid key."));
    }

    private String runMainWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            Task125_MISTRAL_codestral_latest.main(new String[0]);
        } catch (Exception ignored) {
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString();
    }
}
