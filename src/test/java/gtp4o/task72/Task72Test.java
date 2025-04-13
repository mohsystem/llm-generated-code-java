package gtp4o.task72;

import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task72Test  {

    @Test
    public void testGpt4oEncryptionMatchesPython() throws Exception {
        String key = "sixteen byte key";
        String data = "Hello, World!";
        byte[] iv = new byte[16];

        // Encrypt manually as expected from Python
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        String expectedBase64 = Base64.getEncoder().encodeToString(encrypted);

        // Encrypt using the actual method from the class
        byte[] actualEncrypted = Task72_OPENAI_gpt_4o.encrypt_data(data, key);
        String actualBase64 = Base64.getEncoder().encodeToString(actualEncrypted);

        assertEquals(expectedBase64, actualBase64, "Encrypted Base64 output must match Python-equivalent result exactly.");
    }
}
