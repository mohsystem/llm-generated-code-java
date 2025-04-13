package claude.task57;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task57Test {

    @Test
    public void testFactorialZero() {
        assertEquals(1, Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial(0));
    }

    @Test
    public void testFactorialOne() {
        assertEquals(1, Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial(1));
    }

    @Test
    public void testFactorialTwo() {
        assertEquals(2, Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial(2));
    }

    @Test
    public void testFactorialThree() {
        assertEquals(6, Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial(3));
    }

    @Test
    public void testFactorialFour() {
        assertEquals(24, Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial(4));
    }

    @Test
    public void testFactorialFive() {
        assertEquals(120, Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial(5));
    }

    @Test
    public void testFactorialSix() {
        assertEquals(720, Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial(6));
    }

    @Test
    public void testFactorialLargeNumber() {
        assertEquals(3628800, Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial(10));
    }

    @Test
    public void testFactorialNegativeNumber() {
        assertThrows(StackOverflowError.class, () -> {
            Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial(-1);
        });
    }

    @Test
    public void testFactorialStringInput() {
        assertThrows(ClassCastException.class, () -> {
            Object input = "5";
            Task57_CLAUDE_claude_3_5_sonnet_20240620.factorial((int) input);
        });
    }
}
