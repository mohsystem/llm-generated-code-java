package claude.task134;

import org.junit.jupiter.api.*;
import javax.crypto.SecretKey;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class Task134Test {

    private static final String KEY_FILE = "secret.key";

    @BeforeEach
    void cleanUp() {
         File file = new File(KEY_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testKeyGenerationAndEncryptionDecryption() throws Exception {
         assertFalse(new File(KEY_FILE).exists(), "Key file should not exist before generation.");

         Task134_CLAUDE_claude_3_5_sonnet_20240620.generateKey();

         File keyFile = new File(KEY_FILE);
        assertTrue(keyFile.exists(), "Key file should exist after generation.");
        assertEquals(32, keyFile.length(), "Key file size should be 32 bytes (256 bits key).");

         SecretKey key = Task134_CLAUDE_claude_3_5_sonnet_20240620.loadKey();
        assertNotNull(key, "Loaded key should not be null.");

         String message = "Hello, World!";

         String encrypted = Task134_CLAUDE_claude_3_5_sonnet_20240620.encrypt(message, key);
        assertNotNull(encrypted, "Encrypted message should not be null.");
        assertNotEquals(message, encrypted, "Encrypted message should not be the same as the original.");

         String decrypted = Task134_CLAUDE_claude_3_5_sonnet_20240620.decrypt(encrypted, key);
        assertEquals(message, decrypted, "Decrypted message should match the original message.");
    }

    @AfterEach
    void tearDown() {
         File file = new File(KEY_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
