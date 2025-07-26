package codestral.task106;

import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task106Test {

    static class RSAWrapper {
        private final PublicKey publicKey;
        private final PrivateKey privateKey;

        public RSAWrapper() throws Exception {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        }

        public byte[] encrypt(String plaintext) throws Exception {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(plaintext.getBytes());
        }

        public String decrypt(byte[] encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(cipher.doFinal(encrypted));
        }
    }

    @Test
    public void testRSAEncryptionDecryption() throws Exception {
        RSAWrapper rsa = new RSAWrapper();
        String message = "OpenAI123!";
        byte[] encrypted = rsa.encrypt(message);
        String decrypted = rsa.decrypt(encrypted);

        assertEquals(message, decrypted);
    }
}
