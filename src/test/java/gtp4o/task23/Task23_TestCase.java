package gtp4o.task23;

import gtp4o.task23.Task23_OPENAI_gpt_4o;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task23_TestCase {

    @Test
    void testCase1() {
        long m = 1071225;
        long expected = 45;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }

    @Test
    void testCase2() {
        long m = 91716553919377L;
        long expected = -1;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }

    @Test
    void testCase3() {
        long m = 1;
        long expected = 1;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }

    @Test
    void testCase4() {
        long m = 9;
        long expected = 2;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }

    @Test
    void testCase5() {
        long m = 36;
        long expected = 3;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }

    @Test
    void testCase6() {
        long m = 1000;
        long expected = 10;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }

    @Test
    void testCase7() {
        long m = 2025;
        long expected = -1;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }

    @Test
    void testCase8() {
        long m = 1000000;
        long expected = 20;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }

    @Test
    void testCase9() {
        long m = 2552550;
        long expected = -1;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }

    @Test
    void testCase10() {
        long m = 3375;
        long expected = 6;
        assertEquals(expected, Task23_OPENAI_gpt_4o.findNb(m));
    }
}
