package gtp4o.task147;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Task147Test {

    @Test
    void testCase1() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        assertEquals(5, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }

    @Test
    void testCase2() {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3;
        assertEquals(10, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }

    @Test
    void testCase3() {
        int[] nums = {1, 1, 1, 1};
        int k = 2;
        assertEquals(1, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }

    @Test
    void testCase4() {
        int[] nums = {-1, -3, -2, -4, -5};
        int k = 1;
        assertEquals(-1, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }

    @Test
    void testCase5() {
        int[] nums = {-10, -50, 20, 10, 30, 0};
        int k = 4;
        assertEquals(0, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }

    @Test
    void testCase6() {
        int[] nums = {100};
        int k = 1;
        assertEquals(100, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }

    @Test
    void testCase7() {
        int[] nums = {1, 23, 12, 9, 30, 2, 50};
        int k = 7;
        assertEquals(1, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }

    @Test
    void testCase8() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        assertEquals(5, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }

    @Test
    void testCase9() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        assertEquals(4, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }

    @Test
    void testCase10() {
        int[] nums = {3, 6, 1, 0, 10, 7, 8, 2, 4, 5, 9};
        int k = 10;
        assertEquals(1, Task147_OPENAI_gpt_4o.findKthLargest(nums, k));
    }
}
