package gtp4o.task66;

import org.junit.jupiter.api.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

public class Task66Test {

    @Test
    public void testValidCommand_echo() {
        String cmd = "echo GPT4o";
        String output = runCommand(cmd);
        assertTrue(output.contains("GPT4o"));
    }

    @Test
    public void testInvalidCommand_shouldShowError() {
        String cmd = "nonexistent_cmd_xyz";
        String output = runCommand(cmd).toLowerCase();
        assertTrue(output.contains("error") || output.contains("not found") || output.contains("command"));
    }

    @Test
    public void testEmptyCommand_returnsNothing() {
        String cmd = "";
        String output = runCommand(cmd);
        assertTrue(output.isEmpty() || output.toLowerCase().contains("error"));
    }

    // Helper function to mimic the same behavior as main()
    private String runCommand(String cmd) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(cmd);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = stdInput.readLine()) != null) {
                output.append(line).append("\n");
            }
            while ((line = stdError.readLine()) != null) {
                output.append("Error: ").append(line).append("\n");
            }

            process.waitFor();
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
        return output.toString().trim();
    }
}
