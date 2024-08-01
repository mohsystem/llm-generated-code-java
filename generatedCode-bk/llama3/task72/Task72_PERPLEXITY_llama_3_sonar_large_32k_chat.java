package llama3.task72;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task72_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) throws Exception {
        String data = "Hello, World!";
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        SecretKeySpec secretKeySpec = new SecretKeySpec("Bar12345Bar12345".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        System.out.println(Base64.getEncoder().encodeToString(encryptedData));
    }
}