package llama3.task134;

import org.junit.jupiter.api.*;
import java.security.Key;
import static org.junit.jupiter.api.Assertions.*;

class Task134Test {

    private Task134_PERPLEXITY_llama_3_sonar_large_32k_chat manager;
    private static final String KEY_NAME = "test_key";

    @BeforeEach
    void setUp() {
        manager = new Task134_PERPLEXITY_llama_3_sonar_large_32k_chat();
    }

    @Test
    void testKeyGenerationRetrievalHashingAndDeletion() throws Exception {
         manager.generateKey(KEY_NAME);

         Key key = manager.getKey(KEY_NAME);
        assertNotNull(key, "Key should be generated and retrievable.");

         String hash = manager.hashKey(KEY_NAME);
        assertNotNull(hash, "Hash should not be null.");
        assertFalse(hash.isEmpty(), "Hash should not be empty.");
        assertEquals(64, hash.length(), "SHA-256 hash should be 64 characters long.");

         manager.deleteKey(KEY_NAME);

         Key deletedKey = manager.getKey(KEY_NAME);
        assertNull(deletedKey, "Key should be null after deletion.");

         String deletedHash = manager.hashKey(KEY_NAME);
        assertNull(deletedHash, "Hash should be null after key deletion.");
    }
}
