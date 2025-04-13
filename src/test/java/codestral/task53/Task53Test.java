package codestral.task53;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class Task53Test {

    private Map<String, Task53_MISTRAL_codestral_latest> sessions;
    private final String userId = "user123";

    @BeforeEach
    public void setup() {
        sessions = new HashMap<>();
        sessions.put(userId, new Task53_MISTRAL_codestral_latest(userId));
    }

    @Test
    public void testSessionCreation() {
        assertTrue(sessions.containsKey(userId));
        Task53_MISTRAL_codestral_latest session = sessions.get(userId);
        assertNotNull(session);
    }

    @Test
    public void testIsActiveInitiallyTrue() {
        Task53_MISTRAL_codestral_latest session = sessions.get(userId);
        assertTrue(session.isActive());
    }

    @Test
    public void testSetIsActiveFalse() {
        Task53_MISTRAL_codestral_latest session = sessions.get(userId);
        session.setActive(false);
        assertFalse(session.isActive());
    }

    @Test
    public void testUserIdGetter() {
        Task53_MISTRAL_codestral_latest session = sessions.get(userId);
        assertEquals(userId, session.getUserId());
    }

    @Test
    public void testMultipleSessions() {
        String user2 = "user456";
        sessions.put(user2, new Task53_MISTRAL_codestral_latest(user2));
        assertEquals(2, sessions.size());
        assertTrue(sessions.containsKey(user2));
    }
}
