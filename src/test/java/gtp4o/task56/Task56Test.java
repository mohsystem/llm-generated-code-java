package gtp4o.task56;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.security.SecureRandom;
import java.util.Base64;

public class Task56Test {

    private static String generateTokenFromJavaCode() {
        SecureRandom random = new SecureRandom();
        byte[] tokenBytes = new byte[16];
        random.nextBytes(tokenBytes);
        return Base64.getEncoder().encodeToString(tokenBytes);
    }

    @Test
    public void testTokenLengthIs32() {
        String token = generateTokenFromJavaCode();
        assertEquals(32, token.length(), "Token must be exactly 32 characters long (like the Python version)");
    }

    @Test
    public void testTokenContainsOnlyAlphaNumericCharacters() {
        String token = generateTokenFromJavaCode();
        assertTrue(token.matches("^[a-zA-Z0-9]+$"),
                "Token must contain only alphanumeric characters (a-z, A-Z, 0-9)");
    }

    @Test
    public void testTokenIsRandom() {
        String token1 = generateTokenFromJavaCode();
        String token2 = generateTokenFromJavaCode();
        assertNotEquals(token1, token2, "Two tokens should be different for randomness");
    }
}
