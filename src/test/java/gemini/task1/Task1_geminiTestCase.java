package gemini.task1;

import gemini.task1.Task1_GEMINI_gemini_1_5_pro_001;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1_geminiTestCase {

    @Test
    void testCase1() {
        int[][] busStops = { { 3, 0 }, { 2, 1 }, { 5, 2 }, { 1, 4 } };
        assertEquals(4, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }

    @Test
    void testCase2() {
        int[][] busStops = { { 10, 0 }, { 3, 5 }, { 2, 1 }, { 7, 10 } };
        assertEquals(6, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }

    @Test
    void testCase3() {
        int[][] busStops = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };
        assertEquals(0, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }

    @Test
    void testCase4() {
        int[][] busStops = { { 5, 0 }, { 3, 2 }, { 8, 4 }, { 2, 1 } };
        assertEquals(11, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }

    @Test
    void testCase5() {
        int[][] busStops = { { 7, 0 }, { 0, 0 }, { 5, 3 }, { 3, 7 }, { 4, 0 } };
        assertEquals(9, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }

    @Test
    void testCase6() {
        int[][] busStops = { { 1, 0 }, { 0, 0 }, { 1, 1 }, { 0, 0 }, { 1, 0 }, { 0, 1 } };
        assertEquals(1, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }

    @Test
    void testCase7() {
        int[][] busStops = { { 100, 0 }, { 50, 30 }, { 25, 25 }, { 10, 15 }, { 0, 10 } };
        assertEquals(105, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }

    @Test
    void testCase8() {
        int[][] busStops = { { 3, 0 }, { 0, 2 }, { 2, 1 }, { 0, 1 }, { 1, 0 } };
        assertEquals(2, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }

    @Test
    void testCase9() {
        int[][] busStops = { };
        assertEquals(0, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }

    @Test
    void testCase10() {
        int[][] busStops = { { 6}, { 2, 3 }, { 1, 5 }, { 7, 2 } };
        assertEquals(6, Task1_GEMINI_gemini_1_5_pro_001.numberOfPeopleOnBus(busStops));
    }
}
