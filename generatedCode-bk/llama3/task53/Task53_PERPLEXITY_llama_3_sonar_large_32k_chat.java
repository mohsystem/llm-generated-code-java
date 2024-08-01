package llama3.task53;

import java.util.HashMap;
import java.util.Map;

public class Task53_PERPLEXITY_llama_3_sonar_large_32k_chat {
    private Map<String, String> sessions;

    public Task53_PERPLEXITY_llama_3_sonar_large_32k_chat() {
        this.sessions = new HashMap<>();
    }

    public void createUserSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public void deleteUserSession(String userId) {
        sessions.remove(userId);
    }

    public String getUserSessionId(String userId) {
        return sessions.get(userId);
    }

    public static void main(String[] args) {
        Task53_PERPLEXITY_llama_3_sonar_large_32k_chat sessionManager = new Task53_PERPLEXITY_llama_3_sonar_large_32k_chat();
        sessionManager.createUserSession("user1", "session1");
        sessionManager.createUserSession("user2", "session2");
        System.out.println(sessionManager.getUserSessionId("user1")); // prints "session1"
        sessionManager.deleteUserSession("user1");
        System.out.println(sessionManager.getUserSessionId("user1")); // prints null
    }
}