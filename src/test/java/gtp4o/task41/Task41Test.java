package gtp4o.task41;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task41Test {

    @Test
    public void testNormalInput() {
        assertEquals("Processed input: Hello, world!", Task41_OPENAI_gpt_4o.processInput("Hello, world!"));
    }

    @Test
    public void testInput100Chars() {
        String input = "a".repeat(100);
        assertEquals("Processed input: " + input, Task41_OPENAI_gpt_4o.processInput(input));
    }

    @Test
    public void testInputLongerThan100Chars() {
        String input = "a".repeat(150);
        String expected = "Processed input: " + input.substring(0, 100);
        assertEquals(expected, Task41_OPENAI_gpt_4o.processInput(input));
    }

    @Test
    public void testEmptyInput() {
        assertEquals("Processed input: ", Task41_OPENAI_gpt_4o.processInput(""));
    }

    @Test
    public void testInputSpecialChars() {
        assertEquals("Processed input: @#$%^&*()", Task41_OPENAI_gpt_4o.processInput("@#$%^&*()"));
    }

    @Test
    public void testNumericInput() {
        assertEquals("Processed input: 1234567890", Task41_OPENAI_gpt_4o.processInput("1234567890"));
    }

    @Test
    public void testMixedInput() {
        assertEquals("Processed input: Hello123", Task41_OPENAI_gpt_4o.processInput("Hello123"));
    }

    @Test
    public void testWhitespaceInput() {
        assertEquals("Processed input:      ", Task41_OPENAI_gpt_4o.processInput("     "));
    }

    @Test
    public void testNewlineInput() {
        assertEquals("Processed input: Hello\nWorld", Task41_OPENAI_gpt_4o.processInput("Hello\nWorld"));
    }

    @Test
    public void testLeadingTrailingSpaces() {
        assertEquals("Processed input:   Hello  ", Task41_OPENAI_gpt_4o.processInput("  Hello  "));
    }
}
