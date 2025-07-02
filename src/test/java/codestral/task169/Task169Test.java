package codestral.task169;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class Task169Test {

    @Test
    public void testCase1() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(2, 1, 1, 0), solution.countSmaller(new int[]{5, 2, 6, 1}));
    }

    @Test
    public void testCase2() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(0), solution.countSmaller(new int[]{-1}));
    }

    @Test
    public void testCase3() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(0, 0), solution.countSmaller(new int[]{-1, -1}));
    }

    @Test
    public void testCase4() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(0, 0, 0, 0), solution.countSmaller(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testCase5() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(3, 2, 1, 0), solution.countSmaller(new int[]{4, 3, 2, 1}));
    }

    @Test
    public void testCase6() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(2, 0, 0), solution.countSmaller(new int[]{2, 0, 1}));
    }

    @Test
    public void testCase7() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(3, 1, 0, 0), solution.countSmaller(new int[]{10, 3, 2, 5}));
    }

    @Test
    public void testCase8() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(0, 0, 0, 0), solution.countSmaller(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void testCase9() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(3, 0, 1, 1, 0), solution.countSmaller(new int[]{6, 1, 2, 7, 1}));
    }

    @Test
    public void testCase10() {
        Task169_MISTRAL_codestral_latest solution = new Task169_MISTRAL_codestral_latest();
        assertEquals(List.of(1, 3, 0, 1, 0), solution.countSmaller(new int[]{5, 9, 2, 8, 6}));
    }
}
