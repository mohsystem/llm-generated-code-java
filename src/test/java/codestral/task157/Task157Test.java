package codestral.task157;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task157Test {

    @Test
    public void testMemoryAllocation() {
        // Attempt to allocate memory dynamically
        int size = 100;
        byte[] memory = new byte[size];

        // Use part of it to ensure it's accessible
        memory[0] = 42;
        memory[99] = 24;

        assertEquals(42, memory[0]);
        assertEquals(24, memory[99]);
    }
}
