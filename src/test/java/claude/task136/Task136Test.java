package claude.task136;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Task136Test {

    @BeforeEach
    void resetUsers() throws Exception {
        // Reset users map using reflection because it's private static
        var usersField = Task136_CLAUDE_claude_3_5_sonnet_20240620.class.getDeclaredField("users");
        usersField.setAccessible(true);
        ((java.util.Map<?, ?>) usersField.get(null)).clear();
    }

    @Test
    void testRegisterSuccess() {
        assertTrue(Task136_CLAUDE_claude_3_5_sonnet_20240620.register("user1", "password1"));
    }

    @Test
    void testRegisterDuplicate() {
        Task136_CLAUDE_claude_3_5_sonnet_20240620.register("user1", "password1");
        assertFalse(Task136_CLAUDE_claude_3_5_sonnet_20240620.register("user1", "anotherpassword"));
    }

    @Test
    void testLoginSuccess() {
        Task136_CLAUDE_claude_3_5_sonnet_20240620.register("user2", "mypassword");
        assertTrue(Task136_CLAUDE_claude_3_5_sonnet_20240620.login("user2", "mypassword"));
    }

    @Test
    void testLoginWrongPassword() {
        Task136_CLAUDE_claude_3_5_sonnet_20240620.register("user3", "correctpassword");
        assertFalse(Task136_CLAUDE_claude_3_5_sonnet_20240620.login("user3", "wrongpassword"));
    }

    @Test
    void testLoginNonexistentUser() {
        assertFalse(Task136_CLAUDE_claude_3_5_sonnet_20240620.login("ghostuser", "anyPassword"));
    }
}
