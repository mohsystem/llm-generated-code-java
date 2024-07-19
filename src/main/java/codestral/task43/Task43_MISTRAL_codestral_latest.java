package codestral.task43;// Java
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task43_MISTRAL_codestral_latest {
    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void terminateSession(String sessionId) {
        sessions.remove(sessionId);
    }
}