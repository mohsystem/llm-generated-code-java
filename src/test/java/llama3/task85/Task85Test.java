package llama3.task85;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task85Test {

    @Test
    public void testGenerateRandomString_LengthCorrect() {
        int length = 10;
        String result = Task85_PERPLEXITY_llama_3_sonar_large_32k_chat.generateRandomString(length);
        assertEquals(length, result.length(), "Generated string should have the correct length");
    }

    @Test
    public void testGenerateRandomString_OnlyAsciiLetters() {
        String result = Task85_PERPLEXITY_llama_3_sonar_large_32k_chat.generateRandomString(20);
        assertTrue(result.matches("^[a-zA-Z]+$"), "Generated string should contain only ASCII letters");
    }

    @Test
    public void testGenerateRandomString_IsRandom() {
        String s1 = Task85_PERPLEXITY_llama_3_sonar_large_32k_chat.generateRandomString(16);
        String s2 = Task85_PERPLEXITY_llama_3_sonar_large_32k_chat.generateRandomString(16);
        assertNotEquals(s1, s2, "Two generated strings should not be the same");
    }

    @Test
    public void testGenerateRandomString_NotNullOrEmpty() {
        String result = Task85_PERPLEXITY_llama_3_sonar_large_32k_chat.generateRandomString(12);
        assertNotNull(result, "Generated string should not be null");
        assertFalse(result.isEmpty(), "Generated string should not be empty");
    }
}
