package claude.task78;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Base64;
import static org.junit.jupiter.api.Assertions.*;

public class Task78Test {

    @Test
    public void testOpenSSHKeyFormat() throws Exception {
        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the main method
        Task78_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});

        // Restore System.out
        System.setOut(System.out);

        String output = outContent.toString().trim();

        // Check headers
        assertTrue(output.startsWith("-----BEGIN OPENSSH PRIVATE KEY-----"),
                "Output should start with BEGIN header");

        assertTrue(output.endsWith("-----END OPENSSH PRIVATE KEY-----"),
                "Output should end with END header");

        // Extract Base64 body
        String body = output
                .replace("-----BEGIN OPENSSH PRIVATE KEY-----", "")
                .replace("-----END OPENSSH PRIVATE KEY-----", "")
                .replaceAll("\\\\n", "")  // remove escaped newlines
                .replaceAll("\\s+", "");  // remove actual whitespace/newlines

        // Validate base64
        assertDoesNotThrow(() -> Base64.getDecoder().decode(body),
                "Body must be valid Base64");

        byte[] decoded = Base64.getDecoder().decode(body);
        assertTrue(decoded.length >= 1000,
                "Decoded key length must be at least 1000 bytes for 2048-bit RSA");
    }
}
