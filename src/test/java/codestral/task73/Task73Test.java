package codestral.task73;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task73Test {

    @Test
    public void test_valid_password() {
        assertTrue(Task73_MISTRAL_codestral_latest.isValidPassword("Valid1Password$2024"));
    }

    @Test
    public void test_too_short_password() {
        assertFalse(Task73_MISTRAL_codestral_latest.isValidPassword("Short1$"));
    }

    @Test
    public void test_missing_uppercase() {
        assertFalse(Task73_MISTRAL_codestral_latest.isValidPassword("validpassword1$"));
    }

    @Test
    public void test_missing_lowercase() {
        assertFalse(Task73_MISTRAL_codestral_latest.isValidPassword("VALIDPASSWORD1$"));
    }

    @Test
    public void test_missing_digit() {
        assertFalse(Task73_MISTRAL_codestral_latest.isValidPassword("ValidPassword$"));
    }

    @Test
    public void test_missing_special_char() {
        assertFalse(Task73_MISTRAL_codestral_latest.isValidPassword("ValidPassword1"));
    }

    @Test
    public void test_contains_admin() {
        assertFalse(Task73_MISTRAL_codestral_latest.isValidPassword("Admin1234$"));
    }

    @Test
    public void test_valid_password_with_special_chars() {
        assertTrue(Task73_MISTRAL_codestral_latest.isValidPassword("Valid1Password@#"));
    }

    @Test
    public void test_contains_admin_case_insensitive() {
        assertFalse(Task73_MISTRAL_codestral_latest.isValidPassword("superADMIN2024$"));
    }

    @Test
    public void test_valid_password_with_longer_length() {
        assertTrue(Task73_MISTRAL_codestral_latest.isValidPassword("VeryLongValidPassword1$2024"));
    }
}
