package claude.task1;

import codestral.task1.Task1_MISTRAL_codestral_latest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1_ClaudeTestCase {

    @Test
    void testCase1() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
                new int[]{3, 0},
                new int[]{2, 1},
                new int[]{5, 2},
                new int[]{1, 4}
        ));
        assertEquals(4, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }

    @Test
    void testCase2() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
                new int[]{10, 0},
                new int[]{3, 5},
                new int[]{2, 1},
                new int[]{7, 10}
        ));
        assertEquals(6, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }

    @Test
    void testCase3() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0}
        ));
        assertEquals(0, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }

    @Test
    void testCase4() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
                new int[]{5, 0},
                new int[]{3, 2},
                new int[]{8, 4},
                new int[]{2, 1}
        ));
        assertEquals(11, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }

    @Test
    void testCase5() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
                new int[]{7, 0},
                new int[]{0, 0},
                new int[]{5, 3},
                new int[]{3, 7},
                new int[]{4, 0}
        ));
        assertEquals(9, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }

    @Test
    void testCase6() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
                new int[]{1, 0},
                new int[]{0, 0},
                new int[]{1, 1},
                new int[]{0, 0},
                new int[]{1, 0},
                new int[]{0, 1}
        ));
        assertEquals(1, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }

    @Test
    void testCase7() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
                new int[]{100, 0},
                new int[]{50, 30},
                new int[]{25, 25},
                new int[]{10, 15},
                new int[]{0, 10}
        ));
        assertEquals(105, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }

    @Test
    void testCase8() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
                new int[]{3, 0},
                new int[]{0, 2},
                new int[]{2, 1},
                new int[]{0, 1},
                new int[]{1, 0}
        ));
        assertEquals(2, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }

    @Test
    void testCase9() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
        ));
        assertEquals(0, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }

    @Test
    void testCase10() {
        ArrayList<int[]> stops = new ArrayList<>(Arrays.asList(
                new int[]{6},
                new int[]{2, 3},
                new int[]{1, 5},
                new int[]{7, 2}
        ));
        assertEquals(6, Task1_CLAUDE_claude_3_5_sonnet_20240620.numberOfPeopleOnBus(stops));
    }
}