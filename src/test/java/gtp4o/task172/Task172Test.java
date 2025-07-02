package gtp4o.task172;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task172Test {

    @Test
    void testCase1() {
        assertEquals(3, Task172_OPENAI_gpt_4o.distinctAASubstrings("abcabcabc"), "Test Case 1 Failed");
    }

    @Test
    void testCase2() {
        assertEquals(2, Task172_OPENAI_gpt_4o.distinctAASubstrings("leetcodeleetcode"), "Test Case 2 Failed");
    }

    @Test
    void testCase3() {
        assertEquals(0, Task172_OPENAI_gpt_4o.distinctAASubstrings("a"), "Test Case 3 Failed");
    }

    @Test
    void testCase4() {
        assertEquals(1, Task172_OPENAI_gpt_4o.distinctAASubstrings("aa"), "Test Case 4 Failed");
    }

    @Test
    void testCase5() {
        assertEquals(1, Task172_OPENAI_gpt_4o.distinctAASubstrings("aaa"), "Test Case 5 Failed");
    }

    @Test
    void testCase6() {
        assertEquals(2, Task172_OPENAI_gpt_4o.distinctAASubstrings("abab"), "Test Case 6 Failed");
    }

    @Test
    void testCase7() {
        assertEquals(0, Task172_OPENAI_gpt_4o.distinctAASubstrings("abcde"), "Test Case 7 Failed");
    }

    @Test
    void testCase8() {
        assertEquals(4, Task172_OPENAI_gpt_4o.distinctAASubstrings("abababab"), "Test Case 8 Failed");
    }

    @Test
    void testCase9() {
        assertEquals(6, Task172_OPENAI_gpt_4o.distinctAASubstrings("abcabcabcabc"), "Test Case 9 Failed");
    }
}
