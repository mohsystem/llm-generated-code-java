package gemini.task52;

import org.junit.jupiter.api.*;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class Task52Test {

    private static final String TEST_TEXT = "This is a test.";
    private static SecretKeySpec key;
    private static File testFile;
    private static File encryptedFile;
    private static File decryptedFile;

    @BeforeAll
    public static void setup() throws Exception {
        // Key preparation
        SecretKey secretKey = Task52_GEMINI_gemini_1_5_pro_001.generateKey();
        key = new SecretKeySpec(secretKey.getEncoded(), "AES");

        // File preparation
        testFile = new File("test_file.txt");
        encryptedFile = new File("test_file.txt.encrypted");
        decryptedFile = new File("test_file.txt.decrypted");

        try (FileOutputStream fos = new FileOutputStream(testFile)) {
            fos.write(TEST_TEXT.getBytes());
        }
    }

    @AfterAll
    public static void cleanup() {
        if (testFile.exists()) testFile.delete();
        if (encryptedFile.exists()) encryptedFile.delete();
        if (decryptedFile.exists()) decryptedFile.delete();
    }

    @Test
    public void testEncryptFile() throws Exception {
        Task52_GEMINI_gemini_1_5_pro_001.encryptFile(key, testFile.getPath(), encryptedFile.getPath());
        assertTrue(encryptedFile.exists(), "Encrypted file should exist");

        byte[] originalBytes = Files.readAllBytes(testFile.toPath());
        byte[] encryptedBytes = Files.readAllBytes(encryptedFile.toPath());

        assertNotEquals(new String(originalBytes), new String(encryptedBytes), "Encrypted data should differ from original");
    }

    @Test
    public void testDecryptFile() throws Exception {
        // Encrypt and then decrypt
        Task52_GEMINI_gemini_1_5_pro_001.encryptFile(key, testFile.getPath(), encryptedFile.getPath());
        Task52_GEMINI_gemini_1_5_pro_001.decryptFile(key, encryptedFile.getPath(), decryptedFile.getPath());

        assertTrue(decryptedFile.exists(), "Decrypted file should exist");

        byte[] originalBytes = Files.readAllBytes(testFile.toPath());
        byte[] decryptedBytes = Files.readAllBytes(decryptedFile.toPath());

        assertArrayEquals(originalBytes, decryptedBytes, "Decrypted content must match original");
    }

    @Test
    public void testEncryptNonExistentFile() {
        File fakeInput = new File("non_existent_file.txt");
        File output = new File("fake_output.encrypted");

        Exception exception = assertThrows(Exception.class, () -> {
            Task52_GEMINI_gemini_1_5_pro_001.encryptFile(key, fakeInput.getPath(), output.getPath());
        });

        assertTrue(exception instanceof java.io.FileNotFoundException);
    }

    @Test
    public void testDecryptNonExistentFile() {
        File fakeInput = new File("non_existent_file.encrypted");
        File output = new File("fake_output.decrypted");

        Exception exception = assertThrows(Exception.class, () -> {
            Task52_GEMINI_gemini_1_5_pro_001.decryptFile(key, fakeInput.getPath(), output.getPath());
        });

        assertTrue(exception instanceof java.io.FileNotFoundException);
    }
}
