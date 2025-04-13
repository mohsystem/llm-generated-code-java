package llama3.task53;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task53Test {

    private Task53_PERPLEXITY_llama_3_sonar_large_32k_chat sessionManager;
    private String sessionId;
    private String userId = "user123";

    @BeforeEach
    public void setUp() {
        sessionManager = new Task53_PERPLEXITY_llama_3_sonar_large_32k_chat();
        sessionId = sessionManager.createSession(userId);
    }

    @Test
    public void testCreateSession() {
        assertNotNull(sessionId);
        assertEquals(userId, sessionManager.getUserId(sessionId));
    }

    @Test
    public void testGetUserId() {
        String result = sessionManager.getUserId(sessionId);
        assertEquals(userId, result);
    }

    @Test
    public void testGetInvalidSession() {
        String fakeSessionId = "non-existent-id";
        assertNull(sessionManager.getUserId(fakeSessionId));
    }

    @Test
    public void testInvalidateSession() {
        sessionManager.invalidateSession(sessionId);
        assertNull(sessionManager.getUserId(sessionId));
    }

    @Test
    public void testCreateMultipleSessions() {
        String sessionId2 = sessionManager.createSession("user456");
        assertNotEquals(sessionId, sessionId2);
        assertEquals("user456", sessionManager.getUserId(sessionId2));
        assertEquals(userId, sessionManager.getUserId(sessionId));
    }

    @Test
    public void testInvalidateNonExistentSession() {
        String fakeSessionId = "fake-session-id";
        sessionManager.invalidateSession(fakeSessionId); // should not throw
        assertNull(sessionManager.getUserId(fakeSessionId));
    }
}
