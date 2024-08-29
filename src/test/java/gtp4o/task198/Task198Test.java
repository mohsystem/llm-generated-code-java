package gtp4o.task198;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task198_OPENAI_gpt_4oTest {

    @Test
    void testRand10Distribution() {
        int n = 100000;
        int[] counts = new int[10];
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        for (int i = 0; i < n; i++) {
            int result = task.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should return a value between 1 and 10.");
            counts[result - 1]++;
        }

        for (int count : counts) {
            assertTrue(count >= n / 15 && count <= n / 7, "The distribution of rand10() should be reasonably uniform.");
        }
    }

    @Test
    void testRand10SingleCall() {
        Set<Integer> possibleResults = new HashSet<>();
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        for (int i = 0; i < 100; i++) {
            possibleResults.add(task.rand10());
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(possibleResults.contains(i), "rand10() should be able to produce all values between 1 and 10.");
        }
    }

    @Test
    void testRand10MultipleCalls() {
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        for (int i = 0; i < 10; i++) {
            int result = task.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should return a value between 1 and 10.");
        }
    }

    @Test
    void testRand10Performance() {
        long startTime = System.currentTimeMillis();
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        int n = 1000000;
        for (int i = 0; i < n; i++) {
            task.rand10();
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        assertTrue(elapsedTime < 2000, "rand10() should execute within a reasonable time frame.");
    }

    @Test
    void testRand10Consistency() {
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        int first = task.rand10();
        for (int i = 0; i < 100; i++) {
            int result = task.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should consistently return values within the range.");
        }
    }

    @Test
    void testRand10EdgeCases() {
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        Set<Integer> edgeCases = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            int result = task.rand10();
            if (result == 1 || result == 10) {
                edgeCases.add(result);
            }
        }
        assertTrue(edgeCases.contains(1) && edgeCases.contains(10), "rand10() should include edge values 1 and 10.");
    }

    @Test
    void testRand10Randomness() {
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            resultSet.add(task.rand10());
        }
        assertTrue(resultSet.size() == 10, "rand10() should generate all numbers between 1 and 10 over time.");
    }

    @Test
    void testRand10BoundaryConditions() {
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        for (int i = 0; i < 1000; i++) {
            int result = task.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should return values strictly within the range 1 to 10.");
        }
    }

    @Test
    void testRand10RepeatedExecutions() {
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        for (int i = 0; i < 100; i++) {
            int result = task.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should perform correctly under repeated executions.");
        }
    }

    @Test
    void testRand10ExtremeValues() {
        Task198_OPENAI_gpt_4o task = new Task198_OPENAI_gpt_4o();
        for (int i = 0; i < 1000; i++) {
            int result = task.rand10();
            assertTrue(result >= 1 && result <= 10, "rand10() should consistently stay within the expected range.");
        }
    }
}
