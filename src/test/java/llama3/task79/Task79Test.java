package llama3.task79;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task79Test {

    @Test
    public void testBasicEncryption() {
        String result = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("HELLO", 3);
        assertEquals("KHOOR", result); // Caesar cipher with key=3
    }

    @Test
    public void testEncryptionWithSpaces() {
        String result = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("HELLO WORLD", 5);
        assertEquals("MJQQT BTWQI", result); // Key=5
    }

    @Test
    public void testEncryptionWithSpecialCharacters() {
        String result = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("HELLO, WORLD!", 2);
        assertEquals("JGNNQ, YQTNF!", result); // Special characters remain unchanged
    }

    @Test
    public void testEmptyMessage() {
        String result = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("", 10);
        assertEquals("", result); // Empty string should return empty
    }

    @Test
    public void testEncryptionWithNumbers() {
        String result = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("HELLO123", 4);
        assertEquals("LIPPS123", result); // Numbers stay the same
    }

    @Test
    public void testSameKeyProducesSameOutput() {
        String result1 = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("PYTHON", 6);
        String result2 = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("PYTHON", 6);
        assertEquals(result1, result2); // Same input, same key → same output
    }

    @Test
    public void testDifferentKeyProducesDifferentOutput() {
        String result1 = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("PYTHON", 6);
        String result2 = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("PYTHON", 8);
        assertNotEquals(result1, result2); // Same input, different key → different output
    }

    @Test
    public void testCaseInsensitiveEncryption() {
        String result = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("Python", 7);
        assertEquals("WFAOVU", result); // Case is preserved; result in upper-case
    }

    @Test
    public void testKeyAffectsShuffling() {
        String result1 = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("TEST", 9);
        String result2 = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("TEST", 10);
        assertNotEquals(result1, result2); // Key difference affects result
    }

    @Test
    public void testSameKeyAndMessageDifferentCases() {
        String result1 = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("test", 11);
        String result2 = Task79_PERPLEXITY_llama_3_sonar_large_32k_chat.encryptMessage("TEST", 11);
        assertEquals(result1.toUpperCase(), result2.toUpperCase()); // Should be equal ignoring case
    }
}
