package gtp4o.task109;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

public class Task109Test {

    // Method that returns the same output as the main program
    public String validate(String input) {
        return Pattern.matches("^[a-zA-Z0-9_]+$", input) ? "Valid input" : "Invalid input";
    }

    // ✅ Valid inputs
    @Test
    public void testValidSimple() {
        assertEquals("Valid input", validate("Hello123"));
    }

    @Test
    public void testValidWithUnderscore() {
        assertEquals("Valid input", validate("User_2025"));
    }

    @Test
    public void testValidNumbersOnly() {
        assertEquals("Valid input", validate("123456"));
    }

    @Test
    public void testValidLettersOnly() {
        assertEquals("Valid input", validate("AlphaBeta"));
    }

    // ❌ Invalid inputs
    @Test
    public void testInvalidWithDash() {
        assertEquals("Invalid input", validate("user-name"));
    }

    @Test
    public void testInvalidWithDot() {
        assertEquals("Invalid input", validate("user.name"));
    }

    @Test
    public void testInvalidWithSpace() {
        assertEquals("Invalid input", validate("user name"));
    }

    @Test
    public void testInvalidWithSymbol() {
        assertEquals("Invalid input", validate("user@domain"));
    }

    @Test
    public void testInvalidEmptyString() {
        assertEquals("Invalid input", validate(""));
    }
}
