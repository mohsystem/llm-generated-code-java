package claude.task103;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task103Test {

    @Test
    void testShortPassword() {
        assertFalse(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("Ab1"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("abcdefgh1"));
    }

    @Test
    void testNoLowercase() {
        assertFalse(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("ABCDEF1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("Abcdefgh"));
    }

    @Test
    void testValidPassword() {
        assertTrue(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("Abcdefg1"));
    }

    @Test
    void testPasswordExactly8Chars() {
        assertTrue(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("A1bcdefg"));
    }

    @Test
    void testPasswordWithSpecialCharacters() {
        assertTrue(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("A1@bcdEf"));
    }

    @Test
    void testAllUppercase() {
        assertFalse(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("ABCDEFGHI"));
    }

    @Test
    void testAllLowercase() {
        assertFalse(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("abcdefgh"));
    }

    @Test
    void testPasswordWithSpaces() {
        assertTrue(Task103_CLAUDE_claude_3_5_sonnet_20240620.checkPasswordStrength("A1 bcdEf"));
    }
}
