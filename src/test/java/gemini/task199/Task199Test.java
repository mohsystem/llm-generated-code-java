package gemini.task199;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task199Test {

    @Test
    public void testInitialTime() {
        Clock clock = new Clock(10, 30);
        assertEquals("10:30", clock.toString());
    }

    @Test
    public void testAddMinutes() {
        Clock clock = new Clock(10, 30);
        clock = clock.add(60);
        assertEquals("11:30", clock.toString());
    }

    @Test
    public void testSubtractMinutes() {
        Clock clock = new Clock(10, 30);
        clock = clock.subtract(90);
        assertEquals("09:00", clock.toString());
    }

    @Test
    public void testAddOverflowMinutes() {
        Clock clock = new Clock(23, 45);
        clock = clock.add(30);
        assertEquals("00:15", clock.toString());
    }

    @Test
    public void testSubtractUnderflowMinutes() {
        Clock clock = new Clock(0, 15);
        clock = clock.subtract(30);
        assertEquals("23:45", clock.toString());
    }

    @Test
    public void testEqualityTrue() {
        Clock clock1 = new Clock(10, 0);
        Clock clock2 = new Clock(10, 0);
        assertTrue(clock1.equals(clock2));
    }

    @Test
    public void testEqualityFalse() {
        Clock clock1 = new Clock(10, 0);
        Clock clock2 = new Clock(9, 0);
        assertFalse(clock1.equals(clock2));
    }

    @Test
    public void testMidnightEdgeCase() {
        Clock clock = new Clock(0, 0);
        assertEquals("00:00", clock.toString());
    }

    @Test
    public void testFullDayCycle() {
        Clock clock = new Clock(0, 0);
        clock = clock.add(1440);
        assertEquals("00:00", clock.toString());
    }

    @Test
    public void testNegativeOverflow() {
        Clock clock = new Clock(1, 0);
        clock = clock.subtract(1440);
        assertEquals("01:00", clock.toString());
    }
}
