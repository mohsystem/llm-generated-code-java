package gemini.task125;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task125Test {

    @Test
    public void testAdminRole() {
        String output = runMainWithInput("admin\n");
        assertTrue(output.contains("Available resources for admin:"));
        assertTrue(output.contains("resource1"));
        assertTrue(output.contains("resource2"));
        assertTrue(output.contains("resource3"));
    }

    @Test
    public void testEditorRole() {
        String output = runMainWithInput("editor\n");
        assertTrue(output.contains("Available resources for editor:"));
        assertFalse(output.contains("resource1"));
        assertTrue(output.contains("resource2"));
        assertTrue(output.contains("resource3"));
    }

    @Test
    public void testViewerRole() {
        String output = runMainWithInput("viewer\n");
        assertTrue(output.contains("Available resources for viewer:"));
        assertFalse(output.contains("resource1"));
        assertFalse(output.contains("resource2"));
        assertTrue(output.contains("resource3"));
    }

    @Test
    public void testInvalidRole() {
        String output = runMainWithInput("guest\n");
        assertTrue(output.contains("Invalid role."));
    }

    @Test
    public void testEmptyRole() {
        String output = runMainWithInput("\n");
        assertTrue(output.contains("Invalid role."));
    }

    private String runMainWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            Task125_GEMINI_gemini_1_5_pro_001.main(new String[0]);
        } catch (Exception ignored) {
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString();
    }
}
