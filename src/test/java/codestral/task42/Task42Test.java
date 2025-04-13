package codestral.task42;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class Task42Test {

    @BeforeEach
    void resetUsers() {
        try {
            Field usersField = Task42_MISTRAL_codestral_latest.class.getDeclaredField("users");
            usersField.setAccessible(true);
            HashMap<String, String> users = (HashMap<String, String>) usersField.get(null);
            users.clear();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testRegisterNewUser() {
        assertTrue(register("bob", "securepassword"));
        assertTrue(getUsers().containsKey("bob"));
    }

    @Test
    void testRegisterExistingUser() {
        register("alice", "password123");
        assertFalse(register("alice", "newpassword"));
    }

    @Test
    void testLoginSuccessful() {
        register("charlie", "mypassword");
        assertTrue(login("charlie", "mypassword"));
    }

    @Test
    void testLoginFailureIncorrectPassword() {
        register("david", "password");
        assertFalse(login("david", "wrongpassword"));
    }

    @Test
    void testLoginFailureNonExistentUser() {
        assertFalse(login("nonexistent", "password"));
    }

    @Test
    void testMultipleUsers() {
        register("eve", "pass1");
        register("frank", "pass2");
        assertTrue(login("eve", "pass1"));
        assertTrue(login("frank", "pass2"));
    }

    @Test
    void testHashConsistency() {
         assertEquals("password", getUsers().put("test", "password"));
        assertEquals("password", getUsers().get("test"));
    }

    @Test
    void testLoginWithAlteredStoredPassword() {
        register("grace", "password");
        getUsers().put("grace", "wrongpass");
        assertFalse(login("grace", "password"));
    }

    @Test
    void testRegisterLoginEmptyPassword() {
        assertTrue(register("hank", ""));
        assertTrue(login("hank", ""));
        assertFalse(login("hank", "wrongpassword"));
    }

    @Test
    void testLongPassword() {
        String longPassword = "a".repeat(1000);
        assertTrue(register("ida", longPassword));
        assertTrue(login("ida", longPassword));
        assertFalse(login("ida", "shortpassword"));
    }

    // helper methods to simulate register/login for testing
    private boolean register(String username, String password) {
        if (getUsers().containsKey(username)) return false;
        getUsers().put(username, password);
        return true;
    }

    private boolean login(String username, String password) {
        return getUsers().containsKey(username) && getUsers().get(username).equals(password);
    }

    private HashMap<String, String> getUsers() {
        try {
            Field usersField = Task42_MISTRAL_codestral_latest.class.getDeclaredField("users");
            usersField.setAccessible(true);
            return (HashMap<String, String>) usersField.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
