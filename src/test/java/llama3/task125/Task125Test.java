package llama3.task125;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task125Test {

    @Test
    public void testAdminAccess() {
        String output = captureOutput(() -> Task125_PERPLEXITY_llama_3_sonar_large_32k_chat.accessResource("admin"));
        assertTrue(output.contains("Access granted to admin resource"));
    }

    @Test
    public void testModeratorAccess() {
        String output = captureOutput(() -> Task125_PERPLEXITY_llama_3_sonar_large_32k_chat.accessResource("moderator"));
        assertTrue(output.contains("Access granted to moderator resource"));
    }

    @Test
    public void testUserAccess() {
        String output = captureOutput(() -> Task125_PERPLEXITY_llama_3_sonar_large_32k_chat.accessResource("user"));
        assertTrue(output.contains("Access granted to user resource"));
    }

    @Test
    public void testInvalidAccess() {
        String output = captureOutput(() -> Task125_PERPLEXITY_llama_3_sonar_large_32k_chat.accessResource("guest"));
        assertTrue(output.contains("Access denied"));
    }

    @Test
    public void testEmptyAccess() {
        String output = captureOutput(() -> Task125_PERPLEXITY_llama_3_sonar_large_32k_chat.accessResource(""));
        assertTrue(output.contains("Access denied"));
    }

    private String captureOutput(Runnable task) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            task.run();
        } finally {
            System.setOut(originalOut);
        }
        return out.toString();
    }
}
