package claude.task42;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class Task42Test {

    @BeforeEach
    void clearUsers() {
        // Reset the users map using reflection safely
        try {
            var usersField = Task42_CLAUDE_claude_3_5_sonnet_20240620.class.getDeclaredField("users");
            usersField.setAccessible(true);
            Map<String, byte[]> usersMap = (Map<String, byte[]>) usersField.get(null);
            usersMap.clear();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testRegisterNewUser() throws NoSuchAlgorithmException {
        assertTrue(Task42_CLAUDE_claude_3_5_sonnet_20240620.register("bob", "securepassword"));

        // Verify that the user is stored
        var users = getUsers();
        assertTrue(users.containsKey("bob"));
    }

    @Test
    void testRegisterExistingUser() throws NoSuchAlgorithmException {
        Task42_CLAUDE_claude_3_5_sonnet_20240620.register("alice", "password123");
        assertFalse(Task42_CLAUDE_claude_3_5_sonnet_20240620.register("alice", "newpassword"));
    }

    @Test
    void testLoginSuccessful() throws NoSuchAlgorithmException {
        Task42_CLAUDE_claude_3_5_sonnet_20240620.register("charlie", "mypassword");
        assertTrue(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("charlie", "mypassword"));
    }

    @Test
    void testLoginFailureIncorrectPassword() throws NoSuchAlgorithmException {
        Task42_CLAUDE_claude_3_5_sonnet_20240620.register("david", "password");
        assertFalse(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("david", "wrongpassword"));
    }

    @Test
    void testLoginFailureNonExistentUser() throws NoSuchAlgorithmException {
        assertFalse(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("nonexistent", "password"));
    }

    @Test
    void testMultipleUsers() throws NoSuchAlgorithmException {
        Task42_CLAUDE_claude_3_5_sonnet_20240620.register("eve", "pass1");
        Task42_CLAUDE_claude_3_5_sonnet_20240620.register("frank", "pass2");
        assertTrue(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("eve", "pass1"));
        assertTrue(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("frank", "pass2"));
    }

    @Test
    void testHashConsistencyAndSalted() throws NoSuchAlgorithmException {
        Task42_CLAUDE_claude_3_5_sonnet_20240620.register("susan", "password");
        byte[] hash1 = getUsers().get("susan");

        // Remove and re-register same user with same password
        getUsers().remove("susan");
        Task42_CLAUDE_claude_3_5_sonnet_20240620.register("susan", "password");
        byte[] hash2 = getUsers().get("susan");

        // Hashes should be different due to salt
        assertNotEquals(new String(hash1), new String(hash2));

        // Verify password still works
        assertTrue(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("susan", "password"));
    }

    @Test
    void testLoginWithAlteredStoredPassword() throws Exception {
        Task42_CLAUDE_claude_3_5_sonnet_20240620.register("grace", "password");

        byte[] fakeHash = Task42_CLAUDE_claude_3_5_sonnet_20240620.register("temp", "different")
                ? getUsers().get("temp") : new byte[0];

        getUsers().put("grace", fakeHash);
        assertFalse(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("grace", "password"));
    }

    @Test
    void testRegisterLoginEmptyPassword() throws NoSuchAlgorithmException {
        assertTrue(Task42_CLAUDE_claude_3_5_sonnet_20240620.register("hank", ""));
        assertTrue(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("hank", ""));
        assertFalse(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("hank", "wrongpassword"));
    }

    @Test
    void testLongPassword() throws NoSuchAlgorithmException {
        String longPassword = "a".repeat(1000);
        assertTrue(Task42_CLAUDE_claude_3_5_sonnet_20240620.register("ida", longPassword));
        assertTrue(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("ida", longPassword));
        assertFalse(Task42_CLAUDE_claude_3_5_sonnet_20240620.login("ida", "shortpassword"));
    }

    // helper to get users map
    private Map<String, byte[]> getUsers() {
        try {
            var field = Task42_CLAUDE_claude_3_5_sonnet_20240620.class.getDeclaredField("users");
            field.setAccessible(true);
            return (Map<String, byte[]>) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
