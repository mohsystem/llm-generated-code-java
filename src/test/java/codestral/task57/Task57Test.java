package codestral.task57;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task57Test {

    @Test
    public void testFactorialZero() {
        assertEquals(1, Task57_MISTRAL_codestral_latest.factorial(0));
    }

    @Test
    public void testFactorialOne() {
        assertEquals(1, Task57_MISTRAL_codestral_latest.factorial(1));
    }

    @Test
    public void testFactorialTwo() {
        assertEquals(2, Task57_MISTRAL_codestral_latest.factorial(2));
    }

    @Test
    public void testFactorialThree() {
        assertEquals(6, Task57_MISTRAL_codestral_latest.factorial(3));
    }

    @Test
    public void testFactorialFour() {
        assertEquals(24, Task57_MISTRAL_codestral_latest.factorial(4));
    }

    @Test
    public void testFactorialFive() {
        assertEquals(120, Task57_MISTRAL_codestral_latest.factorial(5));
    }

    @Test
    public void testFactorialSix() {
        assertEquals(720, Task57_MISTRAL_codestral_latest.factorial(6));
    }

    @Test
    public void testFactorialLargeNumber() {
        assertEquals(3628800, Task57_MISTRAL_codestral_latest.factorial(10));
    }

    @Test
    public void testFactorialNegativeNumber() {
        assertThrows(StackOverflowError.class, () -> {
            Task57_MISTRAL_codestral_latest.factorial(-1);
        });
    }

    @Test
    public void testFactorialStringInput() {
        assertThrows(ClassCastException.class, () -> {
            Object input = "5";
            Task57_MISTRAL_codestral_latest.factorial((int) input);
        });
    }
}
