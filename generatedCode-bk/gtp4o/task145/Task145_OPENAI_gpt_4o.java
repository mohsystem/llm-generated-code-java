package gtp4o.task145;

import java.util.*;

public class Task145_OPENAI_gpt_4o {
    public static void main(String[] args) {
        int[] nums = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        System.out.println("Java: " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}