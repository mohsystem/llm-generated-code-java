package codestral.task126;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task126Test {

    @Test
    public void testRedirectHome() {
        String output = runMainWithInput("home\n");
        assertTrue(output.contains("Redirecting to home page..."));
    }

    @Test
    public void testRedirectAbout() {
        String output = runMainWithInput("about\n");
        assertTrue(output.contains("Redirecting to about page..."));
    }

    @Test
    public void testRedirectContact() {
        String output = runMainWithInput("contact\n");
        assertTrue(output.contains("Redirecting to contact page..."));
    }

    @Test
    public void testInvalidRedirect() {
        String output = runMainWithInput("faq\n");
        assertTrue(output.contains("Invalid input. Redirecting to default page..."));
    }

    @Test
    public void testEmptyInput() {
        String output = runMainWithInput("\n");
        assertTrue(output.contains("Invalid input. Redirecting to default page..."));
    }

    private String runMainWithInput(String inputData) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            Task126_MISTRAL_codestral_latest.main(new String[]{});
        } catch (Exception ignored) {
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString();
    }
}
