package gtp4o.task39;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task39Test {

    @Test
    public void testFileContentsDisplayed() throws IOException, InterruptedException {
        // Create a temporary test file
        String tempFileName = "testFile.txt";
        String content = "This is a test file for Task39.";
        Files.write(Paths.get(tempFileName), content.getBytes());

        // Determine the appropriate command based on the OS
        String command;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            command = "cmd.exe";
            // Use 'type' through cmd.exe on Windows
            String[] commandArray = new String[] {command, "/c", "type", tempFileName};
            ProcessBuilder processBuilder = new ProcessBuilder(commandArray);
            Process process = processBuilder.start();
            process.waitFor();

            // Capture the output of the process (the file contents)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Check if the content in the output is the same as what was in the file
            assertTrue(output.toString().contains(content), "File contents were not displayed correctly.");
        } else {
            // For UNIX-like systems, use 'cat'
            String[] commandArray = new String[] { "cat", tempFileName };
            ProcessBuilder processBuilder = new ProcessBuilder(commandArray);
            Process process = processBuilder.start();
            process.waitFor();

            // Capture the output of the process (the file contents)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Check if the content in the output is the same as what was in the file
            assertTrue(output.toString().contains(content), "File contents were not displayed correctly.");
        }

        // Clean up the temporary file after test
        Files.delete(Paths.get(tempFileName));
    }
}
