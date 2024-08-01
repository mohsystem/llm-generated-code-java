package gtp4o.task106;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Task106_OPENAI_gpt_4o {
    private BigInteger n, d, e;
    private int bitlen = 1024;

    public Task106_OPENAI_gpt_4o() {
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitlen / 2, 100, r);
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("3");
        while (m.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        d = e.modInverse(m);
    }

    public synchronized BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public synchronized BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, n);
    }

    public static void main(String[] args) {
        Task106_OPENAI_gpt_4o rsa = new Task106_OPENAI_gpt_4o();
        String text1 = "Hello RSA!";
        System.out.println("Plaintext: " + text1);
        BigInteger plaintext = new BigInteger(text1.getBytes());
        BigInteger ciphertext = rsa.encrypt(plaintext);
        System.out.println("Encrypted: " + ciphertext);
        plaintext = rsa.decrypt(ciphertext);
        String text2 = new String(plaintext.toByteArray());
        System.out.println("Decrypted: " + text2);
    }
}