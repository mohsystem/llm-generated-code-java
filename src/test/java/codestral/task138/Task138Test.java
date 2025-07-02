package codestral.task138;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class Task138Test {

    private Task138_MISTRAL_codestral_latest user;

    @BeforeEach
    void setUp() {
        user = new Task138_MISTRAL_codestral_latest("John", Arrays.asList("read", "write"));
    }

    @Test
    void testHasPermissionSuccess() {
        assertTrue(user.hasPermission("read"));
        assertTrue(user.hasPermission("write"));
    }

    @Test
    void testHasPermissionFail() {
        assertFalse(user.hasPermission("execute"));
        assertFalse(user.hasPermission("delete"));
    }

    @Test
    void testHasPermissionEmptyList() {
        Task138_MISTRAL_codestral_latest emptyUser = new Task138_MISTRAL_codestral_latest("Empty", Arrays.asList());
        assertFalse(emptyUser.hasPermission("read"));
    }

    @Test
    void testHasPermissionCaseSensitivity() {
        assertFalse(user.hasPermission("Read"));  // case-sensitive check
    }

    @Test
    void testMultiplePermissions() {
        Task138_MISTRAL_codestral_latest multiUser = new Task138_MISTRAL_codestral_latest(
                "MultiUser", Arrays.asList("read", "write", "delete", "manage_users")
        );
        assertTrue(multiUser.hasPermission("manage_users"));
        assertTrue(multiUser.hasPermission("delete"));
        assertFalse(multiUser.hasPermission("execute"));
    }
}
