package gtp4o.task199;

import java.util.Objects;

public class Task199_OPENAI_gpt_4o {
    private int hour;
    private int minute;

    public Task199_OPENAI_gpt_4o(int hour, int minute) {
        int totalMinutes = (hour * 60 + minute) % (24 * 60);
        this.hour = totalMinutes / 60;
        this.minute = totalMinutes % 60;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }

    public Task199_OPENAI_gpt_4o addMinutes(int minutes) {
        return new Task199_OPENAI_gpt_4o(this.hour, this.minute + minutes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task199_OPENAI_gpt_4o clock = (Clock) o;
        return hour == clock.hour && minute == clock.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }

    public static void main(String[] args) {
        Task199_OPENAI_gpt_4o clock1 = new Task199_OPENAI_gpt_4o(10, 30);
        Task199_OPENAI_gpt_4o clock2 = clock1.addMinutes(35);
        Task199_OPENAI_gpt_4o clock3 = new Task199_OPENAI_gpt_4o(11, 5);
        System.out.println(clock2);  // 11:05
        System.out.println(clock2.equals(clock3));  // True
    }
}