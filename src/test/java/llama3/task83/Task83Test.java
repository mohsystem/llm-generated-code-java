package llama3.task83;

import org.junit.jupiter.api.Test;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class Task83Test {

    @Test
    public void testEncryptAESCBC_OutputMatchesExpected() throws Exception {
        byte[] key = new byte[16]; // all zeros
        String plaintext = "Hello, World!";

         String expectedBase64 = Task83_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptAESCBC(key, plaintext);

        String actual = Task83_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptAESCBC(key, plaintext);
        assertEquals(expectedBase64, actual, "Encryption output should be consistent for the same input and key");
    }

    @Test
    public void testEncryptAESCBC_OutputIsValidBase64() throws Exception {
        byte[] key = new byte[16];
        String plaintext = "Hello, World!";
        String encrypted = Task83_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptAESCBC(key, plaintext);

        assertDoesNotThrow(() -> Base64.getDecoder().decode(encrypted), "Output should be valid Base64");
    }

    @Test
    public void testEncryptAESCBC_ChangesIfPlaintextChanges() throws Exception {
        byte[] key = new byte[16];

        String encrypted1 = Task83_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptAESCBC(key, "Hello, World!");
        String encrypted2 = Task83_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptAESCBC(key, "Hello, ChatGPT!");

        assertNotEquals(encrypted1, encrypted2, "Different plaintext should produce different ciphertext");
    }
}
