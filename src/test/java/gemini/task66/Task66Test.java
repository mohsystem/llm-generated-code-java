package gemini.task66;

import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

public class Task66Test {

    @Test
    public void testValidEchoCommand() {
        String cmd = "echo HelloGemini";
        String output = runBashCommand(cmd);
        assertTrue(output.contains("HelloGemini"));
    }

    @Test
    public void testUnknownCommandShouldOutputError() {
        String cmd = "thisisnotarealcommand";
        String errorOutput = runBashCommandWithError(cmd);
        assertTrue(errorOutput.toLowerCase().contains("not found") || errorOutput.toLowerCase().contains("command"));
    }

    @Test
    public void testEmptyCommandReturnsNothing() {
        String cmd = "";
        String output = runBashCommand(cmd);
        assertEquals("", output.trim());
    }

    // === Helper Methods ===

    private String runBashCommand(String command) {
        StringBuilder result = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            process.waitFor();
        } catch (Exception e) {
            return "Error executing command: " + e.getMessage();
        }
        return result.toString().trim();
    }

    private String runBashCommandWithError(String command) {
        StringBuilder errorResult = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = error.readLine()) != null) {
                errorResult.append(line).append("\n");
            }
            process.waitFor();
        } catch (Exception e) {
            return "Error executing command: " + e.getMessage();
        }
        return errorResult.toString().trim();
    }
}
