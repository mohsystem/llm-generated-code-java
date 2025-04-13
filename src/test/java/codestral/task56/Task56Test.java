package codestral.task56;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task56Test {

    @Test
    public void testTokenLengthIsExactly32() throws Exception {
        String token = Task56_MISTRAL_codestral_latest.generateToken("admin", "password");
        assertEquals(32, token.length(), "Token must be exactly 32 characters long");
    }

    @Test
    public void testTokenContainsOnlyAlphaNumericCharacters() throws Exception {
        String token = Task56_MISTRAL_codestral_latest.generateToken("admin", "password");
        assertTrue(token.matches("^[a-zA-Z0-9]+$"), "Token must contain only alphanumeric characters (a-z, A-Z, 0-9)");
    }

    @Test
    public void testTokenIsRandomEachTime() throws Exception {
        String token1 = Task56_MISTRAL_codestral_latest.generateToken("admin", "password");
        Thread.sleep(5); // wait few ms to ensure timestamp differs
        String token2 = Task56_MISTRAL_codestral_latest.generateToken("admin", "password");
        assertNotEquals(token1, token2, "Two consecutive tokens must differ (high randomness)");
    }
}
