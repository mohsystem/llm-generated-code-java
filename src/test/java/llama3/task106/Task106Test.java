package llama3.task106;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Task106Test {

    @Test
    public void testManualRSAEncryptionDecryption() {
        // ثوابت p و q نفس كود Java
        int p = 61;
        int q = 53;

        Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.KeyPair keyPair =
                generateKeyPair(p, q);

        String message = "OpenAI123!";
        byte[] plaintext = message.getBytes();

        byte[] encrypted = encrypt(keyPair.publicKey, plaintext);
        byte[] decrypted = decrypt(keyPair.privateKey, encrypted);

        String decryptedMessage = new String(decrypted);

        assertEquals(message, decryptedMessage, "Decrypted message doesn't match the original");
    }

     private static final java.util.Random random = new java.util.Random();

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
    }

    private static BigInteger multiplicativeInverse(BigInteger e, BigInteger phi) {
        BigInteger x = BigInteger.ZERO;
        BigInteger y = BigInteger.ONE;
        BigInteger a = phi;
        BigInteger b = e;
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger q = a.divide(b);
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
            temp = x;
            x = y.subtract(q.multiply(x));
            y = temp;
        }
        if (y.compareTo(BigInteger.ZERO) < 0) {
            y = y.add(phi);
        }
        return y;
    }

    private static Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.KeyPair generateKeyPair(int p, int q) {
        BigInteger n = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));
        BigInteger phi = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1));
        BigInteger e = new BigInteger(phi.bitLength(), random);
        while (!gcd(e, phi).equals(BigInteger.ONE)) {
            e = new BigInteger(phi.bitLength(), random);
        }
        BigInteger d = multiplicativeInverse(e, phi);
        return new Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.KeyPair(
                new Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.PublicKey(e, n),
                new Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.PrivateKey(d, n)
        );
    }

    private static byte[] encrypt(Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.PublicKey publicKey, byte[] plaintext) {
        byte[] cipher = new byte[plaintext.length];
        for (int i = 0; i < plaintext.length; i++) {
            cipher[i] = (byte) (BigInteger.valueOf(plaintext[i] & 0xFF)
                    .modPow(publicKey.e, publicKey.n).intValue());
        }
        return cipher;
    }

    private static byte[] decrypt(Task106_PERPLEXITY_llama_3_sonar_large_32k_chat.PrivateKey privateKey, byte[] ciphertext) {
        byte[] plain = new byte[ciphertext.length];
        for (int i = 0; i < ciphertext.length; i++) {
            plain[i] = (byte) (BigInteger.valueOf(ciphertext[i] & 0xFF)
                    .modPow(privateKey.d, privateKey.n).intValue());
        }
        return plain;
    }
}
