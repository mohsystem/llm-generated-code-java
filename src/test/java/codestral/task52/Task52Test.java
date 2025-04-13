package codestral.task52;

import org.junit.jupiter.api.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class Task52Test {

    private static final String TEST_TEXT = "This is a test.";
    private static final String FIXED_KEY = "1234567890123456"; // 16-byte key for AES
    private static File testFile;
    private static File encryptedFile;
    private static File decryptedFile;

    @BeforeAll
    public static void setup() throws IOException {
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
        Task52_MISTRAL_codestral_latest.encryptFile(FIXED_KEY, testFile, encryptedFile);
        assertTrue(encryptedFile.exists(), "Encrypted file should exist");

        byte[] originalBytes = Files.readAllBytes(testFile.toPath());
        byte[] encryptedBytes = Files.readAllBytes(encryptedFile.toPath());

        assertNotEquals(new String(originalBytes), new String(encryptedBytes), "Encrypted data should differ from original");
    }

    @Test
    public void testDecryptFile() throws Exception {
        Task52_MISTRAL_codestral_latest.encryptFile(FIXED_KEY, testFile, encryptedFile);
        Task52_MISTRAL_codestral_latest.decryptFile(FIXED_KEY, encryptedFile, decryptedFile);

        assertTrue(decryptedFile.exists(), "Decrypted file should exist");

        byte[] originalBytes = Files.readAllBytes(testFile.toPath());
        byte[] decryptedBytes = Files.readAllBytes(decryptedFile.toPath());

        assertArrayEquals(originalBytes, decryptedBytes, "Decrypted content must match the original");
    }

    @Test
    public void testEncryptNonExistentFile() {
        File fakeInput = new File("non_existent_file.txt");
        File output = new File("fake_output.encrypted");

        Exception exception = assertThrows(Exception.class, () -> {
            Task52_MISTRAL_codestral_latest.encryptFile(FIXED_KEY, fakeInput, output);
        });

        assertTrue(exception instanceof IOException || exception instanceof java.io.FileNotFoundException);
    }

    @Test
    public void testDecryptNonExistentFile() {
        File fakeInput = new File("non_existent_file.encrypted");
        File output = new File("fake_output.decrypted");

        Exception exception = assertThrows(Exception.class, () -> {
            Task52_MISTRAL_codestral_latest.decryptFile(FIXED_KEY, fakeInput, output);
        });

        assertTrue(exception instanceof IOException || exception instanceof java.io.FileNotFoundException);
    }
}
