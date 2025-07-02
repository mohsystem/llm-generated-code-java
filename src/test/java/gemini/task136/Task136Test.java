package gemini.task136;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

class Task136Test {

    private Map<String, String> database;

    @BeforeEach
    void setUp() {
        database = new HashMap<>();
        database.put("user1", "password123");
        database.put("john_doe", "securepassword");
    }

    @Test
    void testAuthenticateSuccessUser1() {
        assertTrue(Task136_GEMINI_gemini_1_5_pro_001.authenticate("user1", "password123", database));
    }

    @Test
    void testAuthenticateSuccessJohnDoe() {
        assertTrue(Task136_GEMINI_gemini_1_5_pro_001.authenticate("john_doe", "securepassword", database));
    }

    @Test
    void testAuthenticateWrongPassword() {
        assertFalse(Task136_GEMINI_gemini_1_5_pro_001.authenticate("user1", "wrongpassword", database));
    }

    @Test
    void testAuthenticateNonexistentUser() {
        assertFalse(Task136_GEMINI_gemini_1_5_pro_001.authenticate("nonexistent", "password123", database));
    }

    @Test
    void testAuthenticateEmptyUsername() {
        assertFalse(Task136_GEMINI_gemini_1_5_pro_001.authenticate("", "password123", database));
    }

    @Test
    void testAuthenticateEmptyPassword() {
        assertFalse(Task136_GEMINI_gemini_1_5_pro_001.authenticate("user1", "", database));
    }
}
