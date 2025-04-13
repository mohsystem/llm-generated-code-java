package gemini.task79;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class Task79Test {

    static String secretKeyBase64;

    @BeforeAll
    public static void generateSecretKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit AES
        SecretKey secretKey = keyGen.generateKey();
        secretKeyBase64 = Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    @Test
    public void testEncryptionWorks() throws Exception {
        String message = "HELLO WORLD";
        String encrypted = Task79_GEMINI_gemini_1_5_pro_001.encryptMessage(message, secretKeyBase64);

        assertNotNull(encrypted, "Encrypted message should not be null");
        assertNotEquals(message, encrypted, "Encrypted message should differ from original");
    }

    @Test
    public void testSameInputSameKeySameOutput() throws Exception {
        String message = "SECURE MESSAGE";
        String encrypted1 = Task79_GEMINI_gemini_1_5_pro_001.encryptMessage(message, secretKeyBase64);
        String encrypted2 = Task79_GEMINI_gemini_1_5_pro_001.encryptMessage(message, secretKeyBase64);

        assertEquals(encrypted1, encrypted2, "Encryption with same message and key should yield same result");
    }

    @Test
    public void testSameInputDifferentKeyDifferentOutput() throws Exception {
        String message = "SECURE MESSAGE";

        // Generate different key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey differentKey = keyGen.generateKey();
        String differentKeyBase64 = Base64.getEncoder().encodeToString(differentKey.getEncoded());

        String encrypted1 = Task79_GEMINI_gemini_1_5_pro_001.encryptMessage(message, secretKeyBase64);
        String encrypted2 = Task79_GEMINI_gemini_1_5_pro_001.encryptMessage(message, differentKeyBase64);

        assertNotEquals(encrypted1, encrypted2, "Different keys should yield different encrypted output");
    }

    @Test
    public void testEmptyMessage() throws Exception {
        String encrypted = Task79_GEMINI_gemini_1_5_pro_001.encryptMessage("", secretKeyBase64);
        assertNotNull(encrypted);
        assertFalse(encrypted.isEmpty(), "Encrypted empty message should not be empty (AES adds padding)");
    }
}
