package claude2.task199;

public class Task199_CLAUDE_claude_3_5_sonnet_20240620 {
    private int minutes;

    public Task199_CLAUDE_claude_3_5_sonnet_20240620(int hours, int minutes) {
        this.minutes = (hours * 60 + minutes) % 1440;
    }

    @Override
    public String toString() {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Clock) {
            Task199_CLAUDE_claude_3_5_sonnet_20240620 other = (Task199_CLAUDE_claude_3_5_sonnet_20240620) obj;
            return this.minutes == other.minutes;
        }
        return false;
    }

    public Task199_CLAUDE_claude_3_5_sonnet_20240620 add(int minutes) {
        this.minutes = (this.minutes + minutes) % 1440;
        return this;
    }

    public Task199_CLAUDE_claude_3_5_sonnet_20240620 subtract(int minutes) {
        this.minutes = (this.minutes - minutes + 1440) % 1440;
        return this;
    }

    public static void main(String[] args) {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock1 = new Task199_CLAUDE_claude_3_5_sonnet_20240620(10, 30);
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock2 = new Task199_CLAUDE_claude_3_5_sonnet_20240620(10, 30);
        System.out.println(clock1);  // 10:30
        System.out.println(clock1.equals(clock2));  // true
        clock1.add(30);
        System.out.println(clock1);  // 11:00
        clock1.subtract(60);
        System.out.println(clock1);  // 10:00
    }
}
