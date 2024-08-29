package codestral.task198;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task198Test {
    @Test
    void testRand10Distribution() {
        int n = 100000;
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            int result = Task198_MISTRAL_codestral_latest.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should return a value between 1 and 10");
            count[result - 1]++;
        }

        for (int c : count) {
            assertTrue(c >= n / 15 && c <= n / 7, "The distribution of rand10() should be reasonably uniform.");
        }
    }

    @Test
    void testRand10SingleCall() {
        Set<Integer> possibleResults = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            possibleResults.add(Task198_MISTRAL_codestral_latest.rand10());
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(possibleResults.contains(i), "rand10() should be able to produce all values between 1 and 10.");
        }
    }

    @Test
    void testRand10MultipleCalls() {
        for (int i = 0; i < 10; i++) {
            int result = Task198_MISTRAL_codestral_latest.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should return a value between 1 and 10.");
        }
    }

    @Test
    void testRand10Performance() {
        long startTime = System.currentTimeMillis();
        int n = 1000000;
        for (int i = 0; i < n; i++) {
            Task198_MISTRAL_codestral_latest.rand10();
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        assertTrue(elapsedTime < 2000, "rand10() should execute within a reasonable time frame.");
    }

    @Test
    void testRand10Consistency() {
        int first = Task198_MISTRAL_codestral_latest.rand10();
        for (int i = 0; i < 100; i++) {
            int result = Task198_MISTRAL_codestral_latest.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should consistently return values within the range.");
        }
    }

    @Test
    void testRand10EdgeCases() {
        Set<Integer> edgeCases = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            int result = Task198_MISTRAL_codestral_latest.rand10();
            if (result == 1 || result == 10) {
                edgeCases.add(result);
            }
        }
        assertTrue(edgeCases.contains(1) && edgeCases.contains(10), "rand10() should include edge values 1 and 10.");
    }

    @Test
    void testRand10Randomness() {
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            resultSet.add(Task198_MISTRAL_codestral_latest.rand10());
        }
        assertTrue(resultSet.size() == 10, "rand10() should generate all numbers between 1 and 10 over time.");
    }

    @Test
    void testRand10BoundaryConditions() {
        for (int i = 0; i < 1000; i++) {
            int result = Task198_MISTRAL_codestral_latest.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should return values strictly within the range 1 to 10.");
        }
    }

    @Test
    void testRand10RepeatedExecutions() {
        for (int i = 0; i < 100; i++) {
            int result = Task198_MISTRAL_codestral_latest.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should perform correctly under repeated executions.");
        }
    }

    @Test
    void testRand10ExtremeValues() {
        for (int i = 0; i < 1000; i++) {
            int result = Task198_MISTRAL_codestral_latest.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should consistently stay within the expected range.");
        }
    }
}
