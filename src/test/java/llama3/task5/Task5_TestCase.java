package llama3.task5;

import org.junit.jupiter.api.Test;

import static llama3.task5.Task5_PERPLEXITY_llama_3_sonar_large_32k_chat.persistence;
import static org.junit.jupiter.api.Assertions.*;

class Task5_TestCase {

    @Test
    void testCase1() {
        assertEquals(3, persistence(39));  // Example: 3 steps
    }

    @Test
    void testCase2() {
        assertEquals(4, persistence(999));  // Example: 4 steps
    }

    @Test
    void testCase3() {
        assertEquals(0, persistence(4));  // Single digit, no steps needed
    }

    @Test
    void testCase4() {
        assertEquals(2, persistence(25));  // One step to reach single digit
    }

    @Test
    void testCase5() {
        assertEquals(4, persistence(77));  // Two steps needed
    }

    @Test
    void testCase6() {
        assertEquals(0, persistence(8));  // Already a single digit
    }

    @Test
    void testCase7() {
        assertEquals(1, persistence(10));  // One step, 1*0=0
    }

    @Test
    void testCase8() {
        assertEquals(1, persistence(123));  // 1*2*3=6 -> 6 is single digit
    }

    @Test
    void testCase9() {
        assertEquals(6, persistence(6788));  // Larger number with multiple steps
    }

    @Test
    void testCase10() {
        assertEquals(1, persistence(9909));  // 1*1=1, single digit
    }
}