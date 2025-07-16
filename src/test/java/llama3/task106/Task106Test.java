package llama3.task106;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task106Test {

    @Test
    public void testRSAEncryptionDecryption() {
        // Step 1: Generate key pair
        int p = 61;
        int q = 53;
        Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.KeyPair keyPair =
                Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.generateKeyPair(p, q);

        // Step 2: Original message
        String message = "Hello, World!";
        byte[] originalBytes = message.getBytes();

        // Step 3: Encrypt
        byte[] encrypted = Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt(
                keyPair.publicKey, originalBytes);

        // Step 4: Decrypt
        byte[] decrypted = Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.decrypt(
                keyPair.privateKey, encrypted);

        // Step 5: Assert equality
        assertArrayEquals(originalBytes, decrypted, "Decrypted message must match original");
    }
}
