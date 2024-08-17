package llama3.task1;

public class Task1_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static int numberOfPeopleOnBus(int[][] people) {
        int count = 0;
        for (int[] pair : people) {
            count += pair[0] - pair[1];
        }
        return count;
    }
}