package gemini.task71;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task71Test {

    private static final String JAVA_COMMAND = "java";
    private static final String CLASS_NAME = "gemini.task71.Task71_GEMINI_gemini_1_5_pro_001";

    private String runMainWithArg(String... args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(buildCommand(args));
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
        String[] full = new String[base.length + args.length];
        System.arraycopy(base, 0, full, 0, base.length);
        System.arraycopy(args, 0, full, base.length, args.length);
        return full;
    }

    @Test
    void testValidInteger() throws Exception {
        String output = runMainWithArg("123");
        assertEquals("Successfully converted '123' to integer: 123", output);
    }

    @Test
    void testNegativeInteger() throws Exception {
        String output = runMainWithArg("-42");
        assertEquals("Successfully converted '-42' to integer: -42", output);
    }

    @Test
    void testInvalidInput() throws Exception {
        String output = runMainWithArg("abc");
        assertEquals("Unable to convert 'abc' to an integer.", output);
    }

    @Test
    void testFloatInput() throws Exception {
        String output = runMainWithArg("3.14");
        assertEquals("Unable to convert '3.14' to an integer.", output);
    }

    @Test
    void testMissingArgument() throws Exception {
        String output = runMainWithArg();
        assertEquals("Please provide an argument to be converted to an integer.", output);
    }
}
