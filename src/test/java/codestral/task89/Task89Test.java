package codestral.task89;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task89Test {

    @Test
    void testExactMatch() {
        assertTrue("secure123".equals("secure123"));
    }

    @Test
    void testDifferentLength() {
        assertFalse("secure123".equals("secure12"));
    }

    @Test
    void testOneCharacterMismatch() {
        assertFalse("secure123".equals("secure124"));
    }

    @Test
    void testCompletelyDifferent() {
        assertFalse("password".equals("12345678"));
    }

    @Test
    void testEmptyPasswordMatch() {
        assertTrue("".equals(""));
    }

    @Test
    void testEmptyStoredPassword() {
        assertFalse("".equals("abc"));
    }

    @Test
    void testEmptyEnteredPassword() {
        assertFalse("abc".equals(""));
    }
}
