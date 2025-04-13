package llama3.task42;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task42Test {

    private List<User> users;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
    }

    @Test
    void testRegisterNewUser() {
        assertTrue(register("bob", "securepassword"));
        assertTrue(authenticate("bob", "securepassword"));
    }

    @Test
    void testRegisterExistingUser() {
        assertTrue(register("alice", "password123"));
        assertFalse(register("alice", "newpassword"));
    }

    @Test
    void testLoginSuccessful() {
        register("charlie", "mypassword");
        assertTrue(authenticate("charlie", "mypassword"));
    }

    @Test
    void testLoginFailureIncorrectPassword() {
        register("david", "password");
        assertFalse(authenticate("david", "wrongpassword"));
    }

    @Test
    void testLoginFailureNonExistentUser() {
        assertFalse(authenticate("nonexistent", "password"));
    }

    @Test
    void testMultipleUsers() {
        register("eve", "pass1");
        register("frank", "pass2");
        assertTrue(authenticate("eve", "pass1"));
        assertTrue(authenticate("frank", "pass2"));
    }

    @Test
    void testHashConsistency() {
         register("same", "password");
        register("same2", "password");
        assertTrue(authenticate("same", "password"));
        assertTrue(authenticate("same2", "password"));
    }

    @Test
    void testLoginWithAlteredStoredPassword() {
        register("grace", "password");
        changePassword("grace", "wrongpass");
        assertFalse(authenticate("grace", "password"));
    }

    @Test
    void testRegisterLoginEmptyPassword() {
        assertTrue(register("hank", ""));
        assertTrue(authenticate("hank", ""));
        assertFalse(authenticate("hank", "wrongpassword"));
    }

    @Test
    void testLongPassword() {
        String longPassword = "a".repeat(1000);
        assertTrue(register("ida", longPassword));
        assertTrue(authenticate("ida", longPassword));
        assertFalse(authenticate("ida", "shortpassword"));
    }

    // ======== Helper methods ========

    private boolean register(String username, String password) {
        for (User user : users) {
            if (user.authenticate(username, password) || user.authenticate(username, "")) {
                return false;
            }
        }
        users.add(new User(username, password));
        return true;
    }

    private boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.authenticate(username, password)) {
                return true;
            }
        }
        return false;
    }

    private void changePassword(String username, String newPassword) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.authenticate(username, user.authenticate(username, "") ? "" : "dummy")) {
                users.set(i, new User(username, newPassword));
                return;
            }
        }
    }
}
