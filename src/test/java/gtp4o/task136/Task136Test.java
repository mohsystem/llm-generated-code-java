package gtp4o.task136;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Task136Test {

    @Test
    void testAuthenticateSuccess() {
        assertTrue(Task136_OPENAI_gpt_4o.authenticate("user", "pass"));
    }

    @Test
    void testAuthenticateWrongUsername() {
        assertFalse(Task136_OPENAI_gpt_4o.authenticate("wronguser", "pass"));
    }

    @Test
    void testAuthenticateWrongPassword() {
        assertFalse(Task136_OPENAI_gpt_4o.authenticate("user", "wrongpass"));
    }

    @Test
    void testAuthenticateWrongBoth() {
        assertFalse(Task136_OPENAI_gpt_4o.authenticate("wronguser", "wrongpass"));
    }

    @Test
    void testAuthenticateEmptyUsername() {
        assertFalse(Task136_OPENAI_gpt_4o.authenticate("", "pass"));
    }

    @Test
    void testAuthenticateEmptyPassword() {
        assertFalse(Task136_OPENAI_gpt_4o.authenticate("user", ""));
    }

    @Test
    void testAuthenticateEmptyBoth() {
        assertFalse(Task136_OPENAI_gpt_4o.authenticate("", ""));
    }
}
