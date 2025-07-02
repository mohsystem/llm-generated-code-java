package gemini.task165;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task165Test {

    final Solution solution = new Solution();

    @Test
    public void testCase1() {
        assertTrue(solution.checkFlush(
                new String[]{"A_S", "J_H", "7_D", "8_D", "10_D"},
                new String[]{"J_D", "3_D"}));
    }

    @Test
    public void testCase2() {
        assertTrue(solution.checkFlush(
                new String[]{"10_S", "7_S", "9_H", "4_S", "3_S"},
                new String[]{"K_S", "Q_S"}));
    }

    @Test
    public void testCase3() {
        assertFalse(solution.checkFlush(
                new String[]{"3_S", "10_H", "10_D", "10_C", "10_S"},
                new String[]{"3_S", "4_D"}));
    }

    @Test
    public void testCase4() {
        assertTrue(solution.checkFlush(
                new String[]{"2_H", "3_H", "4_H", "5_H", "6_D"},
                new String[]{"7_H", "8_H"}));
    }

    @Test
    public void testCase5() {
        assertFalse(solution.checkFlush(
                new String[]{"9_S", "8_H", "7_D", "6_C", "5_S"},
                new String[]{"4_D", "3_H"}));
    }

    @Test
    public void testCase6() {
        assertTrue(solution.checkFlush(
                new String[]{"K_C", "Q_C", "J_C", "9_C", "2_H"},
                new String[]{"8_C", "7_C"}));
    }

    @Test
    public void testCase7() {
        assertFalse(solution.checkFlush(
                new String[]{"A_S", "2_S", "3_S", "4_H", "5_H"},
                new String[]{"6_S", "7_H"}));
    }

    @Test
    public void testCase8() {
        assertTrue(solution.checkFlush(
                new String[]{"2_D", "3_D", "4_D", "5_D", "6_D"},
                new String[]{"7_H", "8_H"}));
    }

    @Test
    public void testCase9() {
        assertFalse(solution.checkFlush(
                new String[]{"A_S", "K_H", "Q_D", "J_C", "10_S"},
                new String[]{"9_H", "8_C"}));
    }

    @Test
    public void testCase10() {
        assertTrue(solution.checkFlush(
                new String[]{"A_S", "K_S", "Q_S", "J_S", "10_S"},
                new String[]{"9_S", "8_S"}));
    }
}
