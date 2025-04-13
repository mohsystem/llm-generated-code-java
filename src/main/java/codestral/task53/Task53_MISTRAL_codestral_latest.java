package codestral.task53;
// Example usage:
import java.util.HashMap;
import java.util.Map;
// Java
public class Task53_MISTRAL_codestral_latest {
    private String userId;
    private boolean isActive;

    public Task53_MISTRAL_codestral_latest(String userId) {
        this.userId = userId;
        this.isActive = true;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setActive(boolean active) {
        isActive = active;
    }}



 class Main {
    public static void main(String[] args) {
        Map<String, Task53_MISTRAL_codestral_latest> userSessions = new HashMap<>();
        String userId = "123";
        userSessions.put(userId, new Task53_MISTRAL_codestral_latest(userId));
    }
}