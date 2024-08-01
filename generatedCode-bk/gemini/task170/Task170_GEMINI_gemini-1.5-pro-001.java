package gemini.task170;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (lower <= sums[j] - sums[i] && sums[j] - sums[i] <= upper) {
                    count++;
                }
            }
        }
        
        return count;
    }
}