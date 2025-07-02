package llama3.task126;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task126Test {

    @Test
    public void testGoogleInput() {
        String output = runMainWithInput("google\n");
        assertFalse(output.contains("Invalid input"));
    }

    @Test
    public void testFacebookInput() {
        String output = runMainWithInput("facebook\n");
        assertFalse(output.contains("Invalid input"));
    }

    @Test
    public void testYouTubeInput() {
        String output = runMainWithInput("youtube\n");
        assertFalse(output.contains("Invalid input"));
    }

    @Test
    public void testInvalidInput() {
        String output = runMainWithInput("twitter\n");
        assertTrue(output.contains("Invalid input. Please try again."));
    }

    @Test
    public void testEmptyInput() {
        String output = runMainWithInput("\n");
        assertTrue(output.contains("Invalid input. Please try again."));
    }

    private String runMainWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            Task126_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[0]);
        } catch (Exception ignored) {
            // ignore Desktop errors
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString();
    }
}
