package claude.task85;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task85Test {

    @Test
    public void testGenerateRandomString_LengthIsCorrect() {
        int length = 10;
        String result = Task85_CLAUDE_claude_3_5_sonnet_20240620.generateRandomString(length);
        assertEquals(length, result.length(), "Generated string should have the specified length");
    }

    @Test
    public void testGenerateRandomString_OnlyAsciiLetters() {
        String result = Task85_CLAUDE_claude_3_5_sonnet_20240620.generateRandomString(20);
        assertTrue(result.matches("^[a-zA-Z]+$"), "Generated string should only contain ASCII letters");
    }

    @Test
    public void testGenerateRandomString_NotNullOrEmpty() {
        String result = Task85_CLAUDE_claude_3_5_sonnet_20240620.generateRandomString(15);
        assertNotNull(result, "Generated string should not be null");
        assertFalse(result.isEmpty(), "Generated string should not be empty");
    }

    @Test
    public void testGenerateRandomString_Randomness() {
        String r1 = Task85_CLAUDE_claude_3_5_sonnet_20240620.generateRandomString(12);
        String r2 = Task85_CLAUDE_claude_3_5_sonnet_20240620.generateRandomString(12);
        assertNotEquals(r1, r2, "Two generated strings should be different");
    }
}
