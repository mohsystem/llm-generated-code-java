package codestral.task41;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task41Test {

    @Test
    public void testNormalInput() {
        assertEquals("Processed string: Hello, world!", Task41_MISTRAL_codestral_latest.processString("Hello, world!"));
    }

    @Test
    public void testInput100Chars() {
        String input = "a".repeat(100);
        assertEquals("Processed string: " + input, Task41_MISTRAL_codestral_latest.processString(input));
    }

    @Test
    public void testInputLongerThan100Chars() {
        String input = "a".repeat(150);
        String expected = input.substring(0, 100);
        assertEquals("Processed string: " + expected, Task41_MISTRAL_codestral_latest.processString(expected));
    }

    @Test
    public void testEmptyInput() {
        assertEquals("Processed string: ", Task41_MISTRAL_codestral_latest.processString(""));
    }

    @Test
    public void testSpecialCharacters() {
        assertEquals("Processed string: @#$%^&*()", Task41_MISTRAL_codestral_latest.processString("@#$%^&*()"));
    }

    @Test
    public void testNumericInput() {
        assertEquals("Processed string: 1234567890", Task41_MISTRAL_codestral_latest.processString("1234567890"));
    }

    @Test
    public void testMixedAlphanumericInput() {
        assertEquals("Processed string: Hello123", Task41_MISTRAL_codestral_latest.processString("Hello123"));
    }

    @Test
    public void testWhitespaceInput() {
        assertEquals("Processed string:      ", Task41_MISTRAL_codestral_latest.processString("     "));
    }

    @Test
    public void testNewlineInput() {
        assertEquals("Processed string: Hello\nWorld", Task41_MISTRAL_codestral_latest.processString("Hello\nWorld"));
    }

    @Test
    public void testLeadingTrailingSpaces() {
        assertEquals("Processed string:   Hello  ", Task41_MISTRAL_codestral_latest.processString("  Hello  "));
    }
}
