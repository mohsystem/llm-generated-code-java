package llama3.task66;

import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

public class Task66Test {

    @Test
    public void testEchoCommand() {
        String cmd = "echo LlamaTest";
        assertTrue(Task66_PERPLEXITY_llama_3_sonar_large_32k_chat.validateCommand(cmd));

        String output = Task66_PERPLEXITY_llama_3_sonar_large_32k_chat.executeCommand(cmd);
        assertTrue(output.contains("LlamaTest"));
    }

    @Test
    public void testUnknownCommand() {
        String cmd = "notarealcommand_xyz";
        assertTrue(Task66_PERPLEXITY_llama_3_sonar_large_32k_chat.validateCommand(cmd));

        String output = Task66_PERPLEXITY_llama_3_sonar_large_32k_chat.executeCommand(cmd);
         assertTrue(output.isEmpty() || output.toLowerCase().contains("error"));
    }

    @Test
    public void testEmptyCommand() {
        String cmd = "";
        assertTrue(Task66_PERPLEXITY_llama_3_sonar_large_32k_chat.validateCommand(cmd));

        String output = Task66_PERPLEXITY_llama_3_sonar_large_32k_chat.executeCommand(cmd);
        assertTrue(output.trim().isEmpty() || output.toLowerCase().contains("error"));
    }
}
