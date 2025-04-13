package llama3.task71;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task71Test {

    private static final String JAVA_COMMAND = "java";
    private static final String CLASS_NAME = "llama3.task71.Task71_PERPLEXITY_llama_3_sonar_large_32k_chat";

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
    void testValidInteger() throws Exception {
        String output = runMainWithArg("77");
        assertEquals("The integer value is: 77", output);
    }

    @Test
    void testNegativeInteger() throws Exception {
        String output = runMainWithArg("-123");
        assertEquals("The integer value is: -123", output);
    }

    @Test
    void testInvalidInput() throws Exception {
        String output = runMainWithArg("hello");
        assertEquals("Invalid input. Please enter a valid integer.", output);
    }

    @Test
    void testFloatInput() throws Exception {
        String output = runMainWithArg("7.5");
        assertEquals("Invalid input. Please enter a valid integer.", output);
    }

    @Test
    void testMissingArgument() throws Exception {
        String output = runMainWithArg();
        assertEquals("No input provided. Please provide a command line argument.", output);
    }
}
