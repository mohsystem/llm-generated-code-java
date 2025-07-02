package claude.task139;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Task139Test {

     private double calculateArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    @Test
    void testRadiusZero() {
        double result = calculateArea(0);
        assertEquals(0.0, result, 1e-6);
    }

    @Test
    void testRadiusOne() {
        double result = calculateArea(1);
        assertEquals(Math.PI * 1 * 1, result, 1e-6);
    }

    @Test
    void testRadiusTwoPointFive() {
        double result = calculateArea(2.5);
        assertEquals(Math.PI * 2.5 * 2.5, result, 1e-6);
    }

    @Test
    void testRadiusTen() {
        double result = calculateArea(10);
        assertEquals(Math.PI * 10 * 10, result, 1e-6);
    }

    @Test
    void testRadiusNegative() {
        double result = calculateArea(-5);
        assertEquals(Math.PI * (-5) * (-5), result, 1e-6);
    }

    @Test
    void testRadiusLarge() {
        double result = calculateArea(1000);
        assertEquals(Math.PI * 1000 * 1000, result, 1e-6);
    }

    @Test
    void testRadiusPi() {
        double result = calculateArea(3.1416);
        assertEquals(Math.PI * 3.1416 * 3.1416, result, 1e-6);
    }

    @Test
    void testRadiusSmall() {
        double result = calculateArea(0.1);
        assertEquals(Math.PI * 0.1 * 0.1, result, 1e-6);
    }

    @Test
    void testRadiusLargeFloating() {
        double result = calculateArea(1234.567);
        assertEquals(Math.PI * 1234.567 * 1234.567, result, 1e-6);
    }

    @Test
    void testRadiusDecimal() {
        double result = calculateArea(9.99);
        assertEquals(Math.PI * 9.99 * 9.99, result, 1e-6);
    }
}
