package claude.task1;

import java.util.ArrayList;
import java.util.List;

public class Task1_CLAUDE_claude_3_5_sonnet_20240620 {
    public static int countPassengers(ArrayList<int[]> stops) {
        int passengers = 0;
        for (int[] stop : stops) {
            passengers += stop[0] - stop[1];
        }
        return passengers;
    }

    public static void main(String[] args) {
        ArrayList<int[]> stops = new ArrayList<int[]>();
        stops.add(new int[]{10, 0});
        stops.add(new int[]{3, 5});
        stops.add(new int[]{2, 5});
        System.out.println(countPassengers(stops));  // Output: 5
    }
}
