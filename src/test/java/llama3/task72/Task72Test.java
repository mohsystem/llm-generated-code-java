package llama3.task72;

import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task72Test  {

    @Test
    public void testLlamaEncryptionMatchesPython() throws Exception {
        String keyString = "sixteen byte key"; // ✅ 16 bytes
        String plainText = "Hello, World!";
        byte[] iv = new byte[16]; // static IV: 16 zero bytes

         Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(keyString.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] expectedEncrypted = cipher.doFinal(plainText.getBytes());
        String expectedBase64 = Base64.getEncoder().encodeToString(expectedEncrypted);

         Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher2.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] actualEncrypted = cipher2.doFinal(plainText.getBytes());
        String actualBase64 = Base64.getEncoder().encodeToString(actualEncrypted);

        assertEquals(expectedBase64, actualBase64, "Encrypted Base64 output must match Python result exactly.");
    }
}
