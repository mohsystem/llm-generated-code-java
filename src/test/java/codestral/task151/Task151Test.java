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
        bst.insert(bst.root, 10);
        assertTrue(bst.search(bst.root, 10), "Element 10 should be found in the tree.");
    }

    @Test
    void testInsertMultipleElements() {
        bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        assertTrue(bst.search(bst.root, 50), "Element 50 should be found in the tree.");
        assertTrue(bst.search(bst.root, 30), "Element 30 should be found in the tree.");
        assertTrue(bst.search(bst.root, 70), "Element 70 should be found in the tree.");
    }

    @Test
    void testDeleteLeafNode() {
        bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.deleteNode(bst.root,30);
        assertFalse(bst.search(bst.root, 30), "Element 30 should not be found after deletion.");
        assertTrue(bst.search(bst.root, 50), "Element 50 should still be present.");
    }

    @Test
    void testDeleteNodeWithOneChild() {
        bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 20);
        bst.deleteNode(bst.root,30);
        assertFalse(bst.search(bst.root, 30), "Element 30 should not be found after deletion.");
        assertTrue(bst.search(bst.root, 20), "Element 20 should still be present.");
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 40);
        bst.deleteNode(bst.root,30);
        assertFalse(bst.search(bst.root, 30), "Element 30 should not be found after deletion.");
        assertTrue(bst.search(bst.root, 20), "Element 20 should still be present.");
        assertTrue(bst.search(bst.root, 40), "Element 40 should still be present.");
    }

    @Test
    void testSearchNonExistentElement() {
        bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        assertFalse(bst.search(bst.root, 100), "Element 100 should not be found in the tree.");
    }

    @Test
    void testSearchInEmptyTree() {
        assertFalse(bst.search(bst.root, 10), "Searching in an empty tree should return false.");
    }

    @Test
    void testDeleteRootNode() {
        bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.deleteNode(bst.root,50);
        assertFalse(bst.search(bst.root, 50), "Root element 50 should not be found after deletion.");
        assertTrue(bst.search(bst.root, 30), "Element 30 should still be present.");
        assertTrue(bst.search(bst.root, 70), "Element 70 should still be present.");
    }

    @Test
    void testInsertDuplicateElements() {
        bst.insert(bst.root, 50);
        bst.insert(bst.root, 50);  // Duplicate insert
        bst.deleteNode(bst.root,50);
        assertFalse(bst.search(bst.root, 50), "Element 50 should not be found after deletion, ensuring duplicates are not inserted.");
    }

    @Test
    void testDeleteAllElements() {
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 30);
        bst.deleteNode(bst.root,10);
        bst.deleteNode(bst.root,20);
        bst.deleteNode(bst.root,30);
        assertFalse(bst.search(bst.root, 10), "Element 10 should not be found after deletion.");
        assertFalse(bst.search(bst.root, 20), "Element 20 should not be found after deletion.");
        assertFalse(bst.search(bst.root, 30), "Element 30 should not be found after deletion.");
        assertTrue(bst.root == null, "Tree should be empty after deleting all elements.");
    }
}
