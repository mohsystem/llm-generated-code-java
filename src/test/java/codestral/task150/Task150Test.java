package codestral.task150;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task150Test {
    private SinglyLinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new SinglyLinkedList();
    }

    @Test
    void testInsertSingleElement() {
        linkedList.insert(10);
        assertTrue(linkedList.search(10), "Element 10 should be found in the list.");
    }

    @Test
    void testInsertMultipleElements() {
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        assertTrue(linkedList.search(1), "Element 1 should be found in the list.");
        assertTrue(linkedList.search(2), "Element 2 should be found in the list.");
        assertTrue(linkedList.search(3), "Element 3 should be found in the list.");
    }

    @Test
    void testDeleteHeadElement() {
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.delete(10);
        assertFalse(linkedList.search(10), "Element 10 should not be found after deletion.");
        assertTrue(linkedList.search(20), "Element 20 should still be present.");
    }

    @Test
    void testDeleteMiddleElement() {
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.delete(2);
        assertFalse(linkedList.search(2), "Element 2 should not be found after deletion.");
        assertTrue(linkedList.search(1), "Element 1 should still be present.");
        assertTrue(linkedList.search(3), "Element 3 should still be present.");
    }

    @Test
    void testDeleteTailElement() {
        linkedList.insert(100);
        linkedList.insert(200);
        linkedList.delete(200);
        assertFalse(linkedList.search(200), "Element 200 should not be found after deletion.");
        assertTrue(linkedList.search(100), "Element 100 should still be present.");
    }

    @Test
    void testDeleteNonexistentElement() {
        linkedList.insert(50);
        linkedList.delete(60);
        assertTrue(linkedList.search(50), "Element 50 should still be present.");
        assertFalse(linkedList.search(60), "Element 60 should never be present.");
    }

    @Test
    void testSearchInEmptyList() {
        assertFalse(linkedList.search(10), "Search in an empty list should return false.");
    }

    @Test
    void testInsertDeleteMultipleElements() {
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.delete(1);
        linkedList.delete(3);
        assertFalse(linkedList.search(1), "Element 1 should not be found after deletion.");
        assertTrue(linkedList.search(2), "Element 2 should still be present.");
        assertFalse(linkedList.search(3), "Element 3 should not be found after deletion.");
    }

    @Test
    void testDeleteAllElements() {
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.delete(10);
        linkedList.delete(20);
        assertTrue(linkedList.isEmpty(), "List should be empty after deleting all elements.");
    }

    @Test
    void testInsertAfterDeletingAll() {
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.delete(1);
        linkedList.delete(2);
        linkedList.insert(3);
        assertTrue(linkedList.search(3), "Element 3 should be found after inserting into an empty list.");
    }
}
