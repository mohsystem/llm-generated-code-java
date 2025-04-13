package claude.task84;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class Task84Test {

    @Test
    public void testGenerateSessionId_NotNullOrEmpty() {
        String sessionId = Task84_CLAUDE_claude_3_5_sonnet_20240620.generateSessionId();
        assertNotNull(sessionId, "Session ID should not be null");
        assertFalse(sessionId.isEmpty(), "Session ID should not be empty");
    }

    @Test
    public void testGenerateSessionId_IsValidUUID() {
        String sessionId = Task84_CLAUDE_claude_3_5_sonnet_20240620.generateSessionId();
        assertDoesNotThrow(() -> UUID.fromString(sessionId), "Session ID should be a valid UUID format");
    }

    @Test
    public void testGenerateSessionId_IsUnique() {
        String id1 = Task84_CLAUDE_claude_3_5_sonnet_20240620.generateSessionId();
        String id2 = Task84_CLAUDE_claude_3_5_sonnet_20240620.generateSessionId();
        assertNotEquals(id1, id2, "Each generated session ID should be unique");
    }
}
