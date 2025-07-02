package claude.task144;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

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

    private List<Integer> callMergeSortedArrays(String input1, String input2) {
        int[] arr1 = parseInput(input1);
        int[] arr2 = parseInput(input2);
        return Task144_CLAUDE_claude_3_5_sonnet_20240620.mergeSortedArrays(arr1, arr2);
    }

    private List<Integer> convertArrayToList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    @Test
    public void test_empty_arrays() {
        assertEquals(convertArrayToList(new int[]{}), callMergeSortedArrays("", ""));
    }

    @Test
    public void test_one_empty_array() {
        assertEquals(convertArrayToList(new int[]{1, 3, 5}), callMergeSortedArrays("", "1 3 5"));
        assertEquals(convertArrayToList(new int[]{2, 4, 6}), callMergeSortedArrays("2 4 6", ""));
    }

    @Test
    public void test_single_element_arrays() {
        assertEquals(convertArrayToList(new int[]{1, 1}), callMergeSortedArrays("1", "1"));
        assertEquals(convertArrayToList(new int[]{1, 2}), callMergeSortedArrays("1", "2"));
    }

    @Test
    public void test_different_sizes_with_all_smaller_elements() {
        assertEquals(convertArrayToList(new int[]{1, 2, 3, 4, 5, 6}), callMergeSortedArrays("1 2 3", "4 5 6"));
    }

    @Test
    public void test_some_overlapping_elements() {
        assertEquals(convertArrayToList(new int[]{1, 2, 3, 3, 4, 5}), callMergeSortedArrays("1 3 5", "2 3 4"));
    }

    @Test
    public void test_all_elements_same() {
        assertEquals(convertArrayToList(new int[]{2, 2, 2, 2, 2, 2}), callMergeSortedArrays("2 2 2", "2 2 2"));
    }

    @Test
    public void test_interleaving_elements() {
        assertEquals(convertArrayToList(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), callMergeSortedArrays("1 3 5 7", "2 4 6 8"));
    }

    @Test
    public void test_large_element_diff() {
        assertEquals(convertArrayToList(new int[]{1, 2, 1000, 2000, 3000}), callMergeSortedArrays("1 2", "1000 2000 3000"));
    }

    @Test
    public void test_reverse_order_arrays() {
         int[] arr1 = parseInput("9 7 5");
        int[] arr2 = parseInput("8 6 4");
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        List<Integer> expected = convertArrayToList(new int[]{4, 5, 6, 7, 8, 9});
        List<Integer> actual = Task144_CLAUDE_claude_3_5_sonnet_20240620.mergeSortedArrays(arr1, arr2);
        assertEquals(expected, actual);
    }
}
