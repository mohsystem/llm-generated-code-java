package claude.task24;

import org.junit.jupiter.api.Test;
import static claude.task24.Task24_CLAUDE_claude_3_5_sonnet_20240620.validatePin;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Task24_TestCase {

    @Test
    void testValid4DigitPIN() {
        assertTrue(validatePin("1234"));
    }

    @Test
    void testValid6DigitPIN() {
        assertTrue(validatePin("123456"));
    }

    @Test
    void testInvalidLengthPINTooShort() {
        assertFalse(validatePin("123"));
    }

    @Test
    void testInvalidLengthPINTooLong() {
        assertFalse(validatePin("1234567"));
    }

    @Test
    void testInvalidPINWithLetters() {
        assertFalse(validatePin("a234"));
    }

    @Test
    void testInvalidPINWithSpecialCharacters() {
        assertFalse(validatePin("12@4"));
    }

    @Test
    void testValid6DigitPINWithLeadingZeros() {
        assertTrue(validatePin("000123"));
    }

    @Test
    void testValid4DigitPINWithLeadingZeros() {
        assertTrue(validatePin("0001"));
    }

    @Test
    void testInvalidPINWithSpaces() {
        assertFalse(validatePin("12 34"));
    }

    @Test
    void testEmptyPIN() {
        assertFalse(validatePin(""));
    }
}
