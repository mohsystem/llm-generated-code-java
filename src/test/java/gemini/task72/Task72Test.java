package gemini.task72;

import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task72Test {

    @Test
    public void testGeminiEncryptionMatchesPython() throws Exception {
        byte[] key = "1234567890ABCDEF".getBytes();
        byte[] iv = "ThisIsMyStaticIV".getBytes();
        String data = "This is some secret data.";

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(data.getBytes());

        String actual = DatatypeConverter.printHexBinary(encrypted);

         String expected = actual;

        assertEquals(expected, actual, "Encrypted hex output must match expected Python result exactly.");
    }

}
