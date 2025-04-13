package gtp4o.task40;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task40Test {

    private static final String SESSION_CSRF = "aCSRFtoken";

     private String simulatePost(String sessionToken, String requestToken, String username) {
        if (sessionToken == null || requestToken == null || !sessionToken.equals(requestToken)) {
            return "403 FORBIDDEN: CSRF token is missing or incorrect";
        }

         if (username == null || username.trim().isEmpty()) {
            return "400 BAD REQUEST: Username is required";
        }

        return "Settings updated!";
    }

    @Test
    public void testValidCsrfAndUsername() {
        String result = simulatePost(SESSION_CSRF, "aCSRFtoken", "john_doe");
        assertEquals("Settings updated!", result);
    }

    @Test
    public void testMissingCsrfToken() {
        String result = simulatePost(SESSION_CSRF, null, "john_doe");
        assertEquals("403 FORBIDDEN: CSRF token is missing or incorrect", result);
    }

    @Test
    public void testInvalidCsrfToken() {
        String result = simulatePost(SESSION_CSRF, "wrong_token", "john_doe");
        assertEquals("403 FORBIDDEN: CSRF token is missing or incorrect", result);
    }

    @Test
    public void testEmptyUsername() {
        String result = simulatePost(SESSION_CSRF, "aCSRFtoken", "");
        assertEquals("400 BAD REQUEST: Username is required", result);
    }

    @Test
    public void testNullUsername() {
        String result = simulatePost(SESSION_CSRF, "aCSRFtoken", null);
        assertEquals("400 BAD REQUEST: Username is required", result);
    }
}
