package gtp4o.task149;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task149Test {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void testEnqueueAndPeek() {
        queue.enqueue(10);
        assertEquals(10, queue.peek(), "The first element should be 10 after enqueue.");
    }

    @Test
    void testEnqueueAndDequeue() {
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(20, queue.dequeue(), "The dequeued element should be 20.");
    }

    @Test
    void testMultipleEnqueueAndPeek() {
        queue.enqueue(40);
        queue.enqueue(50);
        assertEquals(40, queue.peek(), "Peek should return the first enqueued element, 40.");
    }

    @Test
    void testMultipleEnqueueAndDequeue() {
        queue.enqueue(60);
        queue.enqueue(70);
        queue.dequeue(); // Should remove 60
        assertEquals(70, queue.peek(), "After dequeue, peek should return 70.");
    }

    @Test
    void testDequeueFromEmptyQueue() {
        assertNull(queue.dequeue(), "Dequeue from an empty queue should return null.");
    }

    @Test
    void testPeekFromEmptyQueue() {
        assertNull(queue.peek(), "Peek on an empty queue should return null.");
    }

    @Test
    void testIsEmptyOnNewQueue() {
        assertTrue(queue.isEmpty(), "A new queue should be empty.");
    }

    @Test
    void testIsEmptyAfterOperations() {
        queue.enqueue(80);
        queue.enqueue(90);
        queue.dequeue();
        queue.dequeue();
        assertTrue(queue.isEmpty(), "Queue should be empty after all elements are dequeued.");
    }

    @Test
    void testEnqueueDequeueSequence() {
        queue.enqueue(100);
        queue.enqueue(110);
        assertEquals(100, queue.dequeue(), "First dequeue should return 100.");
        queue.enqueue(120);
        assertEquals(110, queue.dequeue(), "Second dequeue should return 110.");
        assertEquals(120, queue.peek(), "Peek should return the last element, 120.");
    }

    @Test
    void testSizeConsistency() {
        queue.enqueue(130);
        queue.enqueue(140);
        assertEquals(130, queue.dequeue(), "Dequeue should return 130.");
        assertEquals(140, queue.dequeue(), "Dequeue should return 140.");
        assertTrue(queue.isEmpty(), "Queue should be empty after all operations.");
    }
}
