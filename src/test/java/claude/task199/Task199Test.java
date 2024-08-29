package claude.task199;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task199Test {

    @Test
    public void testInitialTime() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock = new Task199_CLAUDE_claude_3_5_sonnet_20240620(10, 30);
        assertEquals("10:30", clock.toString());
    }

    @Test
    public void testAddMinutes() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock = new Task199_CLAUDE_claude_3_5_sonnet_20240620(10, 30);
        clock.add(60);
        assertEquals("11:30", clock.toString());
    }

    @Test
    public void testSubtractMinutes() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock = new Task199_CLAUDE_claude_3_5_sonnet_20240620(10, 30);
        clock.subtract(90);
        assertEquals("09:00", clock.toString());
    }

    @Test
    public void testAddOverflowMinutes() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock = new Task199_CLAUDE_claude_3_5_sonnet_20240620(23, 45);
        clock.add(30);
        assertEquals("00:15", clock.toString());
    }

    @Test
    public void testSubtractUnderflowMinutes() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock = new Task199_CLAUDE_claude_3_5_sonnet_20240620(0, 15);
        clock.subtract(30);
        assertEquals("23:45", clock.toString());
    }

    @Test
    public void testEqualityTrue() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock1 = new Task199_CLAUDE_claude_3_5_sonnet_20240620(10, 0);
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock2 = new Task199_CLAUDE_claude_3_5_sonnet_20240620(10, 0);
        assertTrue(clock1.equals(clock2));
    }

    @Test
    public void testEqualityFalse() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock1 = new Task199_CLAUDE_claude_3_5_sonnet_20240620(10, 0);
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock2 = new Task199_CLAUDE_claude_3_5_sonnet_20240620(9, 0);
        assertFalse(clock1.equals(clock2));
    }

    @Test
    public void testMidnightEdgeCase() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock = new Task199_CLAUDE_claude_3_5_sonnet_20240620(0, 0);
        assertEquals("00:00", clock.toString());
    }

    @Test
    public void testFullDayCycle() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock = new Task199_CLAUDE_claude_3_5_sonnet_20240620(0, 0);
        clock.add(1440);
        assertEquals("00:00", clock.toString());
    }

    @Test
    public void testNegativeOverflow() {
        Task199_CLAUDE_claude_3_5_sonnet_20240620 clock = new Task199_CLAUDE_claude_3_5_sonnet_20240620(1, 0);
        clock.subtract(1440);
        assertEquals("01:00", clock.toString());
    }

}
