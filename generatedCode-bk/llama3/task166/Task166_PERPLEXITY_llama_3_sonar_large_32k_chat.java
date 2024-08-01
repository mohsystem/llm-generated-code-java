package llama3.task166;

import java.util.*;

public class Task166_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static int[] posNegSort(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        for (int x : arr) {
            if (x > 0) {
                pos.add(x);
            }
        }
        Collections.sort(pos);
        int[] res = new int[arr.length];
        int pos_index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                res[i] = pos.get(pos_index);
                pos_index++;
            } else {
                res[i] = arr[i];
            }
        }
        return res;
    }
}