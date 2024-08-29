package gemini.task197;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testRandPointBasic() {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 1.0, "Point should be within the circle of radius 1.");
        }
    }

    @Test
    void testRandPointCenterOffset() {
        Solution solution = new Solution(1.0, 1.0, 1.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x - 1) * (x - 1) + (y - 1) * (y - 1) <= 1.0, "Point should be within the circle centered at (1, 1).");
        }
    }

    @Test
    void testRandPointLargeRadius() {
        Solution solution = new Solution(100.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 10000.0, "Point should be within the circle of radius 100.");
        }
    }

    @Test
    void testRandPointSmallRadius() {
        Solution solution = new Solution(0.1, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 0.01, "Point should be within the circle of very small radius.");
        }
    }

    @Test
    void testRandPointNegativeCenter() {
        Solution solution = new Solution(1.0, -5.0, -5.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x + 5) * (x + 5) + (y + 5) * (y + 5) <= 1.0, "Point should be within the circle centered at (-5, -5).");
        }
    }

    @Test
    void testRandPointLargeCenter() {
        Solution solution = new Solution(1.0, 1e6, 1e6);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x - 1e6) * (x - 1e6) + (y - 1e6) * (y - 1e6) <= 1.0, "Point should be within the circle centered at (1e6, 1e6).");
        }
    }

    @Test
    void testRandPointZeroRadius() {
        Solution solution = new Solution(0.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertEquals(0.0, x, "Point should be at the center (0,0) when radius is 0.");
            assertEquals(0.0, y, "Point should be at the center (0,0) when radius is 0.");
        }
    }

    @Test
    void testRandPointCenterAtOrigin() {
        Solution solution = new Solution(10.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 100.0, "Point should be within the circle of radius 10 centered at origin.");
        }
    }

    @Test
    void testRandPointRadiusOne() {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 1.0, "Point should be within the circle of radius 1 centered at origin.");
        }
    }

    @Test
    void testRandPointRadiusFive() {
        Solution solution = new Solution(5.0, 0.0, 0.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue(x * x + y * y <= 25.0, "Point should be within the circle of radius 5 centered at origin.");
        }
    }

    @Test
    void testRandPointCenterNonZero() {
        Solution solution = new Solution(2.5, 3.0, 4.0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            double x = point[0];
            double y = point[1];
            assertTrue((x - 3) * (x - 3) + (y - 4) * (y - 4) <= 6.25, "Point should be within the circle of radius 2.5 centered at (3, 4).");
        }
    }
}
