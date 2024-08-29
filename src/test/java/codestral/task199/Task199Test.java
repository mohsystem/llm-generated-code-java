package codestral.task199;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task199Test {

    @Test
    public void testInitialTime() {
        Task199_MISTRAL_codestral_latest clock = new Task199_MISTRAL_codestral_latest(10, 30);
        assertEquals("10:30", clock.toString());
    }

    @Test
    public void testAddMinutes() {
        Task199_MISTRAL_codestral_latest clock = new Task199_MISTRAL_codestral_latest(10, 30);
        clock = clock.add(60);
        assertEquals("11:30", clock.toString());
    }

    @Test
    public void testSubtractMinutes() {
        Task199_MISTRAL_codestral_latest clock = new Task199_MISTRAL_codestral_latest(10, 30);
        clock = clock.subtract(90);
        assertEquals("09:00", clock.toString());
    }

    @Test
    public void testAddOverflowMinutes() {
        Task199_MISTRAL_codestral_latest clock = new Task199_MISTRAL_codestral_latest(23, 45);
        clock = clock.add(30);
        assertEquals("00:15", clock.toString());
    }

    @Test
    public void testSubtractUnderflowMinutes() {
        Task199_MISTRAL_codestral_latest clock = new Task199_MISTRAL_codestral_latest(0, 15);
        clock = clock.subtract(30);
        assertEquals("23:45", clock.toString());
    }

    @Test
    public void testEqualityTrue() {
        Task199_MISTRAL_codestral_latest clock1 = new Task199_MISTRAL_codestral_latest(10, 0);
        Task199_MISTRAL_codestral_latest clock2 = new Task199_MISTRAL_codestral_latest(10, 0);
        assertTrue(clock1.equals(clock2));
    }

    @Test
    public void testEqualityFalse() {
        Task199_MISTRAL_codestral_latest clock1 = new Task199_MISTRAL_codestral_latest(10, 0);
        Task199_MISTRAL_codestral_latest clock2 = new Task199_MISTRAL_codestral_latest(9, 0);
        assertFalse(clock1.equals(clock2));
    }

    @Test
    public void testMidnightEdgeCase() {
        Task199_MISTRAL_codestral_latest clock = new Task199_MISTRAL_codestral_latest(0, 0);
        assertEquals("00:00", clock.toString());
    }

    @Test
    public void testFullDayCycle() {
        Task199_MISTRAL_codestral_latest clock = new Task199_MISTRAL_codestral_latest(0, 0);
        clock = clock.add(1440);
        assertEquals("00:00", clock.toString());
    }

    @Test
    public void testNegativeOverflow() {
        Task199_MISTRAL_codestral_latest clock = new Task199_MISTRAL_codestral_latest(1, 0);
        clock = clock.subtract(1440);
        assertEquals("01:00", clock.toString());
    }
}
