package gtp4o.task78;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class Task78Test {

    @Test
    public void testPEMFormatPrivateKey() throws Exception {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Run the target class
        Task78_OPENAI_gpt_4o.main(new String[]{});

        // Restore original System.out
        System.setOut(System.out);

        String output = out.toString().trim();

        // Check BEGIN/END headers
        assertTrue(output.startsWith("-----BEGIN PRIVATE KEY-----"),
                "Output should start with 'BEGIN PRIVATE KEY'");
        assertTrue(output.endsWith("-----END PRIVATE KEY-----"),
                "Output should end with 'END PRIVATE KEY'");

        // Extract base64 content
        String base64Content = output
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");

        // Validate Base64 content
        byte[] decoded = assertDoesNotThrow(() -> Base64.getDecoder().decode(base64Content),
                "Base64 decoding should not throw exception");

        assertTrue(decoded.length >= 1000,
                "Decoded key length should be at least 1000 bytes for a 2048-bit RSA key");
    }
}
