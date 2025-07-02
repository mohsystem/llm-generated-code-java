package codestral.task109;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Task109Test {

    // Wrapper for direct test
    public String validate(String input) {
        return Task109_MISTRAL_codestral_latest.validateInput(input) ? "Input is valid" : "Input is invalid";
    }

    // Valid inputs
    @Test
    public void testValidInputSimple() {
        assertEquals("Input is valid", validate("ValidInput123"));
    }

    @Test
    public void testValidInputWithUnderscore() {
        assertEquals("Input is valid", validate("user_name_2025"));
    }

    @Test
    public void testValidInputAllDigits() {
        assertEquals("Input is valid", validate("1234567890"));
    }

    @Test
    public void testValidInputAllLetters() {
        assertEquals("Input is valid", validate("JustLetters"));
    }

    // Invalid inputs
    @Test
    public void testInvalidInputWithSpace() {
        assertEquals("Input is invalid", validate("invalid input"));
    }

    @Test
    public void testInvalidInputWithSymbol() {
        assertEquals("Input is invalid", validate("invalid@input"));
    }

    @Test
    public void testInvalidInputWithDash() {
        assertEquals("Input is invalid", validate("user-name"));
    }

    @Test
    public void testInvalidInputWithDot() {
        assertEquals("Input is invalid", validate("username.test"));
    }

    @Test
    public void testEmptyInput() {
        assertEquals("Input is invalid", validate(""));
    }
}
