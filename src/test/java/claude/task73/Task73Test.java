package claude.task73;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task73Test {

    @Test
    public void test_valid_password() {
        assertTrue(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("Valid1Password$2024"));
    }

    @Test
    public void test_too_short_password() {
        assertFalse(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("Short1$"));
    }

    @Test
    public void test_missing_uppercase() {
        assertFalse(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("validpassword1$"));
    }

    @Test
    public void test_missing_lowercase() {
        assertFalse(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("VALIDPASSWORD1$"));
    }

    @Test
    public void test_missing_digit() {
        assertFalse(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("ValidPassword$"));
    }

    @Test
    public void test_missing_special_char() {
        assertFalse(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("ValidPassword1"));
    }

    @Test
    public void test_contains_admin() {
        assertFalse(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("Admin1234$"));
    }

    @Test
    public void test_valid_password_with_special_chars() {
        assertTrue(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("Valid1Password@#"));
    }

    @Test
    public void test_contains_admin_case_insensitive() {
        assertFalse(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("superadmin2024$"));
    }

    @Test
    public void test_valid_password_with_longer_length() {
        assertTrue(Task73_CLAUDE_claude_3_5_sonnet_20240620.isValidAdminPassword("VeryLongValidPassword1$2024"));
    }
}
