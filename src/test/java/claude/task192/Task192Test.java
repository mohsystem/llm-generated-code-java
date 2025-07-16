package claude.task192;

import java.util.Arrays;

public class Task192Test {

    // Solution class exactly as given
    static class Solution {
        public boolean xorGame(int[] nums) {
            int xorSum = 0;
            for (int num : nums) {
                xorSum ^= num;
            }
            return xorSum == 0 || nums.length % 2 == 0;
        }
    }

    // Test cases matching python prompt examples

    public void test_example1() {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2};
        boolean result = sol.xorGame(nums);
        if (result == false) {
            System.out.println("test_example1: PASS");
        } else {
            System.out.println("test_example1: FAIL");
        }
    }

    public void test_example2() {
        Solution sol = new Solution();
        int[] nums = {0, 1};
        boolean result = sol.xorGame(nums);
        if (result == true) {
            System.out.println("test_example2: PASS");
        } else {
            System.out.println("test_example2: FAIL");
        }
    }

    public void test_example3() {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        boolean result = sol.xorGame(nums);
        if (result == true) {
            System.out.println("test_example3: PASS");
        } else {
            System.out.println("test_example3: FAIL");
        }
    }

    public static void main(String[] args) {
        Task192Test test = new Task192Test();

        test.test_example1();
        test.test_example2();
        test.test_example3();
    }
}
