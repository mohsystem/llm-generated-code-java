package gtp4o.task134;

import org.junit.jupiter.api.*;
import java.io.File;
import java.security.PrivateKey;
import static org.junit.jupiter.api.Assertions.*;

class Task134Test {

    private static final String KEY_FILE = "private_key.der";

    @BeforeEach
    void cleanUp() {
         File file = new File(KEY_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testKeyGenerationSavingAndLoading() throws Exception {
         var keyGen = java.security.KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        var pair = keyGen.generateKeyPair();
        PrivateKey originalKey = pair.getPrivate();
        assertNotNull(originalKey, "Generated private key should not be null.");

         Task134_OPENAI_gpt_4o.saveKey(originalKey, KEY_FILE);

         File keyFile = new File(KEY_FILE);
        assertTrue(keyFile.exists(), "Key file should exist after saving.");

         PrivateKey loadedKey = Task134_OPENAI_gpt_4o.loadKey(KEY_FILE);
        assertNotNull(loadedKey, "Loaded private key should not be null.");

         assertArrayEquals(originalKey.getEncoded(), loadedKey.getEncoded(), "Loaded key should match the original key bytes.");
    }

    @AfterEach
    void tearDown() {
         File file = new File(KEY_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
