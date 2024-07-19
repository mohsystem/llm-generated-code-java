package codestral.task123;

// Java
public class Task123_MISTRAL_codestral_latest {
    private int userId;
    private boolean isActive;

    public Task123_MISTRAL_codestral_latest(int userId) {
        this.userId = userId;
        this.isActive = true;
    }

    public void endSession() {
        this.isActive = false;
    }

    // Usage
    public static void main(String[] args) {
        Task123_MISTRAL_codestral_latest userSession = new Task123_MISTRAL_codestral_latest(123);
        System.out.println(userSession.isActive);  // true
        userSession.endSession();
        System.out.println(userSession.isActive);  // false
    }
}