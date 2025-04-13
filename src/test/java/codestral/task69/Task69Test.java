package codestral.task69;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task69Test {

    private static final String JAVA_COMMAND = "java";
    private static final String CLASS_NAME = "codestral.task69.Task69_MISTRAL_codestral_latest";

    private String runMainWithArg(String... args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(buildCommand(args));
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

    private String[] buildCommand(String... args) {
        String[] base = {JAVA_COMMAND, "-cp", System.getProperty("java.class.path"), CLASS_NAME};
        if (args.length == 0) return base;
        String[] full = new String[base.length + args.length];
        System.arraycopy(base, 0, full, 0, base.length);
        System.arraycopy(args, 0, full, base.length, args.length);
        return full;
    }

    @Test
    void testDeleteExistingFile() throws Exception {
        File temp = File.createTempFile("toDelete", ".tmp");
        assertTrue(temp.exists());

        String output = runMainWithArg(temp.getAbsolutePath());

        assertTrue(output.contains("has been deleted"), output);
        assertFalse(temp.exists());
    }

    @Test
    void testDeleteNonExistingFile() throws Exception {
        String fakePath = "nonexistent_" + System.currentTimeMillis() + ".txt";
        String output = runMainWithArg(fakePath);

        assertTrue(output.contains("does not exist"), output);
    }

    @Test
    void testDeleteDirectory() throws Exception {
        File dir = new File(System.getProperty("java.io.tmpdir"), "dir_" + System.nanoTime());
        dir.mkdir();

        String output = runMainWithArg(dir.getAbsolutePath());

        if (output.contains("has been deleted")) {
            assertFalse(dir.exists(), "Directory should be deleted.");
        } else {
            assertTrue(output.contains("Failed to delete"), output);
            dir.delete(); // cleanup
        }
    }

    @Test
    void testMissingArgument() throws Exception {
        String output = runMainWithArg(); // No argument
        assertTrue(output.contains("provide the file path"), output);
    }
}
