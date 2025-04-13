package claude.task41;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task41Test {

    @Test
    public void testNormalInput() {
        assertEquals("Processed input: Hello, world!", Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput("Hello, world!"));
    }

    @Test
    public void testInput100Chars() {
        String input = "a".repeat(100);
        assertEquals("Processed input: " + input, Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput(input));
    }

    @Test
    public void testInputLongerThan100Chars() {
        String input = "a".repeat(150);
        String expected = "a".repeat(100);
        assertEquals("Processed input: " + expected, Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput(input));
    }

    @Test
    public void testEmptyInput() {
        assertEquals("Processed input: ", Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput(""));
    }

    @Test
    public void testSpecialCharacters() {
        assertEquals("Processed input: @#$%^&*()", Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput("@#$%^&*()"));
    }

    @Test
    public void testNumericInput() {
        assertEquals("Processed input: 1234567890", Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput("1234567890"));
    }

    @Test
    public void testMixedAlphanumericInput() {
        assertEquals("Processed input: Hello123", Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput("Hello123"));
    }

    @Test
    public void testWhitespaceInput() {
        assertEquals("Processed input:      ", Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput("     "));
    }

    @Test
    public void testNewlineInput() {
        assertEquals("Processed input: Hello\nWorld", Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput("Hello\nWorld"));
    }

    @Test
    public void testLeadingTrailingSpaces() {
        assertEquals("Processed input:   Hello  ", Task41_CLAUDE_claude_3_5_sonnet_20240620.processInput("  Hello  "));
    }
}
