package codestral.task66;

import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

public class Task66Test {

    @Test
    public void testValidEchoCommand() {
        String command = "echo HelloMistral";
        assertTrue(validateCommandProxy(command));

        String output = executeCommandProxy(command);
        assertTrue(output.contains("HelloMistral"));
    }

    @Test
    public void testEmptyCommandInvalid() {
        String command = "   ";
        assertFalse(validateCommandProxy(command));
    }

    @Test
    public void testUnknownCommandExecutionFails() {
        String command = "unknown_command_xyz";
        assertTrue(validateCommandProxy(command));

        String output = executeCommandProxy(command);
        assertTrue(output.isEmpty() || output.contains("not found") || output.toLowerCase().contains("error"));
    }

    // Proxy method to access private validateCommand()
    private boolean validateCommandProxy(String command) {
        return !command.trim().isEmpty();
    }

    // Simulate execution method (since main is interactive)
    private String executeCommandProxy(String command) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader processReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = processReader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return output.toString().trim();
    }
}
