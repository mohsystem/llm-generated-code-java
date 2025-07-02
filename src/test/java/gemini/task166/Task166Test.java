package gemini.task166;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class Task166Test {

    Solution solution = new Solution();

    @Test
    public void test_case_1() {
        int[] input = {6, 3, -2, 5, -8, 2, -2};
        int[] expected = {2, 3, -2, 5, -8, 6, -2};
        assertArrayEquals(expected, solution.posNegSort(input));
    }

    @Test
    public void test_case_2() {
        int[] input = {6, 5, 4, -1, 3, 2, -1, 1};
        int[] expected = {1, 2, 3, -1, 4, 5, -1, 6};
        assertArrayEquals(expected, solution.posNegSort(input));
    }

    @Test
    public void test_case_3() {
        int[] input = {-5, -5, -5, -5, 7, -5};
        int[] expected = {-5, -5, -5, -5, 7, -5};
        assertArrayEquals(expected, solution.posNegSort(input));
    }

    @Test
    public void test_case_4() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, solution.posNegSort(input));
    }

    @Test
    public void test_case_5() {
        int[] input = {10, -10, 20, -20};
        int[] expected = {10, -10, 20, -20};
        assertArrayEquals(expected, solution.posNegSort(input));
    }

    @Test
    public void test_case_6() {
        int[] input = {9, 3, -3, -2, 7};
        int[] expected = {3, 7, -3, -2, 9};
        assertArrayEquals(expected, solution.posNegSort(input));
    }

    @Test
    public void test_case_7() {
        int[] input = {5, 4, -1, -2, 1};
        int[] expected = {1, 4, -1, -2, 5};
        assertArrayEquals(expected, solution.posNegSort(input));
    }

    @Test
    public void test_case_8() {
        int[] input = {-3, -2, -1};
        int[] expected = {-3, -2, -1};
        assertArrayEquals(expected, solution.posNegSort(input));
    }

    @Test
    public void test_case_9() {
        int[] input = {100, -50, 75, -25};
        int[] expected = {75, -50, 100, -25};
        assertArrayEquals(expected, solution.posNegSort(input));
    }

    @Test
    public void test_case_10() {
        int[] input = {2, 1, -9, -8};
        int[] expected = {1, 2, -9, -8};
        assertArrayEquals(expected, solution.posNegSort(input));
    }
}
