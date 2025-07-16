package gtp4o.task123;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

class Task123_OPENAI_gpt_4o {
    private final String userId;
    private final String sessionId;
    private volatile long lastActivity; // timestamp millis

    public Task123_OPENAI_gpt_4o(String userId) {
        this.userId = userId;
        this.sessionId = UUID.randomUUID().toString();
        this.lastActivity = System.currentTimeMillis();
    }

    public String getUserId() {
        return userId;
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

    public long getDurationSeconds() {
        return (System.currentTimeMillis() - lastActivity) / 1000;
    }
}

class SessionManager {
    private final Map<String, Task123_OPENAI_gpt_4o> sessions = new ConcurrentHashMap<>();
    private long sessionTimeoutMillis = 1800 * 1000; // default 30 min

    public SessionManager() {}

    public SessionManager(long timeoutSeconds) {
        this.sessionTimeoutMillis = timeoutSeconds * 1000;
    }

    public String createSession(String userId) {
        Task123_OPENAI_gpt_4o session = new Task123_OPENAI_gpt_4o(userId);
        sessions.put(session.getSessionId(), session);
        return session.getSessionId();
    }

    public Task123_OPENAI_gpt_4o getSession(String sessionId) {
        Task123_OPENAI_gpt_4o session = sessions.get(sessionId);
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
        for (Map.Entry<String, Task123_OPENAI_gpt_4o> entry : sessions.entrySet()) {
            if (now - entry.getValue().getLastActivity() > sessionTimeoutMillis) {
                expired.add(entry.getKey());
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

    public String getSessionUserId(String sessionId) {
        Task123_OPENAI_gpt_4o s = sessions.get(sessionId);
        return s != null ? s.getUserId() : null;
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
        String id1 = sessionManager.createSession(userId);
        String id2 = sessionManager.createSession(userId);
        if (!id1.equals(id2)) {
            System.out.println("test_create_session_unique_session_id: PASS");
        } else {
            System.out.println("test_create_session_unique_session_id: FAIL");
        }
    }

    public void test_get_session_valid_session() {
        String userId = "user123";
        String sessionId = sessionManager.createSession(userId);
        Task123_OPENAI_gpt_4o session = sessionManager.getSession(sessionId);
        if (session != null && userId.equals(session.getUserId())) {
            System.out.println("test_get_session_valid_session: PASS");
        } else {
            System.out.println("test_get_session_valid_session: FAIL");
        }
    }

    public void test_get_session_expired() {
        try {
            SessionManager sm = new SessionManager(1); // 1 second timeout
            String userId = "user123";
            String sessionId = sm.createSession(userId);
            Thread.sleep(2000);
            Task123_OPENAI_gpt_4o session = sm.getSession(sessionId);
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
        String fakeId = UUID.randomUUID().toString();
        sessionManager.destroySession(fakeId);
        if (!sessionManager.hasSession(fakeId)) {
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
            String userId = "user123";
            String sid = sessionManager.createSession(userId);
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
        String userId = "user123";
        String sid = sessionManager.createSession(userId);
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
