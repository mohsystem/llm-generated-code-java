package gemini.task103;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task103Test {

    @Test
    void testShortPassword() {
        assertFalse(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("Ab1"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("abcdefgh1"));
    }

    @Test
    void testNoLowercase() {
        assertFalse(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("ABCDEF1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("Abcdefgh"));
    }

    @Test
    void testValidPassword() {
        assertTrue(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("Abcdefg1"));
    }

    @Test
    void testPasswordExactly8Chars() {
        assertTrue(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("A1bcdefg"));
    }

    @Test
    void testPasswordWithSpecialCharacters() {
        assertTrue(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("A1@bcdEf"));
    }

    @Test
    void testAllUppercase() {
        assertFalse(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("ABCDEFGHI"));
    }

    @Test
    void testAllLowercase() {
        assertFalse(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("abcdefgh"));
    }

    @Test
    void testPasswordWithSpaces() {
        assertTrue(Task103_GEMINI_gemini_1_5_pro_001.checkPasswordStrength("A1 bcdEf"));
    }
}
