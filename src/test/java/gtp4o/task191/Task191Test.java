package gtp4o.task191;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task191Test {

    @BeforeEach
    void setUp() {
        // No setup needed since the method is static
    }

    @Test
    void testValidPair() {
        assertEquals(2, Task191_OPENAI_gpt_4o.longestValidParentheses("()"));
    }

    @Test
    void testNestedPairs() {
        assertEquals(6, Task191_OPENAI_gpt_4o.longestValidParentheses("((()))"));
    }

    @Test
    void testMultiplePairs() {
        assertEquals(6, Task191_OPENAI_gpt_4o.longestValidParentheses("()()()"));
    }

    @Test
    void testSingleOpen() {
        assertEquals(0, Task191_OPENAI_gpt_4o.longestValidParentheses("("));
    }

    @Test
    void testSingleClose() {
        assertEquals(0, Task191_OPENAI_gpt_4o.longestValidParentheses(")"));
    }

    @Test
    void testUnmatchedOpen() {
        assertEquals(2, Task191_OPENAI_gpt_4o.longestValidParentheses("(()"));
    }

    @Test
    void testUnmatchedClose() {
        assertEquals(4, Task191_OPENAI_gpt_4o.longestValidParentheses(")()())"));
    }

    @Test
    void testAllOpen() {
        assertEquals(0, Task191_OPENAI_gpt_4o.longestValidParentheses("((((("));
    }

    @Test
    void testAllClose() {
        assertEquals(0, Task191_OPENAI_gpt_4o.longestValidParentheses("))))"));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, Task191_OPENAI_gpt_4o.longestValidParentheses(""));
    }
}
