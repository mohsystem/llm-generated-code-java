package claude.task56;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task56Test {

    @Test
    public void testGeneratedTokenLengthIs32() {
        String token = Task56_CLAUDE_claude_3_5_sonnet_20240620.generateToken();
        assertEquals(32, token.length(), "Token length must be exactly 32 characters");
    }

    @Test
    public void testTokenContainsOnlyAlphaNumericCharacters() {
        String token = Task56_CLAUDE_claude_3_5_sonnet_20240620.generateToken();
        assertTrue(token.matches("^[a-zA-Z0-9]+$"), "Token must contain only alphanumeric characters (a-z, A-Z, 0-9)");
    }

    @Test
    public void testTokenIsRandomEnough() {
        String token1 = Task56_CLAUDE_claude_3_5_sonnet_20240620.generateToken();
        String token2 = Task56_CLAUDE_claude_3_5_sonnet_20240620.generateToken();
        assertNotEquals(token1, token2, "Two tokens generated consecutively should not be equal (high randomness)");
    }
}
