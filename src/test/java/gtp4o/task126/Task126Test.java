package gtp4o.task126;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task126Test {

    @Test
    public void testHomeRedirect() {
        String output = runMainWithInput("home\n");
        assertTrue(output.contains("Redirect to Home Page"));
    }

    @Test
    public void testAboutRedirect() {
        String output = runMainWithInput("about\n");
        assertTrue(output.contains("Redirect to About Page"));
    }

    @Test
    public void testContactRedirect() {
        String output = runMainWithInput("contact\n");
        assertTrue(output.contains("Redirect to Contact Page"));
    }

    @Test
    public void testInvalidRedirect() {
        String output = runMainWithInput("faq\n");
        assertTrue(output.contains("Page not found"));
    }

    @Test
    public void testEmptyInput() {
        String output = runMainWithInput("\n");
        assertTrue(output.contains("Page not found"));
    }

    private String runMainWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            Task126_OPENAI_gpt_4o.main(new String[0]);
        } catch (Exception ignored) {
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString();
    }
}
