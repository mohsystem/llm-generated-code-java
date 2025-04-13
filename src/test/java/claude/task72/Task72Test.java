package claude.task72;

import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Task72Test {

    private static byte[] encryptDataReference(byte[] data, byte[] key) throws Exception {
        // Same reference logic as the prompt
        byte[] iv = new byte[16]; // static IV = 0s
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(data);
    }

    @Test
    public void testEncryptionOutputMatchesReference() throws Exception {
        byte[] key = new byte[] {
                1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23, 24,
                25, 26, 27, 28, 29, 30, 31, 32
        };

        byte[] data = "This is a secret message.".getBytes();

        byte[] expected = encryptDataReference(data, key);
        byte[] actual = Task72_CLAUDE_claude_3_5_sonnet_20240620.encryptData(data, key);

        assertArrayEquals(expected, actual, "Encrypted output does not match the expected value.");
    }

    @Test
    public void testDifferentKeyProducesDifferentCiphertext() throws Exception {
        byte[] data = "This is a secret message.".getBytes();

        byte[] key1 = new byte[32];
        byte[] key2 = new byte[32];
        for (int i = 0; i < 32; i++) {
            key1[i] = (byte) i;
            key2[i] = (byte) (i + 1);
        }

        byte[] encrypted1 = Task72_CLAUDE_claude_3_5_sonnet_20240620.encryptData(data, key1);
        byte[] encrypted2 = Task72_CLAUDE_claude_3_5_sonnet_20240620.encryptData(data, key2);

        assertFalse(Arrays.equals(encrypted1, encrypted2), "Different keys should produce different ciphertexts.");
    }

    @Test
    public void testEmptyInputStillEncryptsCorrectly() throws Exception {
        byte[] key = new byte[32];
        byte[] data = new byte[0]; // empty data
        byte[] result = Task72_CLAUDE_claude_3_5_sonnet_20240620.encryptData(data, key);

        assertNotNull(result);
        assertTrue(result.length > 0, "Even empty input should result in a padded encrypted output.");
    }
}
