package gtp4o.task42;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task42Test {

    private UserAuth auth;

    @BeforeEach
    void setUp() {
        auth = new UserAuth();
    }

    @Test
    void testRegisterNewUser() throws Exception {
        auth.addUser("bob", "securepassword");
        assertTrue(auth.authenticate("bob", "securepassword"));
    }

    @Test
    void testRegisterExistingUser() throws Exception {
        auth.addUser("alice", "password123");
        auth.addUser("alice", "newpassword"); // override
        assertTrue(auth.authenticate("alice", "newpassword"));
        assertFalse(auth.authenticate("alice", "password123"));
    }

    @Test
    void testLoginSuccessful() throws Exception {
        auth.addUser("charlie", "mypassword");
        assertTrue(auth.authenticate("charlie", "mypassword"));
    }

    @Test
    void testLoginFailureIncorrectPassword() throws Exception {
        auth.addUser("david", "password");
        assertFalse(auth.authenticate("david", "wrongpassword"));
    }

    @Test
    void testLoginFailureNonExistentUser() throws Exception {
        assertFalse(auth.authenticate("nonexistent", "password"));
    }

    @Test
    void testMultipleUsers() throws Exception {
        auth.addUser("eve", "pass1");
        auth.addUser("frank", "pass2");
        assertTrue(auth.authenticate("eve", "pass1"));
        assertTrue(auth.authenticate("frank", "pass2"));
    }

    @Test
    void testHashConsistency() throws Exception {
        String hash1 = hash("password");
        String hash2 = hash("password");
        assertEquals(hash1, hash2); // No salt, should be same
    }

    @Test
    void testLoginWithAlteredStoredPassword() throws Exception {
        auth.addUser("grace", "password");
        auth.addUser("grace", "wrongpass"); // override
        assertFalse(auth.authenticate("grace", "password"));
    }

    @Test
    void testRegisterLoginEmptyPassword() throws Exception {
        auth.addUser("hank", "");
        assertTrue(auth.authenticate("hank", ""));
        assertFalse(auth.authenticate("hank", "wrongpassword"));
    }

    @Test
    void testLongPassword() throws Exception {
        String longPassword = "a".repeat(1000);
        auth.addUser("ida", longPassword);
        assertTrue(auth.authenticate("ida", longPassword));
        assertFalse(auth.authenticate("ida", "shortpassword"));
    }

    private String hash(String password) throws Exception {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) sb.append(String.format("%02x", b));
        return sb.toString();
    }
}
