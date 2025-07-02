package gtp4o.task144;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Task144Test {

    private int[] parseInput(String input) {
        if (input.isEmpty()) {
            return new int[0];
        }
        String[] parts = input.trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    private int[] callMergeArrays(String input1, String input2) {
        int[] arr1 = parseInput(input1);
        int[] arr2 = parseInput(input2);
        return Task144_OPENAI_gpt_4o.mergeArrays(arr1, arr2);
    }

    @Test
    public void test_empty_arrays() {
        assertArrayEquals(new int[]{}, callMergeArrays("", ""));
    }

    @Test
    public void test_one_empty_array() {
        assertArrayEquals(new int[]{1, 3, 5}, callMergeArrays("", "1 3 5"));
        assertArrayEquals(new int[]{2, 4, 6}, callMergeArrays("2 4 6", ""));
    }

    @Test
    public void test_single_element_arrays() {
        assertArrayEquals(new int[]{1, 1}, callMergeArrays("1", "1"));
        assertArrayEquals(new int[]{1, 2}, callMergeArrays("1", "2"));
    }

    @Test
    public void test_different_sizes_with_all_smaller_elements() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, callMergeArrays("1 2 3", "4 5 6"));
    }

    @Test
    public void test_some_overlapping_elements() {
        assertArrayEquals(new int[]{1, 2, 3, 3, 4, 5}, callMergeArrays("1 3 5", "2 3 4"));
    }

    @Test
    public void test_all_elements_same() {
        assertArrayEquals(new int[]{2, 2, 2, 2, 2, 2}, callMergeArrays("2 2 2", "2 2 2"));
    }

    @Test
    public void test_interleaving_elements() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, callMergeArrays("1 3 5 7", "2 4 6 8"));
    }

    @Test
    public void test_large_element_diff() {
        assertArrayEquals(new int[]{1, 2, 1000, 2000, 3000}, callMergeArrays("1 2", "1000 2000 3000"));
    }

    @Test
    public void test_reverse_order_arrays() {
        int[] arr1 = parseInput("9 7 5");
        int[] arr2 = parseInput("8 6 4");
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        assertArrayEquals(new int[]{4, 5, 6, 7, 8, 9}, Task144_OPENAI_gpt_4o.mergeArrays(arr1, arr2));
    }
}
