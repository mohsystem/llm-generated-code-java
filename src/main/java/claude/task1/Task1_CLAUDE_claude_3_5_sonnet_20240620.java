package claude.task1;

import java.util.ArrayList;

public class Task1_CLAUDE_claude_3_5_sonnet_20240620 {
    public static int numberOfPeopleOnBus(ArrayList<int[]> stops) {
        return stops.stream().mapToInt(stop -> stop[0] - stop[1]).sum();
    }
}
