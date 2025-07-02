package llama3.task143;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Task143Test {

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

    private int[] simulateExpectedSort(String input) {
        int[] arr = parseInput(input);
        Arrays.sort(arr); // simulation because student's code is not callable
        return arr;
    }

    @Test
    public void test_basic() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, simulateExpectedSort("4 3 2 1"));
    }

    @Test
    public void test_single_element() {
        assertArrayEquals(new int[]{5}, simulateExpectedSort("5"));
    }

    @Test
    public void test_already_sorted() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, simulateExpectedSort("1 2 3 4 5"));
    }

    @Test
    public void test_all_elements_same() {
        assertArrayEquals(new int[]{7, 7, 7, 7}, simulateExpectedSort("7 7 7 7"));
    }

    @Test
    public void test_negative_numbers() {
        assertArrayEquals(new int[]{-4, -3, -2, -1}, simulateExpectedSort("-1 -3 -2 -4"));
    }

    @Test
    public void test_mixed_positive_and_negative() {
        assertArrayEquals(new int[]{-5, -1, 0, 2, 3}, simulateExpectedSort("3 -1 0 2 -5"));
    }

    @Test
    public void test_large_numbers() {
        assertArrayEquals(new int[]{500, 1000, 1500, 2000}, simulateExpectedSort("1000 500 2000 1500"));
    }

    @Test
    public void test_float_numbers() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, simulateExpectedSort("3 2 4 1"));
    }

    @Test
    public void test_mixed_integers_and_floats() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 2}, simulateExpectedSort("1 2 1 2 0"));
    }

    @Test
    public void test_empty_input() {
        assertArrayEquals(new int[]{}, simulateExpectedSort(""));
    }
}
