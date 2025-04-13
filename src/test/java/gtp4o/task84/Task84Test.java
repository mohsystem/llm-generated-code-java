package gtp4o.task84;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task84Test {

    @Test
    public void testSessionID_NotNullOrEmpty() {
        String sessionID = Task84_OPENAI_gpt_4o.generateSessionID();
        assertNotNull(sessionID, "Session ID should not be null");
        assertFalse(sessionID.isEmpty(), "Session ID should not be empty");
    }

    @Test
    public void testSessionID_Length() {
        String sessionID = Task84_OPENAI_gpt_4o.generateSessionID();
        assertEquals(16, sessionID.length(), "Session ID should be 16 characters long");
    }

    @Test
    public void testSessionID_OnlyAlphanumeric() {
        String sessionID = Task84_OPENAI_gpt_4o.generateSessionID();
        assertTrue(sessionID.matches("^[A-Za-z0-9]+$"), "Session ID should only contain alphanumeric characters");
    }

    @Test
    public void testSessionID_IsRandom() {
        String id1 = Task84_OPENAI_gpt_4o.generateSessionID();
        String id2 = Task84_OPENAI_gpt_4o.generateSessionID();
        assertNotEquals(id1, id2, "Session IDs should be different across calls");
    }
}
