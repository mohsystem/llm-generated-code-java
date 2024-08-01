package gtp4o.task123;

public class Task123_OPENAI_gpt_4o {
    private int userId;
    private boolean active;

    public Task123_OPENAI_gpt_4o(int userId) {
        this.userId = userId;
        this.active = true;
    }

    public void endSession() {
        this.active = false;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isActive() {
        return active;
    }

    public static void main(String[] args) {
        Task123_OPENAI_gpt_4o session = new Task123_OPENAI_gpt_4o(1);
        System.out.println(session.getUserId());
        System.out.println(session.isActive());
        session.endSession();
        System.out.println(session.isActive());
    }
}