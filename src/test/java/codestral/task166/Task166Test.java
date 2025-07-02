package codestral.task166;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task166Test {

    @Test
    public void test_case_1() {
        List<Integer> input = new ArrayList<>(Arrays.asList(6, 3, -2, 5, -8, 2, -2));
        List<Integer> expected = Arrays.asList(2, 3, -2, 5, -8, 6, -2);
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }

    @Test
    public void test_case_2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(6, 5, 4, -1, 3, 2, -1, 1));
        List<Integer> expected = Arrays.asList(1, 2, 3, -1, 4, 5, -1, 6);
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }

    @Test
    public void test_case_3() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-5, -5, -5, -5, 7, -5));
        List<Integer> expected = Arrays.asList(-5, -5, -5, -5, 7, -5);
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }

    @Test
    public void test_case_4() {
        List<Integer> input = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }

    @Test
    public void test_case_5() {
        List<Integer> input = new ArrayList<>(Arrays.asList(10, -10, 20, -20));
        List<Integer> expected = Arrays.asList(10, -10, 20, -20);
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }

    @Test
    public void test_case_6() {
        List<Integer> input = new ArrayList<>(Arrays.asList(9, 3, -3, -2, 7));
        List<Integer> expected = Arrays.asList(3, 7, -3, -2, 9);
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }

    @Test
    public void test_case_7() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 4, -1, -2, 1));
        List<Integer> expected = Arrays.asList(1, 4, -1, -2, 5);
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }

    @Test
    public void test_case_8() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-3, -2, -1));
        List<Integer> expected = Arrays.asList(-3, -2, -1);
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }

    @Test
    public void test_case_9() {
        List<Integer> input = new ArrayList<>(Arrays.asList(100, -50, 75, -25));
        List<Integer> expected = Arrays.asList(75, -50, 100, -25);
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }

    @Test
    public void test_case_10() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 1, -9, -8));
        List<Integer> expected = Arrays.asList(1, 2, -9, -8);
        assertEquals(expected, Task166_MISTRAL_codestral_latest.posNegSort(input));
    }
}
