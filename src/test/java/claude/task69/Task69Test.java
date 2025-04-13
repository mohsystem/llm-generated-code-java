package claude.task69;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task69Test {

    private static final String JAVA_COMMAND = "java";
    private static final String CLASS_NAME = "claude.task69.Task69_CLAUDE_claude_3_5_sonnet_20240620";

    private String runMainWithArg(String arg) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(
                JAVA_COMMAND,
                "-cp", System.getProperty("java.class.path"),
                CLASS_NAME, arg
        );
        builder.redirectErrorStream(true);
        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        process.waitFor();
        return output.toString().trim();
    }

    @Test
    void testDeleteExistingFile() throws Exception {
        File temp = File.createTempFile("testFile", ".txt");
        String output = runMainWithArg(temp.getAbsolutePath());

        assertTrue(output.contains("has been deleted successfully."), output);
        assertFalse(temp.exists());
    }

    @Test
    void testDeleteNonExistingFile() throws Exception {
        String fakePath = "nonexistent_" + System.currentTimeMillis() + ".txt";
        String output = runMainWithArg(fakePath);

        assertTrue(output.contains("not found"), output);
    }

    @Test
    void testDeleteDirectory() throws Exception {
        File dir = new File(System.getProperty("java.io.tmpdir"), "dir_" + System.nanoTime());
        dir.mkdir();

        String output = runMainWithArg(dir.getAbsolutePath());

         if (output.contains("has been deleted successfully.")) {
            assertFalse(dir.exists(), "Directory should be deleted.");
        } else {
            assertTrue(output.contains("Unable to delete"), output);
            dir.delete(); // cleanup
        }
    }


    @Test
    void testMissingArgument() throws Exception {
        ProcessBuilder builder = new ProcessBuilder(
                JAVA_COMMAND,
                "-cp", System.getProperty("java.class.path"),
                CLASS_NAME
        );
        builder.redirectErrorStream(true);
        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        process.waitFor();

        assertTrue(output.toString().contains("Usage:"), output.toString());
    }
}
