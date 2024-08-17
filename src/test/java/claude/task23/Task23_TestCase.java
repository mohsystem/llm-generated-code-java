package claude.task23;

import claude.task21.Task21_CLAUDE_claude_3_5_sonnet_20240620;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task23_TestCase {

    @Test
    void testCase1() {
        long m = 1071225;
        long expected = 45;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }

    @Test
    void testCase2() {
        long m = 91716553919377L;
        long expected = -1;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }

    @Test
    void testCase3() {
        long m = 1;
        long expected = 1;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }

    @Test
    void testCase4() {
        long m = 9;
        long expected = 2;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }

    @Test
    void testCase5() {
        long m = 36;
        long expected = 3;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }
    @Test
    void testCase6() {
        long m = 1000;
        long expected = 10;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }

    @Test
    void testCase7() {
        long m = 2025;
        long expected = -1;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }

    @Test
    void testCase8() {
        long m = 1000000;
        long expected = 20;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }

    @Test
    void testCase9() {
        long m = 2552550;
        long expected = -1;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }

    @Test
    void testCase10() {
        long m = 3375;
        long expected = 6;
        assertEquals(expected, Task23_CLAUDE_claude_3_5_sonnet_20240620.findNb(m));
    }

}
