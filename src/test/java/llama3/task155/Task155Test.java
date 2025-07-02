package llama3.task155;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task155Test {

    private final HeapSort sorter = new HeapSort();

    private void assertHeapSort(int[] input, int[] expected) {
        sorter.heapSort(input);
        assertArrayEquals(expected, input, "Heap sort failed");
    }

    @Test
    public void testSortedArray() {
        assertHeapSort(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testReverseArray() {
        assertHeapSort(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testRandomOrder() {
        assertHeapSort(new int[]{3, 1, 4, 1, 5, 9}, new int[]{1, 1, 3, 4, 5, 9});
    }

    @Test
    public void testWithDuplicates() {
        assertHeapSort(new int[]{2, 2, 2, 1, 1}, new int[]{1, 1, 2, 2, 2});
    }

    @Test
    public void testSingleElement() {
        assertHeapSort(new int[]{7}, new int[]{7});
    }

    @Test
    public void testEmptyArray() {
        assertHeapSort(new int[]{}, new int[]{});
    }

    @Test
    public void testNegativeNumbers() {
        assertHeapSort(new int[]{-1, -3, -2, 0}, new int[]{-3, -2, -1, 0});
    }
}
