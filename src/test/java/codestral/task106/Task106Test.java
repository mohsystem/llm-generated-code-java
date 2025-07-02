package codestral.task106;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task106Test {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    public void testRSAEncryptionDecryptionWithBouncyCastle() throws Exception {
         KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

         String originalMessage = "OpenAI123!";

         Cipher encryptCipher = Cipher.getInstance("RSA/None/PKCS1Padding", "BC");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = encryptCipher.doFinal(originalMessage.getBytes());

         Cipher decryptCipher = Cipher.getInstance("RSA/None/PKCS1Padding", "BC");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = decryptCipher.doFinal(encryptedBytes);
        String decryptedMessage = new String(decryptedBytes);

         assertEquals(originalMessage, decryptedMessage, "Decrypted message does not match the original message.");
    }
}
