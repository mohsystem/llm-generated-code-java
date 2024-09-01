package gtp4o.task199;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task199Test {

    @Test
    public void testInitialTime() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(10, 30);
        assertEquals("10:30", clock.toString());
    }

    @Test
    public void testAddMinutes() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(10, 30);
        clock.addMinutes(60);
        assertEquals("11:30", clock.toString());
    }

    @Test
    public void testSubtractMinutes() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(10, 30);
        clock.subtractMinutes(90);
        assertEquals("09:00", clock.toString());
    }

    @Test
    public void testAddOverflowMinutes() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(23, 45);
        clock.addMinutes(30);
        assertEquals("00:15", clock.toString());
    }

    @Test
    public void testSubtractUnderflowMinutes() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(0, 15);
        clock.subtractMinutes(30);
        assertEquals("23:45", clock.toString());
    }

    @Test
    public void testEqualityTrue() {
        Task199_OPENAI_gpt_4o clock1 = new Task199_OPENAI_gpt_4o(10, 0);
        Task199_OPENAI_gpt_4o clock2 = new Task199_OPENAI_gpt_4o(10, 0);
        assertTrue(clock1.equals(clock2));
    }

    @Test
    public void testEqualityFalse() {
        Task199_OPENAI_gpt_4o clock1 = new Task199_OPENAI_gpt_4o(10, 0);
        Task199_OPENAI_gpt_4o clock2 = new Task199_OPENAI_gpt_4o(9, 0);
        assertFalse(clock1.equals(clock2));
    }

    @Test
    public void testMidnightEdgeCase() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(0, 0);
        assertEquals("00:00", clock.toString());
    }

    @Test
    public void testFullDayCycle() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(0, 0);
        clock.addMinutes(1440);
        assertEquals("00:00", clock.toString());
    }

    @Test
    public void testNegativeOverflow() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(1, 0);
        clock.subtractMinutes(1440);
        assertEquals("01:00", clock.toString());
    }
}
