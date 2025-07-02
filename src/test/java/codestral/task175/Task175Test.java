package codestral.task175;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task175Test {

    Task175_MISTRAL_codestral_latest solution = new Task175_MISTRAL_codestral_latest();

    @Test
    public void testCase1() {
        MountainArray arr = new MountainArrayImpl(Arrays.asList(1, 2, 3, 4, 5, 3, 1));
        assertEquals(2, solution.findInMountainArray(3, arr), "Test Case 1 Failed");
    }

    @Test
    public void testCase2() {
        MountainArray arr = new MountainArrayImpl(Arrays.asList(1, 2, 3, 4, 5, 3, 1));
        assertEquals(0, solution.findInMountainArray(1, arr), "Test Case 2 Failed");
    }

    @Test
    public void testCase3() {
        MountainArray arr = new MountainArrayImpl(Arrays.asList(0, 1, 2, 4, 2, 1));
        assertEquals(-1, solution.findInMountainArray(3, arr), "Test Case 3 Failed");
    }

    @Test
    public void testCase4() {
        MountainArray arr = new MountainArrayImpl(Arrays.asList(1, 3, 5, 7, 6, 4, 2));
        assertEquals(3, solution.findInMountainArray(7, arr), "Test Case 4 Failed");
    }

    @Test
    public void testCase5() {
        MountainArray arr = new MountainArrayImpl(Arrays.asList(5, 4, 3, 2, 1, 0));
        assertEquals(0, solution.findInMountainArray(5, arr), "Test Case 5 Failed");
    }

    @Test
    public void testCase6() {
        MountainArray arr = new MountainArrayImpl(Arrays.asList(1, 2, 3, 4, 3, 2, 1));
        assertEquals(0, solution.findInMountainArray(1, arr), "Test Case 6 Failed");
    }

    @Test
    public void testCase7() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) list.add(i);
        for (int i = 9999; i >= 1; i--) list.add(i);
        MountainArray arr = new MountainArrayImpl(list);
        assertEquals(4999, solution.findInMountainArray(5000, arr), "Test Case 7 Failed");
    }

    @Test
    public void testCase8() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) list.add(i);
        for (int i = 9999; i >= 1; i--) list.add(i);
        MountainArray arr = new MountainArrayImpl(list);
        assertEquals(9997, solution.findInMountainArray(9998, arr), "Test Case 8 Failed");
    }

    @Test
    public void testCase9() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) list.add(i);
        for (int i = 9999; i >= 1; i--) list.add(i);
        MountainArray arr = new MountainArrayImpl(list);
        assertEquals(-1, solution.findInMountainArray(10000, arr), "Test Case 9 Failed");
    }

    @Test
    public void testCase10() {
        MountainArray arr = new MountainArrayImpl(Arrays.asList(1, 2, 3));
        assertEquals(1, solution.findInMountainArray(2, arr), "Test Case 10 Failed");
    }
}
