package llama3.task51;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task51Test {

    @Test
    public void testBasicEncryption() {
        assertEquals("def", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("abc", 3));
    }

    @Test
    public void testEncryptionWithUppercase() {
        assertEquals("DEF", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("ABC", 3));
    }

    @Test
    public void testEncryptionWithMixedCase() {
        assertEquals("cDe", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("aBc", 2));
    }

    @Test
    public void testEncryptionWithNonAlphaCharacters() {
        assertEquals("f g-h", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("a b-c", 5));
    }

    @Test
    public void testEncryptionWithLargeShiftValue() {
        assertEquals("bcd", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("xyz", 30));
    }

    @Test
    public void testEncryptionWithNegativeShiftValue() {
        assertEquals("abc", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("def", -3));
    }

    @Test
    public void testEncryptionWithShiftValueZero() {
        assertEquals("hello", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("hello", 0));
    }

    @Test
    public void testEncryptionWithShiftValue26() {
        assertEquals("xyz", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("xyz", 26));
    }

    @Test
    public void testEncryptionEmptyString() {
        assertEquals("", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("", 5));
    }

    @Test
    public void testEncryptionNonAlphaCharactersOnly() {
        assertEquals("1234!@#$", Task51_PERPLEXITY_llama_3_sonar_large_32k_chat.encrypt("1234!@#$", 4));
    }
}
