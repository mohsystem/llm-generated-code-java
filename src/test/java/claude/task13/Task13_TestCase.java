package claude.task13;

import org.junit.jupiter.api.Test;

import static llama3.task14.Task14_PERPLEXITY_llama_3_sonar_large_32k_chat.findEvenIndex;
import static org.junit.jupiter.api.Assertions.*;

public class Task13_TestCase {

    @Test
    void testCase1() {
        char[] walk = {'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'};
        assertTrue(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }

    @Test
    void testCase2() {
        char[] walk = {'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'};
        assertFalse(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }

    @Test
    void testCase3() {
        char[] walk = {'w'};
        assertFalse(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }

    @Test
    void testCase4() {
        char[] walk = {'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'};
        assertFalse(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }

    @Test
    void testCase5() {
        char[] walk = {'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's'};
        assertTrue(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }

    @Test
    void testCase6() {
        char[] walk = {'n', 'e', 's', 'w', 'n', 'e', 's', 'w', 'n', 's'};
        assertFalse(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }

    @Test
    void testCase7() {
        char[] walk = {'n', 'n', 'n', 'n', 's', 's', 's', 's', 'e', 'w'};
        assertTrue(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }

    @Test
    void testCase8() {
        char[] walk = {'n', 's', 'n', 's', 'e', 'w', 'e', 'w', 'n', 's'};
        assertTrue(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }

    @Test
    void testCase9() {
        char[] walk = {'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n'};
        assertFalse(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }

    @Test
    void testCase10() {
        char[] walk = {'n', 'n', 'e', 'e', 's', 's', 'w', 'w', 'n', 's'};
        assertFalse(Task13_CLAUDE_claude_3_5_sonnet_20240620.isValidWalk(walk));
    }
}
