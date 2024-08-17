package gtp4o.task13;

import org.junit.jupiter.api.Test;

import static gtp4o.task13.Task13_OPENAI_gpt_4o.isValidWalk;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task13_TestCase {

    @Test
    void testCase1() {
        char[] walk = {'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase2() {
        char[] walk = {'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'};
        assertFalse(isValidWalk(walk));
    }

    @Test
    void testCase3() {
        char[] walk = {'w'};
        assertFalse(isValidWalk(walk));
    }

    @Test
    void testCase4() {
        char[] walk = {'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'};
        assertFalse(isValidWalk(walk));
    }

    @Test
    void testCase5() {
        char[] walk = {'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's'};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase6() {
        char[] walk = {'n', 'e', 's', 'w', 'n', 'e', 's', 'w', 'n', 's'};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase7() {
        char[] walk = {'n', 'n', 'n', 'n', 's', 's', 's', 's', 'e', 'w'};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase8() {
        char[] walk = {'n', 's', 'n', 's', 'e', 'w', 'e', 'w', 'n', 's'};
        assertTrue(isValidWalk(walk));
    }

    @Test
    void testCase9() {
        char[] walk = {'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n'};
        assertFalse(isValidWalk(walk));
    }

    @Test
    void testCase10() {
        char[] walk = {'n', 'n', 'e', 'e', 's', 's', 'w', 'w', 'n', 's'};
        assertTrue(isValidWalk(walk));
    }
}
