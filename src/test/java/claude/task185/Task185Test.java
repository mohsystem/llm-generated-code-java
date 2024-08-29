package claude.task185;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task185Test {

    private final Solution solution = new Solution();

    @Test
    void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.00000, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.50000, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testEqualElements() {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {2, 2, 2};
        assertEquals(2.00000, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFirstEmpty() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1.00000, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testSecondEmpty() {
        int[] nums1 = {2};
        int[] nums2 = {};
        assertEquals(2.00000, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testBothSameLength() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        assertEquals(3.50000, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFirstMuchSmaller() {
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5, 6};
        assertEquals(3.50000, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testSecondMuchSmaller() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6};
        assertEquals(3.50000, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testLargeNumbers() {
        int[] nums1 = {1000000};
        int[] nums2 = {-1000000};
        assertEquals(0.00000, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, -1};
        assertEquals(-2.00000, solution.findMedianSortedArrays(nums1, nums2));
    }
}
