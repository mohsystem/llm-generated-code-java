package gemini.task106;

import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class Task106Test {

    @Test
    public void testRSAWithOAEPEncryptionDecryption() throws Exception {
         KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

         String message = "OpenAI123!";

         Cipher encryptionCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = encryptionCipher.doFinal(message.getBytes());
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);

         Cipher decryptionCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        decryptionCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = decryptionCipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
        String decryptedMessage = new String(decryptedBytes);

         assertEquals(message, decryptedMessage, "Decrypted message does not match original");
    }
}
