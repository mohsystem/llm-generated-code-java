package gtp4o.task73;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task73Test {

    @Test
    public void test_valid_password() {
        assertEquals("Password is valid", Task73_OPENAI_gpt_4o.checkPassword("admin123"));
    }

    @Test
    public void test_invalid_password_case_sensitive() {
        assertEquals("Password is invalid", Task73_OPENAI_gpt_4o.checkPassword("Admin123")); // case mismatch
    }

    @Test
    public void test_invalid_password_random() {
        assertEquals("Password is invalid", Task73_OPENAI_gpt_4o.checkPassword("Valid1Password$2024"));
    }

    @Test
    public void test_invalid_empty_password() {
        assertEquals("Password is invalid", Task73_OPENAI_gpt_4o.checkPassword(""));
    }

    @Test
    public void test_invalid_password_with_extra_space() {
        assertEquals("Password is invalid", Task73_OPENAI_gpt_4o.checkPassword("admin123 "));
    }
}
