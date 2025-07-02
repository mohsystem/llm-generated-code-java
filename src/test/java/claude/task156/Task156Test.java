package claude.task156;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task156Test {

     private TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

     private String captureOutput(Runnable runnable) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(output));
        runnable.run();
        System.setOut(original);
        return output.toString().trim();
    }

    @Test
    public void testPreorderTraversal() {
        TreeNode root = buildSampleTree();
        String result = captureOutput(() -> Task156_CLAUDE_claude_3_5_sonnet_20240620.preorderTraversal(root));
        assertEquals("1 2 4 5 3", result, "Preorder traversal failed");
    }

    @Test
    public void testInorderTraversal() {
        TreeNode root = buildSampleTree();
        String result = captureOutput(() -> Task156_CLAUDE_claude_3_5_sonnet_20240620.inorderTraversal(root));
        assertEquals("4 2 5 1 3", result, "Inorder traversal failed");
    }

    @Test
    public void testPostorderTraversal() {
        TreeNode root = buildSampleTree();
        String result = captureOutput(() -> Task156_CLAUDE_claude_3_5_sonnet_20240620.postorderTraversal(root));
        assertEquals("4 5 2 3 1", result, "Postorder traversal failed");
    }

    @Test
    public void testEmptyTree() {
        TreeNode root = null;
        String pre = captureOutput(() -> Task156_CLAUDE_claude_3_5_sonnet_20240620.preorderTraversal(root));
        String in = captureOutput(() -> Task156_CLAUDE_claude_3_5_sonnet_20240620.inorderTraversal(root));
        String post = captureOutput(() -> Task156_CLAUDE_claude_3_5_sonnet_20240620.postorderTraversal(root));
        assertEquals("", pre, "Preorder on null failed");
        assertEquals("", in, "Inorder on null failed");
        assertEquals("", post, "Postorder on null failed");
    }
}
