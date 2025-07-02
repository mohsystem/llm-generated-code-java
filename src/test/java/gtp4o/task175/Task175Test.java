package gtp4o.task175;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task175Test {

    @Test
    public void testCase1() {
        MountainArray arr = new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        assertEquals(2, Task175_OPENAI_gpt_4o.findInMountainArray(3, arr), "Test Case 1 Failed");
    }

    @Test
    public void testCase2() {
        MountainArray arr = new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        assertEquals(0, Task175_OPENAI_gpt_4o.findInMountainArray(1, arr), "Test Case 2 Failed");
    }

    @Test
    public void testCase3() {
        MountainArray arr = new MountainArray(new int[]{0, 1, 2, 4, 2, 1});
        assertEquals(-1, Task175_OPENAI_gpt_4o.findInMountainArray(3, arr), "Test Case 3 Failed");
    }

    @Test
    public void testCase4() {
        MountainArray arr = new MountainArray(new int[]{1, 3, 5, 7, 6, 4, 2});
        assertEquals(3, Task175_OPENAI_gpt_4o.findInMountainArray(7, arr), "Test Case 4 Failed");
    }

    @Test
    public void testCase5() {
        MountainArray arr = new MountainArray(new int[]{5, 4, 3, 2, 1, 0});
        assertEquals(0, Task175_OPENAI_gpt_4o.findInMountainArray(5, arr), "Test Case 5 Failed");
    }

    @Test
    public void testCase6() {
        MountainArray arr = new MountainArray(new int[]{1, 2, 3, 4, 3, 2, 1});
        assertEquals(0, Task175_OPENAI_gpt_4o.findInMountainArray(1, arr), "Test Case 6 Failed");
    }

    @Test
    public void testCase7() {
        int[] data = new int[19999];
        for (int i = 0; i < 10000; i++) data[i] = i + 1;
        for (int i = 10000, val = 9999; i < 19999; i++, val--) data[i] = val;
        MountainArray arr = new MountainArray(data);
        assertEquals(4999, Task175_OPENAI_gpt_4o.findInMountainArray(5000, arr), "Test Case 7 Failed");
    }

    @Test
    public void testCase8() {
        int[] data = new int[19999];
        for (int i = 0; i < 10000; i++) data[i] = i + 1;
        for (int i = 10000, val = 9999; i < 19999; i++, val--) data[i] = val;
        MountainArray arr = new MountainArray(data);
        assertEquals(9997, Task175_OPENAI_gpt_4o.findInMountainArray(9998, arr), "Test Case 8 Failed");
    }

    @Test
    public void testCase9() {
        int[] data = new int[19999];
        for (int i = 0; i < 10000; i++) data[i] = i + 1;
        for (int i = 10000, val = 9999; i < 19999; i++, val--) data[i] = val;
        MountainArray arr = new MountainArray(data);
        assertEquals(-1, Task175_OPENAI_gpt_4o.findInMountainArray(10000, arr), "Test Case 9 Failed");
    }

    @Test
    public void testCase10() {
        MountainArray arr = new MountainArray(new int[]{1, 2, 3});
        assertEquals(1, Task175_OPENAI_gpt_4o.findInMountainArray(2, arr), "Test Case 10 Failed");
    }
}
