package claude.task83;

import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class Task83Test {

    @Test
    public void testEncryptKey_NotNullOrEmpty() throws Exception {
        String keyToEncrypt = "MySecretKey123456";
        String encryptedKey = Task83_CLAUDE_claude_3_5_sonnet_20240620.encryptKey(keyToEncrypt);

        assertNotNull(encryptedKey, "Encrypted key should not be null");
        assertFalse(encryptedKey.isEmpty(), "Encrypted key should not be empty");
    }

    @Test
    public void testEncryptKey_ValidBase64() throws Exception {
        String keyToEncrypt = "MySecretKey123456";
        String encryptedKey = Task83_CLAUDE_claude_3_5_sonnet_20240620.encryptKey(keyToEncrypt);

         assertDoesNotThrow(() -> Base64.getDecoder().decode(encryptedKey), "Encrypted key should be valid Base64");
    }

    @Test
    public void testEncryptKey_MultipleCallsProduceDifferentResults() throws Exception {
        String keyToEncrypt = "MySecretKey123456";
        String encrypted1 = Task83_CLAUDE_claude_3_5_sonnet_20240620.encryptKey(keyToEncrypt);
        String encrypted2 = Task83_CLAUDE_claude_3_5_sonnet_20240620.encryptKey(keyToEncrypt);

        assertNotEquals(encrypted1, encrypted2, "Two different encryptions should not produce the same result");
    }
}
