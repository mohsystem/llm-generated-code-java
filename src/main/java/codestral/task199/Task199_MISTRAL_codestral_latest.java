package codestral.task199;

public class Task199_MISTRAL_codestral_latest {
    private int minutes;

    public Task199_MISTRAL_codestral_latest(int hours, int minutes) {
        this.minutes = (hours * 60 + minutes) % (24 * 60);
    }

    public boolean equals(Task199_MISTRAL_codestral_latest other) {
        return this.minutes == other.minutes;
    }

    public Task199_MISTRAL_codestral_latest add(int minutes) {
        return new Task199_MISTRAL_codestral_latest(0, this.minutes + minutes);
    }

    public Task199_MISTRAL_codestral_latest subtract(int minutes) {
        return new Task199_MISTRAL_codestral_latest(0, this.minutes - minutes);
    }

    @Override
    public String toString() {
        int hours = this.minutes / 60;
        int minutes = this.minutes % 60;
        return String.format("%02d:%02d", hours, minutes);
    }
}