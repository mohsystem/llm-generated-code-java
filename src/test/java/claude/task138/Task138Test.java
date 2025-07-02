package claude.task138;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

class Task138Test {

    private PermissionManager pm;

    @BeforeEach
    void setUp() {
        pm = new PermissionManager();
    }

    @Test
    void testAddUserAndCheckPermission() {
        pm.addUser("alice", "admin");
        pm.addUser("bob", "editor");
        pm.addUser("charlie", "viewer");

        assertTrue(pm.checkPermission("alice", "manage_users"));
        assertTrue(pm.checkPermission("bob", "write"));
        assertFalse(pm.checkPermission("charlie", "delete"));
    }

    @Test
    void testChangeUserRole() {
        pm.addUser("bob", "editor");
        pm.changeUserRole("bob", "admin");

        assertTrue(pm.checkPermission("bob", "manage_users"));
    }

    @Test
    void testRemoveUser() {
        pm.addUser("charlie", "viewer");
        pm.removeUser("charlie");

        assertFalse(pm.checkPermission("charlie", "read"));
    }

    @Test
    void testSaveAndLoadFromFile() throws IOException {
        pm.addUser("alice", "admin");
        pm.addUser("bob", "editor");

        File tempFile = File.createTempFile("permissions", ".txt");
        tempFile.deleteOnExit(); // clean up file after tests

        pm.saveToFile(tempFile.getAbsolutePath());

        PermissionManager pmLoaded = new PermissionManager();
        pmLoaded.loadFromFile(tempFile.getAbsolutePath());

        assertTrue(pmLoaded.checkPermission("alice", "manage_users"));
        assertTrue(pmLoaded.checkPermission("bob", "write"));
        assertFalse(pmLoaded.checkPermission("bob", "delete"));
    }

    @Test
    void testInvalidRoleAddUser() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pm.addUser("david", "invalid_role");
        });
        assertEquals("Invalid role", exception.getMessage());
    }

    @Test
    void testInvalidRoleChangeUserRole() {
        pm.addUser("eve", "viewer");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pm.changeUserRole("eve", "invalid_role");
        });
        assertEquals("Invalid role", exception.getMessage());
    }

    @Test
    void testChangeRoleForNonExistentUser() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pm.changeUserRole("nonexistent", "admin");
        });
        assertEquals("User not found", exception.getMessage());
    }
}
