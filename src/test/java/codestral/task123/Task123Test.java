package codestral.task123;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

class Task123 {

    public static class Session {
        private final String sessionId;
        private final String userId;
        private long creationTime;
        private long lastActivity;

        public Session(String userId) {
            this.sessionId = UUID.randomUUID().toString();
            this.userId = userId;
            this.creationTime = System.currentTimeMillis();
            this.lastActivity = this.creationTime;
        }

        public String getSessionId() { return sessionId; }
        public String getUserId() { return userId; }
        public long getLastActivity() { return lastActivity; }
        public void updateLastActivity() { this.lastActivity = System.currentTimeMillis(); }
    }

    public static class SessionManager {
        private final Map<String, Session> sessions;
        private long sessionTimeout; // milliseconds

        public SessionManager() {
            this.sessions = new ConcurrentHashMap<>();
            this.sessionTimeout = 1800 * 1000;
        }

        public SessionManager(long timeoutSeconds) {
            this.sessions = new ConcurrentHashMap<>();
            this.sessionTimeout = timeoutSeconds * 1000;
        }

        public String createSession(String userId) {
            Session session = new Session(userId);
            sessions.put(session.getSessionId(), session);
            return session.getSessionId();
        }

        public Session getSession(String sessionId) {
            Session session = sessions.get(sessionId);
            if (session != null) {
                long currentTime = System.currentTimeMillis();
                if ((currentTime - session.getLastActivity()) > sessionTimeout) {
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
            long currentTime = System.currentTimeMillis();
            List<String> expired = new ArrayList<>();
            for (Map.Entry<String, Session> entry : sessions.entrySet()) {
                if ((currentTime - entry.getValue().getLastActivity()) > sessionTimeout) {
                    expired.add(entry.getKey());
                }
            }
            for (String sid : expired) {
                destroySession(sid);
            }
        }

        public int getSessionCount() {
            return sessions.size();
        }

        // Getters for testing ONLY
        public boolean hasSession(String sessionId) {
            return sessions.containsKey(sessionId);
        }

        public String getSessionUserId(String sessionId) {
            Session s = sessions.get(sessionId);
            return (s != null) ? s.getUserId() : null;
        }
    }
}

public class Task123Test {

    private Task123.SessionManager sessionManager;

    public void setUp() {
        sessionManager = new Task123.SessionManager();
    }

    public void test_create_session_valid_user_id() {
        String userId = "user123";
        String sessionId = sessionManager.createSession(userId);
        if (sessionManager.hasSession(sessionId) && userId.equals(sessionManager.getSessionUserId(sessionId))) {
            System.out.println("test_create_session_valid_user_id: PASS");
        } else {
            System.out.println("test_create_session_valid_user_id: FAIL");
        }
    }

    public void test_create_session_unique_session_id() {
        String userId = "user123";
        String sessionId1 = sessionManager.createSession(userId);
        String sessionId2 = sessionManager.createSession(userId);
        if (!sessionId1.equals(sessionId2)) {
            System.out.println("test_create_session_unique_session_id: PASS");
        } else {
            System.out.println("test_create_session_unique_session_id: FAIL");
        }
    }

    public void test_get_session_valid_session() {
        String userId = "user123";
        String sessionId = sessionManager.createSession(userId);
        Task123.Session session = sessionManager.getSession(sessionId);
        if (session != null && session.getUserId().equals(userId)) {
            System.out.println("test_get_session_valid_session: PASS");
        } else {
            System.out.println("test_get_session_valid_session: FAIL");
        }
    }

    public void test_get_session_expired() {
        try {
            String userId = "user123";
            Task123.SessionManager sm = new Task123.SessionManager(1);
            String sessionId = sm.createSession(userId);
            Thread.sleep(2000);
            Task123.Session session = sm.getSession(sessionId);
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
        String userId = "user123";
        String sessionId = sessionManager.createSession(userId);
        sessionManager.destroySession(sessionId);
        if (!sessionManager.hasSession(sessionId)) {
            System.out.println("test_destroy_session: PASS");
        } else {
            System.out.println("test_destroy_session: FAIL");
        }
    }

    public void test_destroy_nonexistent_session() {
        String nonExistentSessionId = UUID.randomUUID().toString();
        sessionManager.destroySession(nonExistentSessionId);
        if (!sessionManager.hasSession(nonExistentSessionId)) {
            System.out.println("test_destroy_nonexistent_session: PASS");
        } else {
            System.out.println("test_destroy_nonexistent_session: FAIL");
        }
    }

    public void test_cleanup_expired_sessions() {
        try {
            String userId1 = "user123";
            String userId2 = "user456";
            Task123.SessionManager sm = new Task123.SessionManager(1);
            String sessionId1 = sm.createSession(userId1);
            String sessionId2 = sm.createSession(userId2);
            Thread.sleep(2000);
            sm.cleanupExpiredSessions();
            if (!sm.hasSession(sessionId1) && !sm.hasSession(sessionId2)) {
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
            String userId = "user123";
            String sessionId = sessionManager.createSession(userId);
            long initialLastActivity = sessionManager.getSession(sessionId).getLastActivity();
            Thread.sleep(1000);
            sessionManager.getSession(sessionId);
            long updatedLastActivity = sessionManager.getSession(sessionId).getLastActivity();
            if (updatedLastActivity > initialLastActivity) {
                System.out.println("test_get_session_updates_last_activity: PASS");
            } else {
                System.out.println("test_get_session_updates_last_activity: FAIL");
            }
        } catch (InterruptedException e) {
            System.out.println("test_get_session_updates_last_activity: FAIL due to interruption");
        }
    }

    public void test_create_session_session_id_format() {
        String userId = "user123";
        String sessionId = sessionManager.createSession(userId);
        try {
            UUID uuid = UUID.fromString(sessionId);
            System.out.println("test_create_session_session_id_format: PASS");
        } catch (IllegalArgumentException e) {
            System.out.println("test_create_session_session_id_format: FAIL");
        }
    }

    public void test_no_sessions_after_cleanup() {
        try {
            String userId = "user123";
            Task123.SessionManager sm = new Task123.SessionManager(1);
            sm.createSession(userId);
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
