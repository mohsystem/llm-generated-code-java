package gtp4o.task83;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class Task83Test {

    private String runMainAndCaptureOutput() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            Task83_OPENAI_gpt_4o.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testMainPrintsEncryptedByteArray() throws Exception {
        String output = runMainAndCaptureOutput();
        assertNotNull(output, "Output should not be null");
        assertTrue(output.startsWith("Encrypted Byte Array: ["), "Output should start with 'Encrypted Byte Array: ['");
        assertTrue(output.endsWith("]"), "Output should end with ']'");
    }

    @Test
    public void testEncryptedByteArrayHasValidFormat() throws Exception {
        String output = runMainAndCaptureOutput();
        String arrayData = output.replace("Encrypted Byte Array: ", "").trim();

         String regex = "\\[(\\s*-?\\d+\\s*,)*\\s*-?\\d+\\s*\\]";
        assertTrue(Pattern.matches(regex, arrayData), "Output should match array format like [12, 34, -7, ...]");
    }

    @Test
    public void testEncryptedByteArrayChangesEachRun() throws Exception {
        String out1 = runMainAndCaptureOutput();
        String out2 = runMainAndCaptureOutput();
        assertNotEquals(out1, out2, "Encrypted output should be different on each run due to random IV and key");
    }
}
