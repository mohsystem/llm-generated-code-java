package gemini.task85;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task85Test {

    @Test
    public void testGeneratedStringLength() {
        String result = Task85_GEMINI_gemini_1_5_pro_001.generateRandomString(12);
        assertEquals(12, result.length(), "Generated string should be 12 characters long");
    }

    @Test
    public void testGeneratedStringOnlyAsciiLetters() {
        String result = Task85_GEMINI_gemini_1_5_pro_001.generateRandomString(20);
        assertTrue(result.matches("^[a-zA-Z]+$"), "Generated string should contain only ASCII letters");
    }

    @Test
    public void testGeneratedStringIsRandom() {
        String s1 = Task85_GEMINI_gemini_1_5_pro_001.generateRandomString(16);
        String s2 = Task85_GEMINI_gemini_1_5_pro_001.generateRandomString(16);
        assertNotEquals(s1, s2, "Each generated string should be different");
    }
}
