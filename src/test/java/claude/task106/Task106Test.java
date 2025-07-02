package claude.task106;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task106Test {

    @Test
    public void testRSAEncryptionDecryption() {
        Task106_CLAUDE_claude_3_5_sonnet_20240620 rsa = new Task106_CLAUDE_claude_3_5_sonnet_20240620();

         String originalMessage = "OpenAI123!";
        BigInteger plaintext = new BigInteger(originalMessage.getBytes());

         BigInteger encrypted = rsa.encrypt(plaintext);

         BigInteger decrypted = rsa.decrypt(encrypted);
        String decryptedMessage = new String(decrypted.toByteArray());

         assertEquals(originalMessage, decryptedMessage, "Decrypted message does not match original.");
    }
}
