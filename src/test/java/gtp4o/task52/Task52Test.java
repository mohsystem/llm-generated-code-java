package gtp4o.task52;

import org.junit.jupiter.api.*;
import javax.crypto.SecretKey;
import java.nio.file.*;
import java.util.Base64;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Task52Test {

    private static final String TEST_TEXT = "This is a test.";
    private static Path testFile;
    private static Path encryptedFile;
    private static Path decryptedFile;
    private static Path keyPath;

    @BeforeAll
    public static void setup() throws IOException {
        testFile = Paths.get("test_file.txt");
        encryptedFile = Paths.get("test_file.txt.encrypted");
        decryptedFile = Paths.get("test_file.txt.decrypted");
        keyPath = Paths.get("filekey.key");

        Files.write(testFile, TEST_TEXT.getBytes());
    }

    @AfterAll
    public static void cleanup() throws IOException {
        Files.deleteIfExists(testFile);
        Files.deleteIfExists(encryptedFile);
        Files.deleteIfExists(decryptedFile);
        Files.deleteIfExists(keyPath);
    }

    @Test
    public void testEncryptFile() throws Exception {
        SecretKey key = Task52_OPENAI_gpt_4o.generateKey();
        Task52_OPENAI_gpt_4o.saveKey(key, keyPath);
        Task52_OPENAI_gpt_4o.encryptFile(key, testFile, encryptedFile);

        assertTrue(Files.exists(encryptedFile), "Encrypted file should exist");
        byte[] original = Files.readAllBytes(testFile);
        byte[] encrypted = Files.readAllBytes(encryptedFile);
        assertNotEquals(new String(original), new String(encrypted), "Encrypted content should differ");
    }

    @Test
    public void testDecryptFile() throws Exception {
        SecretKey key = Task52_OPENAI_gpt_4o.generateKey();
        Task52_OPENAI_gpt_4o.saveKey(key, keyPath);
        Task52_OPENAI_gpt_4o.encryptFile(key, testFile, encryptedFile);
        Task52_OPENAI_gpt_4o.decryptFile(key, encryptedFile, decryptedFile);

        assertTrue(Files.exists(decryptedFile), "Decrypted file should exist");
        byte[] original = Files.readAllBytes(testFile);
        byte[] decrypted = Files.readAllBytes(decryptedFile);
        assertArrayEquals(original, decrypted, "Decrypted content must match original");
    }

    @Test
    public void testEncryptNonExistentFile() throws Exception {
        SecretKey key = Task52_OPENAI_gpt_4o.generateKey();
        Path fakeInput = Paths.get("non_existent.txt");
        Path output = Paths.get("fake.encrypted");

        Exception ex = assertThrows(IOException.class, () ->
                Task52_OPENAI_gpt_4o.encryptFile(key, fakeInput, output));
        assertTrue(ex instanceof java.nio.file.NoSuchFileException);
    }

    @Test
    public void testDecryptNonExistentFile() throws Exception {
        SecretKey key = Task52_OPENAI_gpt_4o.generateKey();
        Path fakeInput = Paths.get("non_existent.encrypted");
        Path output = Paths.get("fake.decrypted");

        Exception ex = assertThrows(IOException.class, () ->
                Task52_OPENAI_gpt_4o.decryptFile(key, fakeInput, output));
        assertTrue(ex instanceof java.nio.file.NoSuchFileException);
    }
}
