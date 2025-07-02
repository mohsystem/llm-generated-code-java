package llama3.task136;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

class Task136Test {

    private Map<String, String> users;

    @BeforeEach
    void setUp() {
        users = new HashMap<>();
        users.put("admin", "password");
        users.put("user", "password");
    }

    private boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    @Test
    void testAuthenticateAdminSuccess() {
        assertTrue(authenticate("admin", "password"));
    }

    @Test
    void testAuthenticateUserSuccess() {
        assertTrue(authenticate("user", "password"));
    }

    @Test
    void testAuthenticateWrongPassword() {
        assertFalse(authenticate("admin", "wrongpassword"));
    }

    @Test
    void testAuthenticateWrongUsername() {
        assertFalse(authenticate("nonexistent", "password"));
    }

    @Test
    void testAuthenticateEmptyUsername() {
        assertFalse(authenticate("", "password"));
    }

    @Test
    void testAuthenticateEmptyPassword() {
        assertFalse(authenticate("admin", ""));
    }

    @Test
    void testAuthenticateEmptyBoth() {
        assertFalse(authenticate("", ""));
    }
}
