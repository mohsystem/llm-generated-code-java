package gemini.task1;

public class Task1_GEMINI_gemini_1_5_pro_001 {
    public static int numberOfPeopleOnBus(int[][] bus_stops) {
        int peopleOnBus = 0;
        for (int[] stop : bus_stops) {
            peopleOnBus += stop[0] - stop[1];
        }
        return peopleOnBus;
    }
}