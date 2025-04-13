package codestral.task40;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task40Test {

    private String updateSettings(String setting, String csrfToken) {
        if (setting == null || csrfToken == null) return "invalid input";

        String[] parts = setting.split(":");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return "invalid setting";
        }

        // Simulate CSRF validation (just check if token is non-empty)
        if (csrfToken.isEmpty()) return "invalid CSRF";

        return "Settings updated";
    }

    @Test
    public void testValidSetting() {
        String result = updateSettings("john_doe:john@example.com", "secureToken");
        assertEquals("Settings updated", result);
    }

    @Test
    public void testMissingUsername() {
        String result = updateSettings(":john@example.com", "secureToken");
        assertEquals("invalid setting", result);
    }

    @Test
    public void testMissingEmail() {
        String result = updateSettings("john_doe:", "secureToken");
        assertEquals("invalid setting", result);
    }

    @Test
    public void testMissingBoth() {
        String result = updateSettings(":", "secureToken");
        assertEquals("invalid setting", result);
    }

    @Test
    public void testEmptyCsrf() {
        String result = updateSettings("john_doe:john@example.com", "");
        assertEquals("invalid CSRF", result);
    }

    @Test
    public void testNullInputs() {
        String result = updateSettings(null, null);
        assertEquals("invalid input", result);
    }
}
