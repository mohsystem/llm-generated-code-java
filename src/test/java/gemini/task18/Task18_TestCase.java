package gemini.task18;

import org.junit.jupiter.api.Test;
import static gemini.task18.Task18_GEMINI_gemini_1_5_pro_001.binaryArrayToInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task18_TestCase {
            @Test
    void testBasicExample1() {
        // Test with basic example where the array represents binary 1
        assertEquals(1, binaryArrayToInteger(new int[]{0, 0, 0, 1}));
    }

    @Test
    void testBasicExample2() {
        // Test with basic example where the array represents binary 2
        assertEquals(2, binaryArrayToInteger(new int[]{0, 0, 1, 0}));
    }

    @Test
    void testBasicExample3() {
        // Test with basic example where the array represents binary 5
        assertEquals(5, binaryArrayToInteger(new int[]{0, 1, 0, 1}));
    }

    @Test
    void testDuplicateValue() {
        // Test with an array where the binary value is 2
        assertEquals(2, binaryArrayToInteger(new int[]{0, 0, 1, 0}));
    }

    @Test
    void testBinary6() {
        // Test with an array where the binary value is 6
        assertEquals(6,  binaryArrayToInteger(new int[]{0, 1, 1, 0}));
    }

    @Test
    void testBinary15() {
        // Test with an array where the binary value is 15
        assertEquals(15, binaryArrayToInteger(new int[]{1, 1, 1, 1}));
    }

    @Test
    void testBinary11() {
        // Test with an array where the binary value is 11
        assertEquals(11, binaryArrayToInteger(new int[]{1, 0, 1, 1}));
    }

    @Test
    void testSingleBit1() {
        // Test with an array representing a single bit of 1
        assertEquals(1, binaryArrayToInteger(new int[]{1}));
    }

    @Test
    void testSingleBit0() {
        // Test with an array representing a single bit of 0
        assertEquals(0, binaryArrayToInteger(new int[]{0}));
    }

    @Test
    void testLongerArray() {
        // Test with a longer array representing binary 43
        assertEquals(43, binaryArrayToInteger(new int[]{0, 1, 0, 1, 0, 1, 1}));
    }
}
