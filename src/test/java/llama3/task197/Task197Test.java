package llama3.task197;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Task197Test {

    @Test
    void testRandPointBasic() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(1.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 1.0, "Point should be within the circle of radius 1.");
        }
    }

    @Test
    void testRandPointCenterOffset() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(1.0, 1.0, 1.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x - 1) * (x - 1) + (y - 1) * (y - 1) <= 1.0, "Point should be within the circle centered at (1, 1).");
        }
    }

    @Test
    void testRandPointLargeRadius() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(10.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 100.0, "Point should be within the circle of radius 10.");
        }
    }

    @Test
    void testRandPointSmallRadius() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(0.1, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 0.01, "Point should be within the circle of radius 0.1.");
        }
    }

    @Test
    void testRandPointNegativeCenter() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(1.0, -5.0, -5.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x + 5) * (x + 5) + (y + 5) * (y + 5) <= 1.0, "Point should be within the circle centered at (-5, -5).");
        }
    }

    @Test
    void testRandPointLargeCenter() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(1.0, 1e6, 1e6);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x - 1e6) * (x - 1e6) + (y - 1e6) * (y - 1e6) <= 1.0, "Point should be within the circle centered at (1e6, 1e6).");
        }
    }

    @Test
    void testRandPointZeroRadius() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(0.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x == 0.0 && y == 0.0, "Point should be at the center (0,0) when radius is 0.");
        }
    }

    @Test
    void testRandPointCenterAtOrigin() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(2.5, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 6.25, "Point should be within the circle of radius 2.5 centered at origin.");
        }
    }

    @Test
    void testRandPointRadiusFive() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(5.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 25.0, "Point should be within the circle of radius 5 centered at origin.");
        }
    }

    @Test
    void testRandPointCenterNonZero() {
        Task197_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task197_PERPLEXITY_llama_3_sonar_large_32k_chat(3.0, 4.0, 5.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x - 4) * (x - 4) + (y - 5) * (y - 5) <= 9.0, "Point should be within the circle of radius 3 centered at (4, 5).");
        }
    }
}
