package claude.task197;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testRandPointWithinCircle() {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 1.0, "Point should be within the circle of radius 1.");
        }
    }

    @Test
    void testRandPointCenterOffset() {
        Solution solution = new Solution(1.0, 1.0, 1.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x - 1) * (x - 1) + (y - 1) * (y - 1) <= 1.0, "Point should be within the circle centered at (1, 1).");
        }
    }

    @Test
    void testRandPointLargeRadius() {
        Solution solution = new Solution(100.0, 0.0, 0.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 10000.0, "Point should be within the circle of radius 100.");
        }
    }

    @Test
    void testRandPointSmallRadius() {
        Solution solution = new Solution(0.1, 0.0, 0.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 0.01, "Point should be within the circle of very small radius.");
        }
    }

    @Test
    void testRandPointNegativeCenter() {
        Solution solution = new Solution(1.0, -5.0, -5.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x + 5) * (x + 5) + (y + 5) * (y + 5) <= 1.0, "Point should be within the circle centered at (-5, -5).");
        }
    }

    @Test
    void testRandPointLargeCenter() {
        Solution solution = new Solution(1.0, 1e6, 1e6);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x - 1e6) * (x - 1e6) + (y - 1e6) * (y - 1e6) <= 1.0, "Point should be within the circle centered at (1e6, 1e6).");
        }
    }

    @Test
    void testRandPointZeroRadius() {
        Solution solution = new Solution(0.0, 0.0, 0.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertEquals(0.0, x, "Point should be exactly at the center.");
            assertEquals(0.0, y, "Point should be exactly at the center.");
        }
    }

    @Test
    void testRandPointHighRadius() {
        Solution solution = new Solution(1e8, 0.0, 0.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 1e16, "Point should be within the circle of radius 1e8.");
        }
    }

    @Test
    void testRandPointNonZeroCenter() {
        Solution solution = new Solution(10.0, 10.0, 10.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x - 10) * (x - 10) + (y - 10) * (y - 10) <= 100.0, "Point should be within the circle centered at (10, 10).");
        }
    }

    @Test
    void testRandPointMultipleCalls() {
        Solution solution = new Solution(50.0, 0.0, 0.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 2500.0, "Point should be within the circle of radius 50.");
        }
    }

    @Test
    void testRandPointEdgeValues() {
        Solution solution = new Solution(100.0, 0.0, 0.0);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 10000.0, "Point should be within the circle of radius 100, checking edge cases.");
        }
    }
}
