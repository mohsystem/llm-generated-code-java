package gemini.task56;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task56Test {

    @Test
    public void testTokenLengthIs32() {
        String token = Task56_GEMINI_gemini_1_5_pro_001.generateToken(32);
        assertEquals(32, token.length(), "Token must be exactly 32 characters long");
    }

    @Test
    public void testTokenIsAlphanumericOnly() {
        String token = Task56_GEMINI_gemini_1_5_pro_001.generateToken(32);
        assertTrue(token.matches("^[a-zA-Z0-9]+$"), "Token must contain only a-z, A-Z, 0-9 characters");
    }

    @Test
    public void testTokenRandomness() {
        String token1 = Task56_GEMINI_gemini_1_5_pro_001.generateToken(32);
        String token2 = Task56_GEMINI_gemini_1_5_pro_001.generateToken(32);
        assertNotEquals(token1, token2, "Two tokens generated consecutively should not be equal");
    }
}
