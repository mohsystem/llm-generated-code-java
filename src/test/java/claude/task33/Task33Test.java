package claude.task33;

import org.junit.jupiter.api.Test;
import static claude.task33.Task33_CLAUDE_claude_3_5_sonnet_20240620.queueTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task33Test {

    @Test
    void testSingleTill() {
        // All customers have to wait for the single till
        assertEquals(12, queueTime(new int[]{5, 3, 4}, 1));
    }

    @Test
    void testTwoTills() {
        // The second till finishes before the first
        assertEquals(10, queueTime(new int[]{10, 2, 3, 3}, 2));
    }

    @Test
    void testTwoTillsDifferentOrder() {
        // The tills have different workloads
        assertEquals(12, queueTime(new int[]{2, 3, 10}, 2));
    }

    @Test
    void testMultipleTills() {
        // More tills than customers
        assertEquals(5, queueTime(new int[]{5, 3, 4}, 5));
    }

    @Test
    void testEqualDistribution() {
        // Evenly distributed workload
        assertEquals(6, queueTime(new int[]{1, 2, 3, 4}, 2));
    }

    @Test
    void testEmptyQueue() {
        // No customers
        assertEquals(0, queueTime(new int[]{}, 1));
    }

    @Test
    void testOneCustomerMultipleTills() {
        // Single customer with multiple tills
        assertEquals(5, queueTime(new int[]{5}, 2));
    }

    @Test
    void testLongQueue() {
        // Long queue of customers with minimal tills
        assertEquals(15, queueTime(new int[]{2, 2, 3, 3, 4, 4, 5, 5}, 1));
    }

    @Test
    void testComplexDistribution() {
        // Complex distribution of customers
        assertEquals(10, queueTime(new int[]{2, 3, 4, 3, 2, 1}, 3));
    }

    @Test
    void testHighNumberOfTills() {
        // High number of tills, fewer customers
        assertEquals(6, queueTime(new int[]{1, 1, 1, 1, 1, 1}, 10));
    }
}
