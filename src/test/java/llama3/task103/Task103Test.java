package llama3.task103;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task103Test {

    @Test
    void testShortPassword() {
        assertFalse(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("Ab1"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("abcdefgh1"));
    }

    @Test
    void testNoLowercase() {
        assertFalse(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("ABCDEF1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("Abcdefgh"));
    }

    @Test
    void testValidPassword() {
        assertTrue(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("Abcdefg1"));
    }

    @Test
    void testPasswordExactly8Chars() {
        assertTrue(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("A1bcdefg"));
    }

    @Test
    void testPasswordWithSpecialCharacters() {
        assertTrue(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("A1@bcdEf"));
    }

    @Test
    void testAllUppercase() {
        assertFalse(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("ABCDEFGHI"));
    }

    @Test
    void testAllLowercase() {
        assertFalse(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("abcdefgh"));
    }

    @Test
    void testPasswordWithSpaces() {
        assertTrue(Task103_PERPLEXITY_llama_3_sonar_large_32k_chat.passwordStrength("A1 bcdEf"));
    }
}

