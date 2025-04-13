package claude.task52;

import org.junit.jupiter.api.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;

public class Task52Test {

    private static final String TEST_TEXT = "This is a test.";
    private static File testFile;
    private static File encryptedFile;
    private static File decryptedFile;
    private static String key;

    @BeforeAll
    public static void setup() throws Exception {
        key = Task52_CLAUDE_claude_3_5_sonnet_20240620.generateKey();
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
        Task52_CLAUDE_claude_3_5_sonnet_20240620.encrypt(key, testFile, encryptedFile);
        assertTrue(encryptedFile.exists(), "Encrypted file should exist");

        byte[] originalBytes = Files.readAllBytes(testFile.toPath());
        byte[] encryptedBytes = Files.readAllBytes(encryptedFile.toPath());
        assertNotEquals(new String(originalBytes), new String(encryptedBytes), "Encrypted data should differ from original");
    }

    @Test
    public void testDecryptFile() throws Exception {
        // Ensure file is encrypted first
        Task52_CLAUDE_claude_3_5_sonnet_20240620.encrypt(key, testFile, encryptedFile);
        Task52_CLAUDE_claude_3_5_sonnet_20240620.decrypt(key, encryptedFile, decryptedFile);

        assertTrue(decryptedFile.exists(), "Decrypted file should exist");

        byte[] originalBytes = Files.readAllBytes(testFile.toPath());
        byte[] decryptedBytes = Files.readAllBytes(decryptedFile.toPath());
        assertArrayEquals(originalBytes, decryptedBytes, "Decrypted data should match original");
    }

    @Test
    public void testEncryptNonExistentFile() {
        File fakeInput = new File("non_existent_file.txt");
        File output = new File("should_not_create.encrypted");

        Exception exception = assertThrows(Exception.class, () -> {
            Task52_CLAUDE_claude_3_5_sonnet_20240620.encrypt(key, fakeInput, output);
        });

        assertTrue(exception instanceof IOException || exception instanceof java.io.FileNotFoundException);
    }

    @Test
    public void testDecryptNonExistentFile() {
        File fakeInput = new File("non_existent_file.encrypted");
        File output = new File("should_not_create.decrypted");

        Exception exception = assertThrows(Exception.class, () -> {
            Task52_CLAUDE_claude_3_5_sonnet_20240620.decrypt(key, fakeInput, output);
        });

        assertTrue(exception instanceof IOException || exception instanceof java.io.FileNotFoundException);
    }
}
