package llama3.task156;

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
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));
        action.run();
        System.setOut(originalOut);
        return output.toString().trim();
    }

    @Test
    public void testPreorderTraversal() {
        BinaryTree tree = buildSampleTree();
        String result = captureOutput(() -> tree.preorder_traversal(tree.root));
        assertEquals("1 2 4 5 3", result);
    }

    @Test
    public void testInorderTraversal() {
        BinaryTree tree = buildSampleTree();
        String result = captureOutput(() -> tree.inorder_traversal(tree.root));
        assertEquals("4 2 5 1 3", result);
    }

    @Test
    public void testPostorderTraversal() {
        BinaryTree tree = buildSampleTree();
        String result = captureOutput(() -> tree.postorder_traversal(tree.root));
        assertEquals("4 5 2 3 1", result);
    }

    @Test
    public void testEmptyTree() {
        BinaryTree tree = new BinaryTree();
        String pre = captureOutput(() -> tree.preorder_traversal(tree.root));
        String in = captureOutput(() -> tree.inorder_traversal(tree.root));
        String post = captureOutput(() -> tree.postorder_traversal(tree.root));
        assertEquals("", pre);
        assertEquals("", in);
        assertEquals("", post);
    }
}
