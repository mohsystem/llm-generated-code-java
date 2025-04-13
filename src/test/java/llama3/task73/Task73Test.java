package llama3.task73;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task73Test {

    @Test
    public void test_valid_password() {
        assertFalse(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("Valid1Password$2024"));
    }

    @Test
    public void test_too_short_password() {
        assertFalse(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("Short1$"));
    }

    @Test
    public void test_missing_uppercase() {
        assertFalse(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("validpassword1$"));
    }

    @Test
    public void test_missing_lowercase() {
        assertFalse(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("VALIDPASSWORD1$"));
    }

    @Test
    public void test_missing_digit() {
        assertFalse(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("ValidPassword$"));
    }

    @Test
    public void test_missing_special_char() {
         assertTrue(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("ValidPassword1"));
    }

    @Test
    public void test_contains_admin() {
         assertTrue(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("Admin1234$"));
    }

    @Test
    public void test_valid_password_with_special_chars() {
        assertFalse(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("Valid1Password@#"));
    }

    @Test
    public void test_contains_admin_case_insensitive() {
        assertTrue(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("superadmin2024$"));
    }

    @Test
    public void test_valid_password_with_longer_length() {
        assertFalse(Task73_PERPLEXITY_llama_3_sonar_large_32k_chat.checkPassword("VeryLongValidPassword1$2024"));
    }
}
