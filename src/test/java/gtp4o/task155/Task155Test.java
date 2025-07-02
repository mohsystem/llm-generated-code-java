package gtp4o.task155;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Task155Test {

    private void assertHeapSort(ArrayList<Integer> input, ArrayList<Integer> expected) {
        Task155_OPENAI_gpt_4o.heapSort(input);
        assertEquals(expected, input, "Heap sort failed");
    }

    @Test
    public void testSortedArray() {
        assertHeapSort(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)),
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void testReverseArray() {
        assertHeapSort(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1)),
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void testRandomOrder() {
        assertHeapSort(new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9)),
                new ArrayList<>(Arrays.asList(1, 1, 3, 4, 5, 9)));
    }

    @Test
    public void testWithDuplicates() {
        assertHeapSort(new ArrayList<>(Arrays.asList(2, 2, 2, 1, 1)),
                new ArrayList<>(Arrays.asList(1, 1, 2, 2, 2)));
    }

    @Test
    public void testSingleElement() {
        assertHeapSort(new ArrayList<>(Arrays.asList(7)),
                new ArrayList<>(Arrays.asList(7)));
    }

    @Test
    public void testEmptyArray() {
        assertHeapSort(new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void testNegativeNumbers() {
        assertHeapSort(new ArrayList<>(Arrays.asList(-1, -3, -2, 0)),
                new ArrayList<>(Arrays.asList(-3, -2, -1, 0)));
    }
}
