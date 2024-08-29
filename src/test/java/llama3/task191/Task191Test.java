package llama3.task191;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task191Test {

    private Task191_PERPLEXITY_llama_3_sonar_large_32k_chat solution;

    @BeforeEach
    void setUp() {
        solution = new Task191_PERPLEXITY_llama_3_sonar_large_32k_chat();
    }

    @Test
    void testValidPair() {
        assertEquals(2, solution.longestValidParentheses("()"));
    }

    @Test
    void testNestedPairs() {
        assertEquals(6, solution.longestValidParentheses("((()))"));
    }

    @Test
    void testMultiplePairs() {
        assertEquals(6, solution.longestValidParentheses("()()()"));
    }

    @Test
    void testSingleOpen() {
        assertEquals(0, solution.longestValidParentheses("("));
    }

    @Test
    void testSingleClose() {
        assertEquals(0, solution.longestValidParentheses(")"));
    }

    @Test
    void testUnmatchedOpen() {
        assertEquals(2, solution.longestValidParentheses("(()"));
    }

    @Test
    void testUnmatchedClose() {
        assertEquals(4, solution.longestValidParentheses(")()())"));
    }

    @Test
    void testAllOpen() {
        assertEquals(0, solution.longestValidParentheses("((((("));
    }

    @Test
    void testAllClose() {
        assertEquals(0, solution.longestValidParentheses("))))"));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, solution.longestValidParentheses(""));
    }
}
