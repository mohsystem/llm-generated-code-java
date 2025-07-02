package gemini.task156;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task156Test {

    private Task156_GEMINI_gemini_1_5_pro_001 buildSampleTree() {
        Task156_GEMINI_gemini_1_5_pro_001 tree = new Task156_GEMINI_gemini_1_5_pro_001();
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
    public void testPreorderTraversal() {
        Task156_GEMINI_gemini_1_5_pro_001 tree = buildSampleTree();
        String result = captureOutput(() -> tree.preorderTraversal(tree.root));
        assertEquals("1 2 4 5 3", result);
    }

    @Test
    public void testInorderTraversal() {
        Task156_GEMINI_gemini_1_5_pro_001 tree = buildSampleTree();
        String result = captureOutput(() -> tree.inorderTraversal(tree.root));
        assertEquals("4 2 5 1 3", result);
    }

    @Test
    public void testPostorderTraversal() {
        Task156_GEMINI_gemini_1_5_pro_001 tree = buildSampleTree();
        String result = captureOutput(() -> tree.postorderTraversal(tree.root));
        assertEquals("4 5 2 3 1", result);
    }

    @Test
    public void testEmptyTree() {
        Task156_GEMINI_gemini_1_5_pro_001 tree = new Task156_GEMINI_gemini_1_5_pro_001();
        String pre = captureOutput(() -> tree.preorderTraversal(tree.root));
        String in = captureOutput(() -> tree.inorderTraversal(tree.root));
        String post = captureOutput(() -> tree.postorderTraversal(tree.root));
        assertEquals("", pre);
        assertEquals("", in);
        assertEquals("", post);
    }
}
