package codestral.task83;

import org.junit.jupiter.api.Test;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class Task83Test {

    @Test
    public void testEncryptKey_NotNullOrEmpty() throws Exception {
        String key = "This is a key123";
        String cipherKey = "1234567890123456";

        String encrypted = Task83_MISTRAL_codestral_latest.encryptKey(key, cipherKey);

        assertNotNull(encrypted, "Encrypted string should not be null");
        assertFalse(encrypted.isEmpty(), "Encrypted string should not be empty");
    }

    @Test
    public void testEncryptKey_Base64ValidParts() throws Exception {
        String key = "This is a key123";
        String cipherKey = "1234567890123456";

        String encrypted = Task83_MISTRAL_codestral_latest.encryptKey(key, cipherKey);

        // Split IV (16 bytes = 24 base64 chars) and ciphertext
        String ivBase64 = encrypted.substring(0, 24);
        String encryptedPartBase64 = encrypted.substring(24);

        assertDoesNotThrow(() -> Base64.getDecoder().decode(ivBase64), "IV should be valid Base64");
        assertDoesNotThrow(() -> Base64.getDecoder().decode(encryptedPartBase64), "Encrypted part should be valid Base64");
    }

    @Test
    public void testEncryptKey_DifferentIVsProduceDifferentCiphertexts() throws Exception {
        String key = "This is a key123";
        String cipherKey = "1234567890123456";

        String encrypted1 = Task83_MISTRAL_codestral_latest.encryptKey(key, cipherKey);
        String encrypted2 = Task83_MISTRAL_codestral_latest.encryptKey(key, cipherKey);

        assertNotEquals(encrypted1, encrypted2, "Different IVs should result in different ciphertexts");
    }

    @Test
    public void testEncryptKey_InvalidKeyLengthThrowsException() {
        String key = "This is a key123";
        String invalidCipherKey = "too_short_key_123";

        Exception exception = assertThrows(Exception.class, () -> {
            Task83_MISTRAL_codestral_latest.encryptKey(key, invalidCipherKey);
        });

        String message = exception.getMessage();
        assertTrue(message.contains("Invalid AES key length"), "Should throw key length error");
    }
}
