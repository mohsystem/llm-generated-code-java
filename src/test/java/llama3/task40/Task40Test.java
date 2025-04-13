package llama3.task40;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task40Test {

    private String processForm(String csrfToken, String username, String email) {
        if (!"random_token_here".equals(csrfToken)) {
            return "CSRF token is invalid";
        }

        if (username == null || username.isBlank() || email == null || email.isBlank()) {
            return "Invalid input";
        }

        return "Settings updated successfully";
    }

    @Test
    public void testValidInput() {
        String result = processForm("random_token_here", "john_doe", "john@example.com");
        assertEquals("Settings updated successfully", result);
    }

    @Test
    public void testEmptyUsername() {
        String result = processForm("random_token_here", "", "john@example.com");
        assertEquals("Invalid input", result);
    }

    @Test
    public void testEmptyEmail() {
        String result = processForm("random_token_here", "john_doe", "");
        assertEquals("Invalid input", result);
    }

    @Test
    public void testEmptyUsernameAndEmail() {
        String result = processForm("random_token_here", "", "");
        assertEquals("Invalid input", result);
    }

    @Test
    public void testInvalidCsrfToken() {
        String result = processForm("wrong_token", "john_doe", "john@example.com");
        assertEquals("CSRF token is invalid", result);
    }
}
