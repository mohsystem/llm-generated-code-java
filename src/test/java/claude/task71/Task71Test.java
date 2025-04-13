package claude.task71;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task71Test {

    private static final String JAVA_COMMAND = "java";
    private static final String CLASS_NAME = "claude.task71.Task71_CLAUDE_claude_3_5_sonnet_20240620";

    private String runMainWithArg(String... args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(buildCommand(args));
        builder.redirectErrorStream(true); // Combine stderr and stdout
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
        String[] full = new String[base.length + args.length];
        System.arraycopy(base, 0, full, 0, base.length);
        System.arraycopy(args, 0, full, base.length, args.length);
        return full;
    }

    @Test
    void testValidIntegerInput() throws Exception {
        String output = runMainWithArg("123");
        assertEquals("Converted integer: 123", output);
    }

    @Test
    void testNegativeIntegerInput() throws Exception {
        String output = runMainWithArg("-456");
        assertEquals("Converted integer: -456", output);
    }

    @Test
    void testInvalidInputString() throws Exception {
        String output = runMainWithArg("abc");
        assertEquals("Invalid input: Cannot convert to integer", output);
    }

    @Test
    void testFloatInput() throws Exception {
        String output = runMainWithArg("12.34");
        assertEquals("Invalid input: Cannot convert to integer", output);
    }

    @Test
    void testEmptyInput() throws Exception {
        String output = runMainWithArg();
        assertTrue(output.contains("Usage:"), output);
    }
}
