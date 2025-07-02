package gemini.task109;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task109Test {

     public String validate(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches() ? "Valid email address" : "Invalid email address";
    }

    // ✅ Valid Emails
    @Test
    public void testValidEmailStandard() {
        assertEquals("Valid email address", validate("test@example.com"));
    }

    @Test
    public void testValidEmailWithDots() {
        assertEquals("Valid email address", validate("user.name@domain.com"));
    }

    @Test
    public void testValidEmailWithPlus() {
        assertEquals("Valid email address", validate("user+tag@domain.org"));
    }

    @Test
    public void testValidEmailWithSubdomain() {
        assertEquals("Valid email address", validate("user@sub.domain.co.uk"));
    }

    // ❌ Invalid Emails
    @Test
    public void testInvalidEmailMissingAt() {
        assertEquals("Invalid email address", validate("username.domain.com"));
    }

    @Test
    public void testInvalidEmailDoubleAt() {
        assertEquals("Invalid email address", validate("user@@domain.com"));
    }

    @Test
    public void testInvalidEmailEndingDot() {
        assertEquals("Invalid email address", validate("user@domain."));
    }

    @Test
    public void testInvalidEmailNoDomain() {
        assertEquals("Invalid email address", validate("user@"));
    }

    @Test
    public void testInvalidEmailEmpty() {
        assertEquals("Invalid email address", validate(""));
    }
}
