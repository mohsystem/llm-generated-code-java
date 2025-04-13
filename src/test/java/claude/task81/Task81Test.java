package claude.task81;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task81Test {
    @Test
    public void testCertificateHashIsNotEmpty() {
        String hostname = "www.example.com";
        try {
            String hash = Task81_CLAUDE_claude_3_5_sonnet_20240620.getCertificateHash(hostname, 443);
            assertNotNull(hash, "Hash should not be null");
            assertFalse(hash.isEmpty(), "Hash should not be empty");
            System.out.println("✔ SSL Certificate hash: " + hash);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }


    @Test
    public void testInvalidHostname() {
        String invalidHost = "invalid.hostname.local";
        assertThrows(Exception.class, () -> {
            Task81_CLAUDE_claude_3_5_sonnet_20240620.getCertificateHash(invalidHost, 443);
        }, "Expected an exception for invalid hostname, but none was thrown.");
    }
}
