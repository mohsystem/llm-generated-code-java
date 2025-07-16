package llama3.task123;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

class Session {
    private final int userId;
    private final String username;
    private final String sessionId;
    private volatile long lastActivity; // timestamp millis

    public Session(int userId, String username) {
        this.userId = userId;
        this.username = username;
        this.sessionId = UUID.randomUUID().toString();
        this.lastActivity = System.currentTimeMillis();
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getSessionId() {
        return sessionId;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public void updateLastActivity() {
        lastActivity = System.currentTimeMillis();
    }
}

class SessionManager {
    private final Map<String, Session> sessions = new ConcurrentHashMap<>();
    private long sessionTimeoutMillis = 1800 * 1000; // 30 minutes

    public SessionManager() {}

    public SessionManager(long timeoutSeconds) {
        this.sessionTimeoutMillis = timeoutSeconds * 1000;
    }

    public String createSession(int userId, String username) {
        Session session = new Session(userId, username);
        sessions.put(session.getSessionId(), session);
        return session.getSessionId();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            long now = System.currentTimeMillis();
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
        long now = System.currentTimeMillis();
        List<String> expired = new ArrayList<>();
        for (Map.Entry<String, Session> entry : sessions.entrySet()) {
            if (now - entry.getValue().getLastActivity() > sessionTimeoutMillis) {
                expired.add(entry.getKey());
            }
        }
        for (String sid : expired) {
            destroySession(sid);
        }
    }

    public boolean hasSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public int getSessionUserId(String sessionId) {
        Session s = sessions.get(sessionId);
        return s != null ? s.getUserId() : -1;
    }

    public String getSessionUsername(String sessionId) {
        Session s = sessions.get(sessionId);
        return s != null ? s.getUsername() : null;
    }

    public int getSessionCount() {
        return sessions.size();
    }
}

public class Task123Test {

    private SessionManager sessionManager;

    public void setUp() {
        sessionManager = new SessionManager();
    }

    public void test_create_session_valid_user_id() {
        int userId = 123;
        String username = "user123";
        String sessionId = sessionManager.createSession(userId, username);
        if (sessionManager.hasSession(sessionId)
                && userId == sessionManager.getSessionUserId(sessionId)
                && username.equals(sessionManager.getSessionUsername(sessionId))) {
            System.out.println("test_create_session_valid_user_id: PASS");
        } else {
            System.out.println("test_create_session_valid_user_id: FAIL");
        }
    }

    public void test_create_session_unique_session_id() {
        int userId = 123;
        String username = "user123";
        String sessionId1 = sessionManager.createSession(userId, username);
        String sessionId2 = sessionManager.createSession(userId, username);
        if (!sessionId1.equals(sessionId2)) {
            System.out.println("test_create_session_unique_session_id: PASS");
        } else {
            System.out.println("test_create_session_unique_session_id: FAIL");
        }
    }

    public void test_get_session_valid_session() {
        int userId = 123;
        String username = "user123";
        String sessionId = sessionManager.createSession(userId, username);
        Session session = sessionManager.getSession(sessionId);
        if (session != null
                && userId == session.getUserId()
                && username.equals(session.getUsername())) {
            System.out.println("test_get_session_valid_session: PASS");
        } else {
            System.out.println("test_get_session_valid_session: FAIL");
        }
    }

    public void test_get_session_expired() {
        try {
            SessionManager sm = new SessionManager(1); // 1 second timeout
            int userId = 123;
            String username = "user123";
            String sessionId = sm.createSession(userId, username);
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
        int userId = 123;
        String username = "user123";
        String sessionId = sessionManager.createSession(userId, username);
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
            int userId1 = 123;
            int userId2 = 456;
            String username1 = "user123";
            String username2 = "user456";
            String sid1 = sm.createSession(userId1, username1);
            String sid2 = sm.createSession(userId2, username2);
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
            int userId = 123;
            String username = "user123";
            String sid = sessionManager.createSession(userId, username);
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
        int userId = 123;
        String username = "user123";
        String sid = sessionManager.createSession(userId, username);
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
            sm.createSession(123, "user123");
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
