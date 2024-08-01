package llama3.task33;

import java.util.*;

public class Task33_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static int queueTime(int[] customers, int n) {
        int[] tills = new int[n];
        for (int time : customers) {
            int minIndex = 0;
            for (int i = 1; i < n; i++) {
                if (tills[i] < tills[minIndex]) {
                    minIndex = i;
                }
            }
            tills[minIndex] += time;
        }
        int maxTime = 0;
        for (int time : tills) {
            if (time > maxTime) {
                maxTime = time;
            }
        }
        return maxTime;
    }
}