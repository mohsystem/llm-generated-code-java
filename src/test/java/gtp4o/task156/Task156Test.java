package gtp4o.task156;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task156Test {

    private BinaryTree buildSampleTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        return tree;
    }

    private String captureOutput(Runnable action) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(output));
        action.run();
        System.setOut(original);
        return output.toString().trim();
    }

    @Test
    public void testInorderTraversal() {
        BinaryTree tree = buildSampleTree();
        String result = captureOutput(() -> tree.inorder(tree.root));
        assertEquals("4 2 5 1 3", result);
    }

    @Test
    public void testEmptyTree() {
        BinaryTree tree = new BinaryTree();
        String result = captureOutput(() -> tree.inorder(tree.root));
        assertEquals("", result);
    }
}
