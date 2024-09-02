package codestral.task151;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task151Test {
    private BinaryTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinaryTree();
    }

    @Test
    void testInsertSingleElement() {
        bst.insert(10);
        assertTrue(bst.search(10), "Element 10 should be found in the tree.");
    }

    @Test
    void testInsertMultipleElements() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        assertTrue(bst.search(50), "Element 50 should be found in the tree.");
        assertTrue(bst.search(30), "Element 30 should be found in the tree.");
        assertTrue(bst.search(70), "Element 70 should be found in the tree.");
    }

    @Test
    void testDeleteLeafNode() {
        bst.insert(50);
        bst.insert(30);
        bst.delete(30);
        assertFalse(bst.search(30), "Element 30 should not be found after deletion.");
        assertTrue(bst.search(50), "Element 50 should still be present.");
    }

    @Test
    void testDeleteNodeWithOneChild() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.delete(30);
        assertFalse(bst.search(30), "Element 30 should not be found after deletion.");
        assertTrue(bst.search(20), "Element 20 should still be present.");
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.delete(30);
        assertFalse(bst.search(30), "Element 30 should not be found after deletion.");
        assertTrue(bst.search(20), "Element 20 should still be present.");
        assertTrue(bst.search(40), "Element 40 should still be present.");
    }

    @Test
    void testSearchNonExistentElement() {
        bst.insert(50);
        bst.insert(30);
        assertFalse(bst.search(100), "Element 100 should not be found in the tree.");
    }

    @Test
    void testSearchInEmptyTree() {
        assertFalse(bst.search(10), "Searching in an empty tree should return false.");
    }

    @Test
    void testDeleteRootNode() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.delete(50);
        assertFalse(bst.search(50), "Root element 50 should not be found after deletion.");
        assertTrue(bst.search(30), "Element 30 should still be present.");
        assertTrue(bst.search(70), "Element 70 should still be present.");
    }

    @Test
    void testInsertDuplicateElements() {
        bst.insert(50);
        bst.insert(50);  // Duplicate insert
        bst.delete(50);
        assertFalse(bst.search(50), "Element 50 should not be found after deletion, ensuring duplicates are not inserted.");
    }

    @Test
    void testDeleteAllElements() {
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.delete(10);
        bst.delete(20);
        bst.delete(30);
        assertFalse(bst.search(10), "Element 10 should not be found after deletion.");
        assertFalse(bst.search(20), "Element 20 should not be found after deletion.");
        assertFalse(bst.search(30), "Element 30 should not be found after deletion.");
        assertTrue(bst.isEmpty(), "Tree should be empty after deleting all elements.");
    }
}
