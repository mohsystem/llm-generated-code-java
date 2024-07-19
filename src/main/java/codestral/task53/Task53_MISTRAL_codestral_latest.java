package codestral.task53;// Java
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task53_MISTRAL_codestral_latest {
    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }
}