package codestral.task85;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task85Test {

    @Test
    public void testLengthOfGeneratedString() {
        int length = 10;
        String result = Task85_MISTRAL_codestral_latest.generateRandomString(length);
        assertEquals(length, result.length(), "Generated string should have the correct length");
    }

    @Test
    public void testGeneratedStringContainsOnlyAsciiLetters() {
        String result = Task85_MISTRAL_codestral_latest.generateRandomString(20);
        assertTrue(result.matches("^[A-Za-z]+$"), "Generated string should contain only ASCII letters");
    }

    @Test
    public void testGeneratedStringIsNotNullOrEmpty() {
        String result = Task85_MISTRAL_codestral_latest.generateRandomString(15);
        assertNotNull(result, "Generated string should not be null");
        assertFalse(result.isEmpty(), "Generated string should not be empty");
    }

    @Test
    public void testRandomnessOfGeneratedStrings() {
        String s1 = Task85_MISTRAL_codestral_latest.generateRandomString(12);
        String s2 = Task85_MISTRAL_codestral_latest.generateRandomString(12);
        assertNotEquals(s1, s2, "Two generated strings should not be equal due to randomness");
    }
}
