package gtp4o.task138;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User admin;

    @BeforeEach
    void setUp() {
        admin = new User("admin");
    }

    @Test
    void testAddAndCheckPermissionSuccess() {
        admin.addPermission("read");
        assertTrue(admin.hasPermission("read"));

        admin.addPermission("write");
        assertTrue(admin.hasPermission("write"));
    }

    @Test
    void testCheckNonExistingPermission() {
        admin.addPermission("read");
        assertFalse(admin.hasPermission("delete"));
    }

    @Test
    void testDuplicatePermission() {
        admin.addPermission("read");
        admin.addPermission("read");
         assertTrue(admin.hasPermission("read"));
    }

    @Test
    void testEmptyPermissionsInitially() {
        assertFalse(admin.hasPermission("read"));
        assertFalse(admin.hasPermission("write"));
        assertFalse(admin.hasPermission("delete"));
    }
}
