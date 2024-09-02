package gemini.task148;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task148Test {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void testPushAndPeek() {
        stack.push(10);
        assertEquals(10, stack.peek(), "Top element should be 10");
    }

    @Test
    void testPushAndPop() {
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop(), "Popped element should be 30");
    }

    @Test
    void testPushPopAndPeek() {
        stack.push(40);
        stack.push(50);
        stack.pop();
        assertEquals(40, stack.peek(), "Top element after popping should be 40");
    }

    @Test
    void testPopFromEmptyStack() {
        assertNull(stack.pop(), "Popped element from empty stack should be null");
    }

    @Test
    void testPeekFromEmptyStack() {
        assertNull(stack.peek(), "Peeked element from empty stack should be null");
    }

    @Test
    void testStackSizeAfterOperations() {
        stack.push(60);
        stack.push(70);
        assertEquals(2, stack.size(), "Stack size should be 2");
    }

    @Test
    void testIsEmptyOnNewStack() {
        assertTrue(stack.is_empty(), "New stack should be empty");
    }

    @Test
    void testIsEmptyAfterPushAndPop() {
        stack.push(80);
        stack.pop();
        assertTrue(stack.is_empty(), "Stack should be empty after pushing and popping all elements");
    }

    @Test
    void testPushMultipleAndPopAll() {
        stack.push(90);
        stack.push(100);
        stack.push(110);
        assertEquals(110, stack.pop(), "Popped element should be 110");
        assertEquals(100, stack.pop(), "Popped element should be 100");
        assertEquals(90, stack.pop(), "Popped element should be 90");
    }

    @Test
    void testMixedOperations() {
        stack.push(120);
        stack.push(130);
        stack.pop();
        stack.push(140);
        assertEquals(140, stack.peek(), "Top element should be 140");
        assertEquals(2, stack.size() , "Stack size should be 2");
    }
}
