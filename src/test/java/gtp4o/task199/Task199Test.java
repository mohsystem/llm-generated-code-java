package gtp4o.task199;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task199Test {

    @Test
    public void testInitialTime() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(14, 30);
        assertEquals("14:30", clock.toString());
    }

    @Test
    public void testAddMinutes() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(14, 30);
        clock.addMinutes(90);
        assertEquals("16:00", clock.toString());
    }

    @Test
    public void testSubtractMinutes() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(14, 30);
        clock.subtractMinutes(70);
        assertEquals("13:20", clock.toString());
    }

    @Test
    public void testAddOverflowMinutes() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(23, 50);
        clock.addMinutes(20);
        assertEquals("00:10", clock.toString());
    }

    @Test
    public void testSubtractUnderflowMinutes() {
        Task199_OPENAI_gpt_4o clock = new Task199_OPENAI_gpt_4o(0, 10);
        clock.subtractMinutes(20);
        assertEquals("23:50", clock.toString());
    }

    @Test
    public void testEqualityTrue() {
        Task199_OPENAI_gpt_4o clock1 = new Task199_OPENAI_gpt_4o(16, 0);
        Task199_OPENAI_gpt_4o clock2 = new Task199_OPENAI_gpt_4o(16, 0);
        assertTrue(clock1.equals(clock2));
    }

    @Test
    public void testEqualityFalse() {
        Task199_OPENAI_gpt_4o clock1 = new Task199_OPENAI_gpt_4o(16, 0);
        Task199_OPENAI_gpt_4o clock2 = new Task199_OPENAI_gpt_4o(15, 0);
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
