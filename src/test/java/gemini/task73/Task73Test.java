package gemini.task73;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task73Test {

    @Test
    public void test_valid_password() {
        // Should fail: Gemini does not check for special characters or admin word
        assertFalse(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("Valid1Password$2024"));
    }

    @Test
    public void test_too_short_password() {
        assertFalse(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("Short1$"));
    }

    @Test
    public void test_missing_uppercase() {
        assertFalse(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("validpassword1$"));
    }

    @Test
    public void test_missing_lowercase() {
        assertFalse(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("VALIDPASSWORD1$"));
    }

    @Test
    public void test_missing_digit() {
        assertFalse(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("ValidPassword$"));
    }

    @Test
    public void test_missing_special_char() {
        // Should pass (wrongly): Gemini doesn't check for special characters
        assertTrue(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("ValidPassword1"));
    }

    @Test
    public void test_contains_admin() {
        // Should pass (wrongly): Gemini doesn't reject "admin"
        assertTrue(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("Admin1234$"));
    }

    @Test
    public void test_valid_password_with_special_chars() {
        // Should fail: Gemini doesn't check for special chars
        assertFalse(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("Valid1Password@#"));
    }

    @Test
    public void test_contains_admin_case_insensitive() {
        // Should pass (wrongly): Gemini doesn't reject "admin"
        assertTrue(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("superadmin2024$"));
    }

    @Test
    public void test_valid_password_with_longer_length() {
        // Should fail: Gemini doesn't check for special chars
        assertFalse(Task73_GEMINI_gemini_1_5_pro_001.isPasswordValid("VeryLongValidPassword1$2024"));
    }
}
