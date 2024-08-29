package claude.task198;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Task198Test {

    @Test
    void testRand10UniformDistribution() {
        int n = 100000;
        int[] counts = new int[10];
        for (int i = 0; i < n; i++) {
            int result = Solution.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should return a value between 1 and 10");
            counts[result - 1]++;
        }

        for (int count : counts) {
            assertTrue(count >= n / 15 && count <= n / 7, "The distribution of rand10() is not uniform.");
        }
    }

    @Test
    void testRand10SingleCall() {
        Set<Integer> possibleResults = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            possibleResults.add(Solution.rand10());
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(possibleResults.contains(i), "rand10() should be able to produce all numbers between 1 and 10.");
        }
    }

    @Test
    void testRand10MultipleCalls() {
        int n = 10;
        for (int i = 0; i < n; i++) {
            int result = Solution.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should return a value between 1 and 10 on multiple calls.");
        }
    }

    @Test
    void testRand10Performance() {
        long startTime = System.currentTimeMillis();
        int n = 1000000;
        for (int i = 0; i < n; i++) {
            Solution.rand10();
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        assertTrue(elapsedTime < 2000, "rand10() performance should be within acceptable limits.");
    }

    @Test
    void testRand10Consistency() {
        int first = Solution.rand10();
        for (int i = 0; i < 100; i++) {
            int result = Solution.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should be consistent in its output.");
        }
    }

    @Test
    void testRand10BoundaryConditions() {
        for (int i = 0; i < 1000; i++) {
            int result = Solution.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should always return values within the range 1 to 10.");
        }
    }

    @Test
    void testRand10Randomness() {
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            resultSet.add(Solution.rand10());
        }
        assertTrue(resultSet.size() == 10, "rand10() should produce all numbers between 1 and 10 over time.");
    }

    @Test
    void testRand10ExtremeValues() {
        for (int i = 0; i < 1000; i++) {
            int result = Solution.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should never produce values outside the range 1 to 10.");
        }
    }

    @Test
    void testRand10MultipleExecutions() {
        for (int i = 0; i < 100; i++) {
            int result = Solution.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should behave correctly on repeated executions.");
        }
    }

    @Test
    void testRand10EdgeCaseCheck() {
        Set<Integer> edgeCases = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            int result = Solution.rand10();
            if (result == 1 || result == 10) {
                edgeCases.add(result);
            }
        }
        assertTrue(edgeCases.contains(1) && edgeCases.contains(10), "rand10() should be able to produce edge values 1 and 10.");
    }
}
