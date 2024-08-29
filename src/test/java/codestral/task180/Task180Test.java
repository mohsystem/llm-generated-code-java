package codestral.task180;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task180Test {

    private Node root;
    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;
    private Node node5;
    private Node node6;
    private Node node7;
    private Node node8;
    private Node node9;

    @BeforeEach
    void setUp() {
        // Initialize nodes
        root = new Node(0);
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);
        node5 = new Node(5);
        node6 = new Node(6);
        node7 = new Node(7);
        node8 = new Node(8);
        node9 = new Node(9);

        // Build the tree
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node1.children.add(node4);
        node1.children.add(node5);
        node2.children.add(node6);
        node2.children.add(node7);
        node3.children.add(node8);
        node3.children.add(node9);
    }

    @Test
    void testReparentNode2() {
        node2.reparent(root);
        assertEquals(root.children.size(), 2);
        assertEquals(root.children.get(0), node1);
        assertEquals(root.children.get(1), node3);
        assertEquals(node2.children.size(), 2);
    }

    @Test
    void testReparentNode1() {
        node1.reparent(root);
        assertEquals(root.children.size(), 2);
        assertEquals(root.children.get(0), node2);
        assertEquals(root.children.get(1), node3);
        assertEquals(node1.children.size(), 2);
    }

    @Test
    void testReparentNode3() {
        node3.reparent(root);
        assertEquals(root.children.size(), 2);
        assertEquals(root.children.get(0), node1);
        assertEquals(root.children.get(1), node2);
        assertEquals(node3.children.size(), 2);
    }

    @Test
    void testReparentNode4() {
        node4.reparent(root);
        assertEquals(root.children.size(), 1);
        assertEquals(root.children.get(0), node1);
        assertEquals(node4.children.size(), 0);
    }

    @Test
    void testReparentNode5() {
        node5.reparent(root);
        assertEquals(root.children.size(), 1);
        assertEquals(root.children.get(0), node1);
        assertEquals(node5.children.size(), 0);
    }

    @Test
    void testReparentNode6() {
        node6.reparent(root);
        assertEquals(root.children.size(), 1);
        assertEquals(root.children.get(0), node2);
        assertEquals(node6.children.size(), 0);
    }

    @Test
    void testReparentNode7() {
        node7.reparent(root);
        assertEquals(root.children.size(), 1);
        assertEquals(root.children.get(0), node2);
        assertEquals(node7.children.size(), 0);
    }

    @Test
    void testReparentNode8() {
        node8.reparent(root);
        assertEquals(root.children.size(), 1);
        assertEquals(root.children.get(0), node3);
        assertEquals(node8.children.size(), 0);
    }

    @Test
    void testReparentNode9() {
        node9.reparent(root);
        assertEquals(root.children.size(), 1);
        assertEquals(root.children.get(0), node3);
        assertEquals(node9.children.size(), 0);
    }

    @Test
    void testReparentEmptyTree() {
        Node newRoot = new Node(10);
        newRoot.reparent(root);
        assertEquals(newRoot.children.size(), 1);
        assertEquals(newRoot.children.get(0), root);
        assertEquals(root.children.size(), 0);
    }
}
