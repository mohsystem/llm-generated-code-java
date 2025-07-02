package claude.task141;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task141Test {

    @Test
    void testBasicCase() {
        assertEquals("olleh", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString("hello"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString(""));
    }

    @Test
    void testSingleCharacter() {
        assertEquals("a", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString("a"));
    }

    @Test
    void testPalindromeString() {
        assertEquals("madam", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString("madam"));
    }

    @Test
    void testStringWithSpaces() {
        assertEquals("dlrow olleh", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString("hello world"));
    }

    @Test
    void testStringWithNumbers() {
        assertEquals("54321", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString("12345"));
    }

    @Test
    void testStringWithSpecialCharacters() {
        assertEquals(")(*&^%$#@!", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString("!@#$%^&*()"));
    }

    @Test
    void testStringWithMixedCase() {
        assertEquals("oLLeH", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString("HeLLo"));
    }

    @Test
    void testStringWithLeadingAndTrailingSpaces() {
        assertEquals("  olleh  ", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString("  hello  "));
    }

    @Test
    void testLongString() {
        assertEquals("zyxwvutsrqponmlkjihgfedcba", Task141_CLAUDE_claude_3_5_sonnet_20240620.reverseString("abcdefghijklmnopqrstuvwxyz"));
    }
}
