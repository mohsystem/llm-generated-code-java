package llama3.task199;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task199Test {

    @Test
    public void testInitialTime() {
        Clock clock = new Clock(10, 30);
        assertEquals(10, clock.hours);
        assertEquals(30, clock.minutes);
    }

    @Test
    public void testAddMinutes() {
        Clock clock = new Clock(10, 30);
        clock.addMinutes(30);
        assertEquals(11, clock.hours);
        assertEquals(0, clock.minutes);
    }

    @Test
    public void testSubtractMinutes() {
        Clock clock = new Clock(10, 30);
        clock.subtractMinutes(40);
        assertEquals(9, clock.hours);
        assertEquals(50, clock.minutes);
    }

    @Test
    public void testAddOverflowMinutes() {
        Clock clock = new Clock(23, 50);
        clock.addMinutes(20);
        assertEquals(0, clock.hours);
        assertEquals(10, clock.minutes);
    }

    @Test
    public void testSubtractUnderflowMinutes() {
        Clock clock = new Clock(0, 10);
        clock.subtractMinutes(20);
        assertEquals(23, clock.hours);
        assertEquals(50, clock.minutes);
    }

    @Test
    public void testEqualityTrue() {
        Clock clock1 = new Clock(10, 30);
        Clock clock2 = new Clock(10, 30);
        assertTrue(clock1.equals(clock2));
    }

    @Test
    public void testEqualityFalse() {
        Clock clock1 = new Clock(10, 30);
        Clock clock2 = new Clock(11, 30);
        assertFalse(clock1.equals(clock2));
    }

    @Test
    public void testMidnightEdgeCase() {
        Clock clock = new Clock(0, 0);
        assertEquals(0, clock.hours);
        assertEquals(0, clock.minutes);
    }

    @Test
    public void testFullDayCycle() {
        Clock clock = new Clock(0, 0);
        clock.addMinutes(1440);
        assertEquals(0, clock.hours);
        assertEquals(0, clock.minutes);
    }

    @Test
    public void testNegativeOverflow() {
        Clock clock = new Clock(1, 0);
        clock.subtractMinutes(1440);
        assertEquals(1, clock.hours);
        assertEquals(0, clock.minutes);
    }
}
