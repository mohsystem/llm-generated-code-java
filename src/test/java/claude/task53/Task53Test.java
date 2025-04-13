package claude.task53;

import org.junit.jupiter.api.*;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class Task53Test {

    private SessionManager sessionManager;
    private String userId;
    private String sessionId;

    @BeforeEach
    public void setup() {
        sessionManager = new SessionManager(1800); // 30 minutes
        userId = "user123";
        sessionId = sessionManager.createSession(userId);
    }

    @Test
    public void testCreateSession() {
        assertNotNull(sessionId);
        Session session = sessionManager.getSession(sessionId);
        assertNotNull(session);
        assertEquals(userId, session.userId);
        assertNotNull(session.sessionId);
    }

    @Test
    public void testGetSession() {
        Session session = sessionManager.getSession(sessionId);
        assertNotNull(session);
        assertEquals(userId, session.userId);
    }

    @Test
    public void testGetInvalidSession() {
        String invalidId = UUID.randomUUID().toString();
        Session session = sessionManager.getSession(invalidId);
        assertNull(session);
    }

    @Test
    public void testSessionTimeout() throws InterruptedException {
        sessionManager = new SessionManager(1); // 1 second
        sessionId = sessionManager.createSession(userId);
        Thread.sleep(2000); // wait 2 seconds
        Session session = sessionManager.getSession(sessionId);
        assertNull(session);
    }

    @Test
    public void testDestroySession() {
        sessionManager.destroySession(sessionId);
        assertNull(sessionManager.getSession(sessionId));
    }

    @Test
    public void testCleanupExpiredSessions() throws InterruptedException {
        sessionManager = new SessionManager(1); // 1 second timeout
        sessionId = sessionManager.createSession(userId);
        Thread.sleep(1500); // wait enough to expire first session
        String sessionId2 = sessionManager.createSession("user456"); // created after timeout
        sessionManager.cleanupExpiredSessions();

        assertNull(sessionManager.getSession(sessionId));
        assertNotNull(sessionManager.getSession(sessionId2));
    }


    @Test
    public void testCleanupNoExpiredSessions() {
        String sessionId2 = sessionManager.createSession("user789");
        sessionManager.cleanupExpiredSessions();
        assertNotNull(sessionManager.getSession(sessionId));
        assertNotNull(sessionManager.getSession(sessionId2));
    }

    @Test
    public void testUpdateLastAccessed() throws InterruptedException {
        Session old = sessionManager.getSession(sessionId);
        Instant originalAccess = old.lastAccessed;
        Thread.sleep(1000);
        Session newAccess = sessionManager.getSession(sessionId);
        assertTrue(newAccess.lastAccessed.isAfter(originalAccess));
    }

    @Test
    public void testCreateMultipleSessions() {
        String sessionId2 = sessionManager.createSession("user456");
        assertNotNull(sessionManager.getSession(sessionId2));
        assertNotEquals(sessionId, sessionId2);
    }

    @Test
    public void testDestroyNonExistentSession() {
        String nonExistent = UUID.randomUUID().toString();
        sessionManager.destroySession(nonExistent);
        assertNull(sessionManager.getSession(nonExistent));
    }
}
