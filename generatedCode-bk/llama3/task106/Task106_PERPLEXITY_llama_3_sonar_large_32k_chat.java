package llama3.task106;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class Task106_PERPLEXITY_llama_3_sonar_large_32k_chat {
    private BigInteger p, q, n, phi, e, d;

    public Task106_PERPLEXITY_llama_3_sonar_large_32k_chat(int bits) {
        SecureRandom random = new SecureRandom();
        p = new BigInteger(bits / 2, 100, random);
        q = new BigInteger(bits / 2, 100, random);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("65537"); // 2^16 + 1
        d = e.modInverse(phi);
    }

    public String encrypt(String message) {
        BigInteger msg = new BigInteger(message.getBytes());
        BigInteger encrypted = msg.modPow(e, n);
        return encrypted.toString();
    }

    public String decrypt(String encrypted) {
        BigInteger encryptedMsg = new BigInteger(encrypted);
        BigInteger decrypted = encryptedMsg.modPow(d, n);
        return new String(decrypted.toByteArray());
    }

    public static void main(String[] args) {
        Task106_PERPLEXITY_llama_3_sonar_large_32k_chat rsa = new Task106_PERPLEXITY_llama_3_sonar_large_32k_chat(1024);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message:");
        String message = scanner.nextLine();
        String encrypted = rsa.encrypt(message);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}