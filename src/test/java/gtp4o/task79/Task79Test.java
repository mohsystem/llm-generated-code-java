package gtp4o.task79;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task79Test {

    private final String key1 = "thisisasecretkey";  // ✅ 16 characters = valid AES key
    private final String key2 = "anothersecretkey";  // ✅ 16 characters = valid AES key

    @Test
    public void testEncryptionWorks() throws Exception {
        String message = "HELLO WORLD";
        String encrypted = Task79_OPENAI_gpt_4o.encrypt(message, key1);

        assertNotNull(encrypted, "Encrypted message should not be null");
        assertNotEquals(message, encrypted, "Encrypted message should differ from original message");
    }

    @Test
    public void testSameMessageSameKeyProducesSameResult() throws Exception {
        String message = "SECURE MESSAGE";
        String encrypted1 = Task79_OPENAI_gpt_4o.encrypt(message, key1);
        String encrypted2 = Task79_OPENAI_gpt_4o.encrypt(message, key1);

        assertEquals(encrypted1, encrypted2, "Same message and key must produce same encryption result");
    }

    @Test
    public void testSameMessageDifferentKeysProduceDifferentResult() throws Exception {
        String message = "SECURE MESSAGE";
        String encrypted1 = Task79_OPENAI_gpt_4o.encrypt(message, key1);
        String encrypted2 = Task79_OPENAI_gpt_4o.encrypt(message, key2);

        assertNotEquals(encrypted1, encrypted2, "Different keys must produce different encryption results");
    }

    @Test
    public void testEmptyMessageEncryption() throws Exception {
        String encrypted = Task79_OPENAI_gpt_4o.encrypt("", key1);
        assertNotNull(encrypted);
        assertFalse(encrypted.isEmpty(), "AES with padding should still produce output for empty message");
    }

    @Test
    public void testThrowsWithInvalidKeyLength() {
        Exception exception = assertThrows(Exception.class, () -> {
            Task79_OPENAI_gpt_4o.encrypt("Test", "shortkey"); // ❌ Invalid (less than 16 bytes)
        });

        String msg = exception.getMessage().toLowerCase();
        assertTrue(msg.contains("invalid") || msg.contains("length"), "Should throw error for invalid key length");
    }
}
