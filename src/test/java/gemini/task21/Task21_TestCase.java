package gemini.task21;

import gemini.task21.Task21_GEMINI_gemini_1_5_pro_001;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task21_TestCase {

    @Test
    void testCase1() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(2, 3, 4, 5);
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }

    @Test
    void testCase2() {
        List<Integer> input = Arrays.asList(5, 3, 2, 1, 4);
        List<Integer> expected = Arrays.asList(5, 3, 2, 4);
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }

    @Test
    void testCase3() {
        List<Integer> input = Arrays.asList(2, 2, 1, 2, 1);
        List<Integer> expected = Arrays.asList(2, 2, 2, 1);
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }

    @Test
    void testCase4() {
        List<Integer> input = Arrays.asList(1);
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }

    @Test
    void testCase5() {
        List<Integer> input = Arrays.asList(1, 1, 1, 1);
        List<Integer> expected = Arrays.asList(1, 1, 1);
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }

    @Test
    void testCase6() {
        List<Integer> input = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }

    @Test
    void testCase7() {
        List<Integer> input = Arrays.asList(2, 3, 2, 3, 1);
        List<Integer> expected = Arrays.asList(2, 3, 2, 3);
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }

    @Test
    void testCase8() {
        List<Integer> input = Arrays.asList(7, 7, 7, 7, 7);
        List<Integer> expected = Arrays.asList(7, 7, 7, 7);
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }

    @Test
    void testCase9() {
        List<Integer> input = Arrays.asList(5, 6, 7, 8, 9);
        List<Integer> expected = Arrays.asList(6, 7, 8, 9);
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }

    @Test
    void testCase10() {
        List<Integer> input = Arrays.asList(10, 10, 10);
        List<Integer> expected = Arrays.asList(10, 10);
        assertEquals(expected, Task21_GEMINI_gemini_1_5_pro_001.removeSmallest(input));
    }
}
