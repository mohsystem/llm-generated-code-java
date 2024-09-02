package gtp4o.task151;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task151Test {
    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    void testInsertSingleElement() {
        bst.insert(10);
        assertTrue(bst.search(bst.root, 10) != null, "Element 10 should be found in the tree.");
    }

    @Test
    void testInsertMultipleElements() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        assertTrue(bst.search(bst.root, 50) != null, "Element 50 should be found in the tree.");
        assertTrue(bst.search(bst.root, 30) != null, "Element 30 should be found in the tree.");
        assertTrue(bst.search(bst.root, 70) != null, "Element 70 should be found in the tree.");
    }

    @Test
    void testDeleteLeafNode() {
        bst.insert(50);
        bst.insert(30);
        bst.deleteKey(30);
        assertFalse(bst.search(bst.root, 30) != null, "Element 30 should not be found after deletion.");
        assertTrue(bst.search(bst.root, 50) != null, "Element 50 should still be present.");
    }

    @Test
    void testDeleteNodeWithOneChild() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.deleteKey(30);
        assertFalse(bst.search(bst.root, 30) != null, "Element 30 should not be found after deletion.");
        assertTrue(bst.search(bst.root, 20) != null, "Element 20 should still be present.");
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.deleteKey(30);
        assertFalse(bst.search(bst.root, 30) != null, "Element 30 should not be found after deletion.");
        assertTrue(bst.search(bst.root, 20) != null, "Element 20 should still be present.");
        assertTrue(bst.search(bst.root, 40) != null, "Element 40 should still be present.");
    }

    @Test
    void testSearchNonExistentElement() {
        bst.insert(50);
        bst.insert(30);
        assertFalse(bst.search(bst.root, 100) != null, "Element 100 should not be found in the tree.");
    }

    @Test
    void testSearchInEmptyTree() {
        assertFalse(bst.search(bst.root, 10) != null, "Searching in an empty tree should return false.");
    }

    @Test
    void testDeleteRootNode() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.deleteKey(50);
        assertFalse(bst.search(bst.root, 50) != null, "Root element 50 should not be found after deletion.");
        assertTrue(bst.search(bst.root, 30) != null, "Element 30 should still be present.");
        assertTrue(bst.search(bst.root, 70) != null, "Element 70 should still be present.");
    }

    @Test
    void testInsertDuplicateElements() {
        bst.insert(50);
        bst.insert(50);  // Duplicate insert
        bst.deleteKey(50);
        assertFalse(bst.search(bst.root, 50) != null, "Element 50 should not be found after deletion, ensuring duplicates are not inserted.");
    }

    @Test
    void testDeleteAllElements() {
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.deleteKey(10);
        bst.deleteKey(20);
        bst.deleteKey(30);
        assertFalse(bst.search(bst.root, 10) != null, "Element 10 should not be found after deletion.");
        assertFalse(bst.search(bst.root, 20) != null, "Element 20 should not be found after deletion.");
        assertFalse(bst.search(bst.root, 30) != null, "Element 30 should not be found after deletion.");
        assertTrue(bst.root == null, "Tree should be empty after deleting all elements.");
    }
}
