package llama3.task109;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

public class Task109Test {

    public String validate(String input) {
        return Pattern.matches("^[a-zA-Z0-9_]{3,16}$", input)
                ? "Valid username"
                : "Invalid username";
    }

    // ✅ Valid usernames
    @Test
    public void testValidUsernameSimple() {
        assertEquals("Valid username", validate("User123"));
    }

    @Test
    public void testValidUsernameWithUnderscore() {
        assertEquals("Valid username", validate("user_name"));
    }

    @Test
    public void testValidUsernameMinLength() {
        assertEquals("Valid username", validate("abc"));
    }

    @Test
    public void testValidUsernameMaxLength() {
        assertEquals("Valid username", validate("abcdefghijklmnop")); // 16 chars
    }

    // ❌ Invalid usernames
    @Test
    public void testInvalidUsernameTooShort() {
        assertEquals("Invalid username", validate("ab")); // < 3
    }

    @Test
    public void testInvalidUsernameTooLong() {
        assertEquals("Invalid username", validate("abcdefghijklmnopq")); // 17 chars
    }

    @Test
    public void testInvalidUsernameWithDash() {
        assertEquals("Invalid username", validate("user-name"));
    }

    @Test
    public void testInvalidUsernameWithDot() {
        assertEquals("Invalid username", validate("user.name"));
    }

    @Test
    public void testInvalidUsernameWithSpace() {
        assertEquals("Invalid username", validate("user name"));
    }

    @Test
    public void testInvalidUsernameWithSpecialChar() {
        assertEquals("Invalid username", validate("user@name"));
    }

    @Test
    public void testInvalidUsernameEmpty() {
        assertEquals("Invalid username", validate(""));
    }
}
