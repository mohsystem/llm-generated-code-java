package codestral.task103;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task103Test {

    @Test
    void testShortPassword() {
        assertFalse(Task103_MISTRAL_codestral_latest.checkPasswordStrength("Ab1"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(Task103_MISTRAL_codestral_latest.checkPasswordStrength("abcdefgh1"));
    }

    @Test
    void testNoLowercase() {
        assertFalse(Task103_MISTRAL_codestral_latest.checkPasswordStrength("ABCDEF1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(Task103_MISTRAL_codestral_latest.checkPasswordStrength("Abcdefgh"));
    }

    @Test
    void testValidPassword() {
        assertTrue(Task103_MISTRAL_codestral_latest.checkPasswordStrength("Abcdefg1"));
    }

    @Test
    void testPasswordExactly8Chars() {
        assertTrue(Task103_MISTRAL_codestral_latest.checkPasswordStrength("A1bcdefg"));
    }

    @Test
    void testPasswordWithSpecialCharacters() {
        assertTrue(Task103_MISTRAL_codestral_latest.checkPasswordStrength("A1@bcdEf"));
    }

    @Test
    void testAllUppercase() {
        assertFalse(Task103_MISTRAL_codestral_latest.checkPasswordStrength("ABCDEFGHI"));
    }

    @Test
    void testAllLowercase() {
        assertFalse(Task103_MISTRAL_codestral_latest.checkPasswordStrength("abcdefgh"));
    }

    @Test
    void testPasswordWithSpaces() {
        assertTrue(Task103_MISTRAL_codestral_latest.checkPasswordStrength("A1 bcdEf"));
    }
}
