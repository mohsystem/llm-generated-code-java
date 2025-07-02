package gemini.task134;

import org.junit.jupiter.api.*;
import javax.crypto.SecretKey;
import static org.junit.jupiter.api.Assertions.*;

class Task134Test {

    private SecretKey key;

    @BeforeEach
    void setUp() throws Exception {
         Task134_GEMINI_gemini_1_5_pro_001.generateKey();
        key = getKey();
        assertNotNull(key, "Key should be generated and not null.");
    }

    private SecretKey getKey() throws Exception {
         var field = Task134_GEMINI_gemini_1_5_pro_001.class.getDeclaredField("key");
        field.setAccessible(true);
        return (SecretKey) field.get(null);
    }

    @Test
    void testEncryptionAndDecryption() throws Exception {
        String originalMessage = "Hello, World!";

         String encryptedMessage = Task134_GEMINI_gemini_1_5_pro_001.encrypt(originalMessage, key);
        assertNotNull(encryptedMessage, "Encrypted message should not be null.");
        assertNotEquals(originalMessage, encryptedMessage, "Encrypted message should not match the original.");

         String decryptedMessage = Task134_GEMINI_gemini_1_5_pro_001.decrypt(encryptedMessage, key);
        assertEquals(originalMessage, decryptedMessage, "Decrypted message should exactly match the original.");
    }
}
