package llama3.task13;

import org.junit.jupiter.api.Test;

import static llama3.task13.Task13_PERPLEXITY_llama_3_sonar_large_32k_chat.isValidWalk;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task13_TestCase {

    @Test
    void testCase1() {
        String[] walk = {"n", "s", "n", "s", "n", "s", "n", "s", "n", "s"};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase2() {
        String[] walk = {"w", "e", "w", "e", "w", "e", "w", "e", "w", "e", "w", "e"};
        assertFalse(isValidWalk(walk));
    }

    @Test
    void testCase3() {
        String[] walk = {"w"};
        assertFalse(isValidWalk(walk));
    }

    @Test
    void testCase4() {
        String[] walk = {"n", "n", "n", "s", "n", "s", "n", "s", "n", "s"};
        assertFalse(isValidWalk(walk));
    }

    @Test
    void testCase5() {
        String[] walk = {"n", "s", "e", "w", "n", "s", "e", "w", "n", "s"};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase6() {
        String[] walk = {"n", "e", "s", "w", "n", "e", "s", "w", "n", "s"};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase7() {
        String[] walk = {"n", "n", "n", "n", "s", "s", "s", "s", "e", "w"};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase8() {
        String[] walk = {"n", "s", "n", "s", "e", "w", "e", "w", "n", "s"};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase9() {
        String[] walk = {"n", "n", "n", "n", "n", "n", "n", "n", "n", "n"};
        assertFalse(isValidWalk(walk));
    }

    @Test
    void testCase10() {
        String[] walk = {"n", "n", "e", "e", "s", "s", "w", "w", "n", "s"};
        assertTrue(isValidWalk(walk));
    }
}
