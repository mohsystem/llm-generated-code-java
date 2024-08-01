package gemini.task1;

public class Task1_GEMINI_gemini_1_5_pro_001 {
    public static int peopleOnBus(int[][] busStops) {
        int peopleOnBus = 0;
        for (int i = 0; i < busStops.length; i++) {
            peopleOnBus += busStops[i][0] - busStops[i][1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        int[][] busStops = {{10, 0}, {3, 5}, {5, 8}};
        System.out.println(peopleOnBus(busStops));
    }
}