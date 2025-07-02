package codestral.task134;

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
    void testKeyGenerationAndSavingAndLoading() throws Exception {
         assertFalse(new File(KEY_FILE).exists(), "Key file should not exist before generation.");

         SecretKey generatedKey = Task134_MISTRAL_codestral_latest.generateKey();
        assertNotNull(generatedKey, "Generated key should not be null.");
        assertEquals(32, generatedKey.getEncoded().length, "Generated key should be 32 bytes (256 bits).");

         Task134_MISTRAL_codestral_latest.saveKey(generatedKey, KEY_FILE);

         File keyFile = new File(KEY_FILE);
        assertTrue(keyFile.exists(), "Key file should exist after saving.");
        assertEquals(32, keyFile.length(), "Saved key file should have size 32 bytes.");

         SecretKey loadedKey = Task134_MISTRAL_codestral_latest.loadKey(KEY_FILE);
        assertNotNull(loadedKey, "Loaded key should not be null.");
        assertEquals(32, loadedKey.getEncoded().length, "Loaded key should be 32 bytes (256 bits).");

         assertArrayEquals(generatedKey.getEncoded(), loadedKey.getEncoded(), "Loaded key should match the saved key.");
    }

    @AfterEach
    void tearDown() {
         File file = new File(KEY_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
