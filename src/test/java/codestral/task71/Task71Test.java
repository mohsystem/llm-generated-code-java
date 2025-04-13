package codestral.task71;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task71Test {

    private static final String JAVA_COMMAND = "java";
    private static final String CLASS_NAME = "codestral.task71.Task71_MISTRAL_codestral_latest";

    private String runMainWithArg(String... args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(buildCommand(args));
        builder.redirectErrorStream(true); // combine stdout + stderr
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
        String output = runMainWithArg("42");
        assertEquals("42", output);
    }

    @Test
    void testNegativeIntegerInput() throws Exception {
        String output = runMainWithArg("-100");
        assertEquals("-100", output);
    }

    @Test
    void testInvalidStringInput() throws Exception {
        String output = runMainWithArg("abc");
        assertEquals("Invalid input. Please enter an integer.", output);
    }

    @Test
    void testFloatInput() throws Exception {
        String output = runMainWithArg("3.14");
        assertEquals("Invalid input. Please enter an integer.", output);
    }

    @Test
    void testMissingArgument() throws Exception {
        String output = runMainWithArg(); // no args
        assertTrue(
                output.contains("Exception") || output.contains("ArrayIndexOutOfBounds"),
                "Expected an exception message due to missing arguments, got:\n" + output
        );
    }
}
