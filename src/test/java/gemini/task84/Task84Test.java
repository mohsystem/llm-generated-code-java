package gemini.task84;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task84Test {

    @Test
    public void testGenerateSessionID_NotNullOrEmpty() {
        String sessionId = Task84_GEMINI_gemini_1_5_pro_001.generateSessionID(16);
        assertNotNull(sessionId, "Session ID should not be null");
        assertFalse(sessionId.isEmpty(), "Session ID should not be empty");
    }

    @Test
    public void testGenerateSessionID_LengthIsCorrect() {
        int length = 24;
        String sessionId = Task84_GEMINI_gemini_1_5_pro_001.generateSessionID(length);
        assertEquals(length, sessionId.length(), "Session ID should have the correct length");
    }

    @Test
    public void testGenerateSessionID_ContainsOnlyAllowedCharacters() {
        String sessionId = Task84_GEMINI_gemini_1_5_pro_001.generateSessionID(32);
        assertTrue(sessionId.matches("^[A-Za-z0-9]+$"), "Session ID should contain only alphanumeric characters");
    }

    @Test
    public void testGenerateSessionID_IsRandom() {
        String id1 = Task84_GEMINI_gemini_1_5_pro_001.generateSessionID(20);
        String id2 = Task84_GEMINI_gemini_1_5_pro_001.generateSessionID(20);
        assertNotEquals(id1, id2, "Each generated session ID should be unique");
    }
}
