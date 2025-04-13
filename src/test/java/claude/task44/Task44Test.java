package claude.task44;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task44Test {

    @Test
    void testValidInput() {
        assertTrue(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("Hello World"));
        assertTrue(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("12345"));
        assertTrue(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("A1 B2 C3"));
    }

    @Test
    void testInvalidInputSpecialCharacters() {
        assertFalse(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("Hello@World"));
        assertFalse(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("12345!"));
        assertFalse(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("A1 B2 C3?"));
    }

    @Test
    void testEmptyInput() {
        assertTrue(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput(""));
        assertEquals("", Task44_CLAUDE_claude_3_5_sonnet_20240620.processInput(""));
    }

    @Test
    void testInputWithLeadingAndTrailingSpaces() {
        String input = "  Hello World  ";
        assertTrue(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput(input));
        assertEquals("  HELLO WORLD  ", Task44_CLAUDE_claude_3_5_sonnet_20240620.processInput(input));
    }

    @Test
    void testNumericInput() {
        String input = "12345";
        assertTrue(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput(input));
        assertEquals("12345", Task44_CLAUDE_claude_3_5_sonnet_20240620.processInput(input));
    }

    @Test
    void testMixedInput() {
        String input = "abc 123";
        assertTrue(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput(input));
        assertEquals("ABC 123", Task44_CLAUDE_claude_3_5_sonnet_20240620.processInput(input));
    }

    @Test
    void testInvalidInputWithNewlines() {
        assertFalse(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("Hello\nWorld"));
        assertFalse(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("123\n456"));
    }

    @Test
    void testInputWithTabs() {
        assertFalse(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("Hello\tWorld"));
        assertFalse(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput("123\t456"));
    }

    @Test
    void testAllValidCharacters() {
        String input = "Valid input 123";
        assertTrue(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput(input));
        assertEquals("VALID INPUT 123", Task44_CLAUDE_claude_3_5_sonnet_20240620.processInput(input));
    }

    @Test
    void testLongInput() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("a");
        }
        String input = sb.toString();
        assertTrue(Task44_CLAUDE_claude_3_5_sonnet_20240620.validateInput(input));
        assertEquals(input.toUpperCase(), Task44_CLAUDE_claude_3_5_sonnet_20240620.processInput(input));
    }
}
