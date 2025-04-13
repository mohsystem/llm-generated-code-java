package gemini.task69;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task69Test {

    private static final String JAVA_COMMAND = "java";
    private static final String CLASS_NAME = "gemini.task69.Task69_GEMINI_gemini_1_5_pro_001";

    private String runMainWithArg(String... args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(buildCommand(args));
        builder.redirectErrorStream(true); // نجمع stdout و stderr
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

        assertTrue(output.contains("deleted successfully."), output);
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

        if (output.contains("deleted successfully.")) {
            assertFalse(dir.exists(), "Directory should be deleted.");
        } else {
            assertTrue(output.contains("Error deleting file"), output);
            dir.delete(); // cleanup
        }
    }

    @Test
    void testMissingArgument() throws Exception {
        String output = runMainWithArg(); // No argument
        assertTrue(output.contains("Usage:"), output);
    }
}
