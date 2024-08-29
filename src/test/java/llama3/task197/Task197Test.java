package llama3.task197;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(1.0, 0.0, 0.0);
        double[] point = solution.randPoint();
        assertTrue(isPointInCircle(point, 1.0, 0.0, 0.0));
    }

    @Test
    void testCase2() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(1.0, 0.0, 0.0);
        double[] point1 = solution.randPoint();
        double[] point2 = solution.randPoint();
        assertTrue(isPointInCircle(point1, 1.0, 0.0, 0.0));
        assertTrue(isPointInCircle(point2, 1.0, 0.0, 0.0));
    }

    @Test
    void testCase3() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(1.0, 0.0, 0.0);
        double[] point1 = solution.randPoint();
        double[] point2 = solution.randPoint();
        double[] point3 = solution.randPoint();
        assertTrue(isPointInCircle(point1, 1.0, 0.0, 0.0));
        assertTrue(isPointInCircle(point2, 1.0, 0.0, 0.0));
        assertTrue(isPointInCircle(point3, 1.0, 0.0, 0.0));
    }

    @Test
    void testCase4() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(5.0, 2.0, 3.0);
        double[] point = solution.randPoint();
        assertTrue(isPointInCircle(point, 5.0, 2.0, 3.0));
    }

    @Test
    void testCase5() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(5.0, 2.0, 3.0);
        double[] point1 = solution.randPoint();
        double[] point2 = solution.randPoint();
        assertTrue(isPointInCircle(point1, 5.0, 2.0, 3.0));
        assertTrue(isPointInCircle(point2, 5.0, 2.0, 3.0));
    }

    @Test
    void testCase6() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(5.0, 2.0, 3.0);
        double[] point1 = solution.randPoint();
        double[] point2 = solution.randPoint();
        double[] point3 = solution.randPoint();
        assertTrue(isPointInCircle(point1, 5.0, 2.0, 3.0));
        assertTrue(isPointInCircle(point2, 5.0, 2.0, 3.0));
        assertTrue(isPointInCircle(point3, 5.0, 2.0, 3.0));
    }

    @Test
    void testCase7() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(10.0, -1.0, -1.0);
        double[] point = solution.randPoint();
        assertTrue(isPointInCircle(point, 10.0, -1.0, -1.0));
    }

    @Test
    void testCase8() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(10.0, -1.0, -1.0);
        double[] point1 = solution.randPoint();
        double[] point2 = solution.randPoint();
        assertTrue(isPointInCircle(point1, 10.0, -1.0, -1.0));
        assertTrue(isPointInCircle(point2, 10.0, -1.0, -1.0));
    }

    @Test
    void testCase9() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(10.0, -1.0, -1.0);
        double[] point1 = solution.randPoint();
        double[] point2 = solution.randPoint();
        double[] point3 = solution.randPoint();
        assertTrue(isPointInCircle(point1, 10.0, -1.0, -1.0));
        assertTrue(isPointInCircle(point2, 10.0, -1.0, -1.0));
        assertTrue(isPointInCircle(point3, 10.0, -1.0, -1.0));
    }

    @Test
    void testCase10() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(3.0, 4.0, 0.0);
        double[] point = solution.randPoint();
        assertTrue(isPointInCircle(point, 3.0, 4.0, 0.0));
    }

    private boolean isPointInCircle(double[] point, double radius, double xCenter, double yCenter) {
        double x = point[0];
        double y = point[1];
        double distance = Math.sqrt((x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter));
        return distance <= radius;
    }
}
