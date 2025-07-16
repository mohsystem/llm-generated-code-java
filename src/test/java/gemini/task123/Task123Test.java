package gemini.task123;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

class Session {
    private final String username;
    private final String sessionId;
    private volatile long lastActivity; // timestamp in millis

    public Session(String username) {
        this.username = username;
        this.sessionId = UUID.randomUUID().toString();
        this.lastActivity = Instant.now().toEpochMilli();
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUsername() {
        return username;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public void updateLastActivity() {
        lastActivity = Instant.now().toEpochMilli();
    }
}

class SessionManager {
    private final Map<String, Session> sessions = new ConcurrentHashMap<>();
    private long sessionTimeoutMillis = 1800 * 1000; // default 30 minutes

    public SessionManager() {}

    public SessionManager(long timeoutSeconds) {
        this.sessionTimeoutMillis = timeoutSeconds * 1000;
    }

    public String createSession(String username) {
        Session session = new Session(username);
        sessions.put(session.getSessionId(), session);
        return session.getSessionId();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            long now = Instant.now().toEpochMilli();
            if (now - session.getLastActivity() > sessionTimeoutMillis) {
                destroySession(sessionId);
                return null;
            }
            session.updateLastActivity();
        }
        return session;
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void cleanupExpiredSessions() {
        long now = Instant.now().toEpochMilli();
        List<String> expired = new ArrayList<>();
        for (Map.Entry<String, Session> e : sessions.entrySet()) {
            if (now - e.getValue().getLastActivity() > sessionTimeoutMillis) {
                expired.add(e.getKey());
            }
        }
        for (String sid : expired) {
            destroySession(sid);
        }
    }

    // For tests
    public boolean hasSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public String getSessionUsername(String sessionId) {
        Session s = sessions.get(sessionId);
        return s != null ? s.getUsername() : null;
    }

    public int getSessionCount() {
        return sessions.size();
    }
}

// اسم الكلاس public لازم يكون مطابق للملف: Task123Test.java
public class Task123Test {

    private SessionManager sessionManager;

    public void setUp() {
        sessionManager = new SessionManager();
    }

    public void test_create_session_valid_user_id() {
        String user = "user123";
        String sessionId = sessionManager.createSession(user);
        if (sessionManager.hasSession(sessionId)
                && user.equals(sessionManager.getSessionUsername(sessionId))) {
            System.out.println("test_create_session_valid_user_id: PASS");
        } else {
            System.out.println("test_create_session_valid_user_id: FAIL");
        }
    }

    public void test_create_session_unique_session_id() {
        String user = "user123";
        String id1 = sessionManager.createSession(user);
        String id2 = sessionManager.createSession(user);
        if (!id1.equals(id2)) {
            System.out.println("test_create_session_unique_session_id: PASS");
        } else {
            System.out.println("test_create_session_unique_session_id: FAIL");
        }
    }

    public void test_get_session_valid_session() {
        String user = "user123";
        String sessionId = sessionManager.createSession(user);
        Session session = sessionManager.getSession(sessionId);
        if (session != null && user.equals(session.getUsername())) {
            System.out.println("test_get_session_valid_session: PASS");
        } else {
            System.out.println("test_get_session_valid_session: FAIL");
        }
    }

    public void test_get_session_expired() {
        try {
            SessionManager sm = new SessionManager(1); // 1 sec timeout
            String user = "user123";
            String sessionId = sm.createSession(user);
            Thread.sleep(2000);
            Session session = sm.getSession(sessionId);
            if (session == null) {
                System.out.println("test_get_session_expired: PASS");
            } else {
                System.out.println("test_get_session_expired: FAIL");
            }
        } catch (InterruptedException e) {
            System.out.println("test_get_session_expired: FAIL due to interruption");
        }
    }

    public void test_destroy_session() {
        String user = "user123";
        String sessionId = sessionManager.createSession(user);
        sessionManager.destroySession(sessionId);
        if (!sessionManager.hasSession(sessionId)) {
            System.out.println("test_destroy_session: PASS");
        } else {
            System.out.println("test_destroy_session: FAIL");
        }
    }

    public void test_destroy_nonexistent_session() {
        String fakeSessionId = UUID.randomUUID().toString();
        sessionManager.destroySession(fakeSessionId);
        if (!sessionManager.hasSession(fakeSessionId)) {
            System.out.println("test_destroy_nonexistent_session: PASS");
        } else {
            System.out.println("test_destroy_nonexistent_session: FAIL");
        }
    }

    public void test_cleanup_expired_sessions() {
        try {
            SessionManager sm = new SessionManager(1);
            String user1 = "user123";
            String user2 = "user456";
            String sid1 = sm.createSession(user1);
            String sid2 = sm.createSession(user2);
            Thread.sleep(2000);
            sm.cleanupExpiredSessions();
            if (!sm.hasSession(sid1) && !sm.hasSession(sid2)) {
                System.out.println("test_cleanup_expired_sessions: PASS");
            } else {
                System.out.println("test_cleanup_expired_sessions: FAIL");
            }
        } catch (InterruptedException e) {
            System.out.println("test_cleanup_expired_sessions: FAIL due to interruption");
        }
    }

    public void test_get_session_updates_last_activity() {
        try {
            String user = "user123";
            String sid = sessionManager.createSession(user);
            long initial = sessionManager.getSession(sid).getLastActivity();
            Thread.sleep(1000);
            sessionManager.getSession(sid);
            long updated = sessionManager.getSession(sid).getLastActivity();
            if (updated > initial) {
                System.out.println("test_get_session_updates_last_activity: PASS");
            } else {
                System.out.println("test_get_session_updates_last_activity: FAIL");
            }
        } catch (InterruptedException e) {
            System.out.println("test_get_session_updates_last_activity: FAIL due to interruption");
        }
    }

    public void test_create_session_session_id_format() {
        String user = "user123";
        String sid = sessionManager.createSession(user);
        try {
            UUID.fromString(sid);
            System.out.println("test_create_session_session_id_format: PASS");
        } catch (IllegalArgumentException e) {
            System.out.println("test_create_session_session_id_format: FAIL");
        }
    }

    public void test_no_sessions_after_cleanup() {
        try {
            SessionManager sm = new SessionManager(1);
            sm.createSession("user123");
            Thread.sleep(2000);
            sm.cleanupExpiredSessions();
            if (sm.getSessionCount() == 0) {
                System.out.println("test_no_sessions_after_cleanup: PASS");
            } else {
                System.out.println("test_no_sessions_after_cleanup: FAIL");
            }
        } catch (InterruptedException e) {
            System.out.println("test_no_sessions_after_cleanup: FAIL due to interruption");
        }
    }

    public static void main(String[] args) {
        Task123Test test = new Task123Test();
        test.setUp();

        test.test_create_session_valid_user_id();
        test.test_create_session_unique_session_id();
        test.test_get_session_valid_session();
        test.test_get_session_expired();
        test.test_destroy_session();
        test.test_destroy_nonexistent_session();
        test.test_cleanup_expired_sessions();
        test.test_get_session_updates_last_activity();
        test.test_create_session_session_id_format();
        test.test_no_sessions_after_cleanup();
    }
}
