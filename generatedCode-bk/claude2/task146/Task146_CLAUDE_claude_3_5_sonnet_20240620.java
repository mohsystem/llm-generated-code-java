package claude2.task146;

import java.util.Arrays;

public class Task146_CLAUDE_claude_3_5_sonnet_20240620 {
    public static int findMissing(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(arr).sum();
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        System.out.println(findMissing(arr));
    }
}
