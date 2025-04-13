package llama3.task52;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class Task52Test {

    private static final String ORIGINAL_TEXT = "This is a test.";
    private static final int SHIFT = 3;
    private static File testFile;

    @BeforeAll
    public static void setup() throws Exception {
        testFile = new File("test_file.txt");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write(ORIGINAL_TEXT);
        }
    }

    @AfterAll
    public static void cleanup() {
        if (testFile.exists()) testFile.delete();
    }

    @Test
    public void testCaesarEncrypt() {
        String encrypted = Task52_PERPLEXITY_llama_3_sonar_large_32k_chat.caesarEncrypt("ABC xyz", SHIFT);
        assertEquals("DEF abc", encrypted);
    }

    @Test
    public void testCaesarDecrypt() {
        String decrypted = Task52_PERPLEXITY_llama_3_sonar_large_32k_chat.caesarDecrypt("DEF abc", SHIFT);
        assertEquals("ABC xyz", decrypted);
    }

    @Test
    public void testEncryptFile() throws Exception {
        Task52_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptFile(testFile.getPath(), SHIFT);
        String encryptedContent = new String(Files.readAllBytes(testFile.toPath()));

        assertNotEquals(ORIGINAL_TEXT, encryptedContent, "Content must be encrypted");
        assertEquals(Task52_PERPLEXITY_llama_3_sonar_large_32k_chat.caesarEncrypt(ORIGINAL_TEXT, SHIFT), encryptedContent);
    }

    @Test
    public void testDecryptFile() throws Exception {
        // Encrypt then Decrypt
        Task52_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptFile(testFile.getPath(), SHIFT);
        Task52_PERPLEXITY_llama_3_sonar_large_32k_chat.decryptFile(testFile.getPath(), SHIFT);
        String finalContent = new String(Files.readAllBytes(testFile.toPath()));

        assertEquals(ORIGINAL_TEXT, finalContent, "Decrypted content must match the original");
    }

    @Test
    public void testEncryptNonExistentFile() {
        File fakeFile = new File("non_existent.txt");

        Exception ex = assertThrows(Exception.class, () -> {
            Task52_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptFile(fakeFile.getPath(), SHIFT);
        });

        assertTrue(ex instanceof java.nio.file.NoSuchFileException || ex instanceof java.io.FileNotFoundException);
    }

    @Test
    public void testDecryptNonExistentFile() {
        File fakeFile = new File("non_existent.txt");

        Exception ex = assertThrows(Exception.class, () -> {
            Task52_PERPLEXITY_llama_3_sonar_large_32k_chat.decryptFile(fakeFile.getPath(), SHIFT);
        });

        assertTrue(ex instanceof java.nio.file.NoSuchFileException || ex instanceof java.io.FileNotFoundException);
    }
}
