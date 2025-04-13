package claude.task40;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task40Test {

    @Test
    public void testValidFormSubmission() {
        Settings settings = new Settings();
        settings.setUsername("john_doe");
        settings.setEmail("john@example.com");

        boolean isValid = !settings.getUsername().isEmpty() && !settings.getEmail().isEmpty();
        assertTrue(isValid, "Form should be valid when both fields are filled");
    }

    @Test
    public void testEmptyUsername() {
        Settings settings = new Settings();
        settings.setUsername("");
        settings.setEmail("john@example.com");

        boolean isValid = !settings.getUsername().isEmpty() && !settings.getEmail().isEmpty();
        assertFalse(isValid, "Form should be invalid when username is empty");
    }

    @Test
    public void testEmptyEmail() {
        Settings settings = new Settings();
        settings.setUsername("john_doe");
        settings.setEmail("");

        boolean isValid = !settings.getUsername().isEmpty() && !settings.getEmail().isEmpty();
        assertFalse(isValid, "Form should be invalid when email is empty");
    }

    @Test
    public void testEmptyUsernameAndEmail() {
        Settings settings = new Settings();
        settings.setUsername("");
        settings.setEmail("");

        boolean isValid = !settings.getUsername().isEmpty() && !settings.getEmail().isEmpty();
        assertFalse(isValid, "Form should be invalid when both fields are empty");
    }
}
