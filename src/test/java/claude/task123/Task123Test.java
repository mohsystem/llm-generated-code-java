package claude.task123;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Session {
    String sessionId;
    String userId;
    Instant creationTime;
    Instant lastActivity;

    Session(String userId) {
        this.sessionId = UUID.randomUUID().toString();
        this.userId = userId;
        this.creationTime = Instant.now();
        this.lastActivity = this.creationTime;
    }
}

class SessionManager {
    private Map<String, Session> sessions;
    private long sessionTimeout;

    SessionManager(long sessionTimeout) {
        this.sessions = new HashMap<>();
        this.sessionTimeout = sessionTimeout;
    }

    String createSession(String userId) {
        Session session = new Session(userId);
        sessions.put(session.sessionId, session);
        return session.sessionId;
    }

    Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            if (Instant.now().toEpochMilli() - session.lastActivity.toEpochMilli() > sessionTimeout) {
                destroySession(sessionId);
                return null;
            }
            session.lastActivity = Instant.now();
        }
        return session;
    }

    void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    void cleanupExpiredSessions() {
        long currentTime = Instant.now().toEpochMilli();
        sessions.entrySet().removeIf(entry ->
                currentTime - entry.getValue().lastActivity.toEpochMilli() > sessionTimeout);
    }

    // Added getters for testing
    public boolean hasSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public int getSessionCount() {
        return sessions.size();
    }

    public Session getSessionDirect(String sessionId) {
        return sessions.get(sessionId);
    }
}

public class Task123Test {

    public static void main(String[] args) throws InterruptedException {
        runTestCases();
    }

    static void runTestCases() throws InterruptedException {
        test_create_session_valid_user_id();
        test_create_session_unique_session_id();
        test_get_session_valid_session();
        test_get_session_expired();
        test_destroy_session();
        test_destroy_nonexistent_session();
        test_cleanup_expired_sessions();
        test_get_session_updates_last_activity();
        test_create_session_session_id_format();
        test_no_sessions_after_cleanup();
    }

    static void test_create_session_valid_user_id() {
        System.out.println("Test Case: create_session_valid_user_id");
        SessionManager sm = new SessionManager(1800000);
        String userId = "user123";
        String sessionId = sm.createSession(userId);
        if (sessionId != null && sm.hasSession(sessionId) && sm.getSessionDirect(sessionId).userId.equals(userId)) {
            pass();
        } else {
            fail();
        }
    }

    static void test_create_session_unique_session_id() {
        System.out.println("Test Case: create_session_unique_session_id");
        SessionManager sm = new SessionManager(1800000);
        String userId = "user123";
        String s1 = sm.createSession(userId);
        String s2 = sm.createSession(userId);
        if (s1 != null && s2 != null && !s1.equals(s2)) {
            pass();
        } else {
            fail();
        }
    }

    static void test_get_session_valid_session() {
        System.out.println("Test Case: get_session_valid_session");
        SessionManager sm = new SessionManager(1800000);
        String userId = "user123";
        String sessionId = sm.createSession(userId);
        Session s = sm.getSession(sessionId);
        if (s != null && s.userId.equals(userId)) {
            pass();
        } else {
            fail();
        }
    }

    static void test_get_session_expired() throws InterruptedException {
        System.out.println("Test Case: get_session_expired");
        SessionManager sm = new SessionManager(1000); // 1 sec timeout
        String userId = "user123";
        String sessionId = sm.createSession(userId);
        Thread.sleep(1500); // wait 1.5 seconds
        Session s = sm.getSession(sessionId);
        if (s == null) {
            pass();
        } else {
            fail();
        }
    }

    static void test_destroy_session() {
        System.out.println("Test Case: destroy_session");
        SessionManager sm = new SessionManager(1800000);
        String userId = "user123";
        String sessionId = sm.createSession(userId);
        sm.destroySession(sessionId);
        if (!sm.hasSession(sessionId)) {
            pass();
        } else {
            fail();
        }
    }

    static void test_destroy_nonexistent_session() {
        System.out.println("Test Case: destroy_nonexistent_session");
        SessionManager sm = new SessionManager(1800000);
        String fakeId = UUID.randomUUID().toString();
        sm.destroySession(fakeId);
        if (!sm.hasSession(fakeId)) {
            pass();
        } else {
            fail();
        }
    }

    static void test_cleanup_expired_sessions() throws InterruptedException {
        System.out.println("Test Case: cleanup_expired_sessions");
        SessionManager sm = new SessionManager(1000);
        String s1 = sm.createSession("user123");
        String s2 = sm.createSession("user456");
        Thread.sleep(1500);
        sm.cleanupExpiredSessions();
        if (!sm.hasSession(s1) && !sm.hasSession(s2)) {
            pass();
        } else {
            fail();
        }
    }

    static void test_get_session_updates_last_activity() throws InterruptedException {
        System.out.println("Test Case: get_session_updates_last_activity");
        SessionManager sm = new SessionManager(1800000);
        String sId = sm.createSession("user123");
        Session s = sm.getSession(sId);
        long initialLastActivity = s.lastActivity.toEpochMilli();
        Thread.sleep(1000);
        sm.getSession(sId);
        long updatedLastActivity = sm.getSession(sId).lastActivity.toEpochMilli();
        if (updatedLastActivity > initialLastActivity) {
            pass();
        } else {
            fail();
        }
    }

    static void test_create_session_session_id_format() {
        System.out.println("Test Case: create_session_session_id_format");
        SessionManager sm = new SessionManager(1800000);
        String sId = sm.createSession("user123");
        try {
            UUID uuid = UUID.fromString(sId);
            pass();
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    static void test_no_sessions_after_cleanup() throws InterruptedException {
        System.out.println("Test Case: no_sessions_after_cleanup");
        SessionManager sm = new SessionManager(1000);
        String sId = sm.createSession("user123");
        Thread.sleep(1500);
        sm.cleanupExpiredSessions();
        if (sm.getSessionCount() == 0) {
            pass();
        } else {
            fail();
        }
    }

    static void pass() {
        System.out.println("Result: PASS\n");
    }

    static void fail() {
        System.out.println("Result: FAIL\n");
    }
}
