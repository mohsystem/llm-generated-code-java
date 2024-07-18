package claude.task145;

import java.util.Scanner;

public class Task145_CLAUDE_claude_3_5_sonnet_20240620 {
    public static int maxSubarraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : arr) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxSubarraySum(arr));
        scanner.close();
    }
}
