package claude.task128;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task128Test {

    @RepeatedTest(100)
    public void testRandomNumberWithinRange() {
        int min = 1;
        int max = 100;
        int result = Task128_CLAUDE_claude_3_5_sonnet_20240620.generateRandomNumber(min, max);
        assertTrue(result >= min && result <= max, "Random number out of range: " + result);
    }

    @Test
    public void testRandomTokenLength() {
        int length = 10;
        String token = Task128_CLAUDE_claude_3_5_sonnet_20240620.generateRandomToken(length);
        assertEquals(length, token.length(), "Token length mismatch");
    }

    @Test
    public void testRandomTokenCharactersValidity() {
        String token = Task128_CLAUDE_claude_3_5_sonnet_20240620.generateRandomToken(100);
        assertTrue(token.matches("[A-Za-z0-9]+"), "Token contains invalid characters");
    }

    @Test
    public void testRandomTokenUniqueness() {
        String token1 = Task128_CLAUDE_claude_3_5_sonnet_20240620.generateRandomToken(16);
        String token2 = Task128_CLAUDE_claude_3_5_sonnet_20240620.generateRandomToken(16);
        assertNotEquals(token1, token2, "Two tokens should not be identical");
    }
}
