package llama3.task138;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Task138Test {

    private Task138_PERPLEXITY_llama_3_sonar_large_32k_chat manager;

    @BeforeEach
    void setUp() {
        manager = new Task138_PERPLEXITY_llama_3_sonar_large_32k_chat();
    }

    @Test
    void testAddUserAndAuthenticateSuccess() {
        manager.addUser("alice", "1234", new String[]{"read", "write"});
        assertNotNull(manager.authenticate("alice", "1234"));
    }

    @Test
    void testAuthenticateWrongPassword() {
        manager.addUser("bob", "secure", new String[]{"read"});
        assertNull(manager.authenticate("bob", "wrongpassword"));
    }

    @Test
    void testAuthenticateNonExistentUser() {
        assertNull(manager.authenticate("nonexistent", "password"));
    }

    @Test
    void testCheckPrivilegeSuccess() {
        manager.addUser("charlie", "pass", new String[]{"read", "write"});
        assertTrue(manager.checkPrivilege("charlie", "pass", "write"));
    }

    @Test
    void testCheckPrivilegeFail() {
        manager.addUser("david", "pass123", new String[]{"read"});
        assertFalse(manager.checkPrivilege("david", "pass123", "execute"));
    }

    @Test
    void testCheckPrivilegeWithWrongPassword() {
        manager.addUser("eve", "secret", new String[]{"read", "write"});
        assertFalse(manager.checkPrivilege("eve", "wrongsecret", "read"));
    }

    @Test
    void testMultipleUsers() {
        manager.addUser("admin", "adminpass", new String[]{"read", "write", "execute"});
        manager.addUser("guest", "guestpass", new String[]{"read"});

        assertTrue(manager.checkPrivilege("admin", "adminpass", "execute"));
        assertFalse(manager.checkPrivilege("guest", "guestpass", "execute"));
    }
}
