package claude.task169;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] counts;
    
    public List<Integer> countSmaller(int[] nums) {
        counts = new int[nums.length];
        int[][] enumerated = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            enumerated[i] = new int[]{i, nums[i]};
        }
        mergeSort(enumerated, 0, nums.length - 1);
        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }
    
    private void mergeSort(int[][] enum1, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(enum1, left, mid);
        mergeSort(enum1, mid + 1, right);
        merge(enum1, left, mid, right);
    }
    
    private void merge(int[][] enum1, int left, int mid, int right) {
        int[][] temp = new int[right - left + 1][2];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (enum1[i][1] <= enum1[j][1]) {
                temp[k] = enum1[i];
                counts[enum1[i][0]] += j - (mid + 1);
                i++;
            } else {
                temp[k] = enum1[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = enum1[i];
            counts[enum1[i][0]] += right - mid;
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = enum1[j];
            j++;
            k++;
        }
        System.arraycopy(temp, 0, enum1, left, temp.length);
    }
}
