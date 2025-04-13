package gemini.task83;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Base64;
import static org.junit.jupiter.api.Assertions.*;

public class Task83Test {

    private String runMainAndCaptureOutput() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            Task83_GEMINI_gemini_1_5_pro_001.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    public void testMainOutputNotEmpty() throws Exception {
        String output = runMainAndCaptureOutput();
        assertNotNull(output, "Output should not be null");
        assertFalse(output.isEmpty(), "Output should not be empty");
    }

    @Test
    public void testMainOutputIsValidBase64() throws Exception {
        String output = runMainAndCaptureOutput();
         assertDoesNotThrow(() -> Base64.getDecoder().decode(output), "Output should be valid Base64 encoding");
    }

    @Test
    public void testMainProducesDifferentOutputs() throws Exception {
        String output1 = runMainAndCaptureOutput();
        String output2 = runMainAndCaptureOutput();
         assertNotEquals(output1, output2, "Multiple executions should produce different ciphertexts");
    }
}
