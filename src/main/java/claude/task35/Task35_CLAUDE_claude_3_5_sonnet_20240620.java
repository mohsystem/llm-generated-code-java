package claude.task35;

public class Task35_CLAUDE_claude_3_5_sonnet_20240620 {
    public static int countPassengers(int[][] stops) {
        int passengers = 0;
        for (int[] stop : stops) {
            passengers += stop[0] - stop[1];
        }
        return passengers;
    }

    public static void main(String[] args) {
        int[][] stops = {{10,0}, {3,5}, {5,8}};
        System.out.println(countPassengers(stops));
    }
}
