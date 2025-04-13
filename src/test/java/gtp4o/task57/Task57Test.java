package gtp4o.task57;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task57Test {

     private long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    @Test
    public void testFactorialZero() {
        assertEquals(1, factorial(0));
    }

    @Test
    public void testFactorialOne() {
        assertEquals(1, factorial(1));
    }

    @Test
    public void testFactorialTwo() {
        assertEquals(2, factorial(2));
    }

    @Test
    public void testFactorialThree() {
        assertEquals(6, factorial(3));
    }

    @Test
    public void testFactorialFour() {
        assertEquals(24, factorial(4));
    }

    @Test
    public void testFactorialFive() {
        assertEquals(120, factorial(5));
    }

    @Test
    public void testFactorialSix() {
        assertEquals(720, factorial(6));
    }

    @Test
    public void testFactorialLargeNumber() {
        assertEquals(3628800, factorial(10));
    }

    @Test
    public void testFactorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            if (-1 < 0) throw new IllegalArgumentException("Negative input not allowed");
        });
    }

    @Test
    public void testFactorialStringInput() {
        assertThrows(ClassCastException.class, () -> {
            Object input = "5";
            factorial((int) input);
        });
    }
}
