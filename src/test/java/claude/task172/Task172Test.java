package claude.task172;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task172Test {

    static Solution sol;

    @BeforeAll
    static void setup() {
        sol = new Solution();
    }

    @Test
    void testCase1() {
        assertEquals(3, sol.distinctEchoSubstrings("abcabcabc"), "Test Case 1 Failed");
    }

    @Test
    void testCase2() {
        assertEquals(2, sol.distinctEchoSubstrings("leetcodeleetcode"), "Test Case 2 Failed");
    }

    @Test
    void testCase3() {
        assertEquals(0, sol.distinctEchoSubstrings("a"), "Test Case 3 Failed");
    }

    @Test
    void testCase4() {
        assertEquals(1, sol.distinctEchoSubstrings("aa"), "Test Case 4 Failed");
    }

    @Test
    void testCase5() {
        assertEquals(1, sol.distinctEchoSubstrings("aaa"), "Test Case 5 Failed");
    }

    @Test
    void testCase6() {
        assertEquals(2, sol.distinctEchoSubstrings("abab"), "Test Case 6 Failed");
    }

    @Test
    void testCase7() {
        assertEquals(0, sol.distinctEchoSubstrings("abcde"), "Test Case 7 Failed");
    }

    @Test
    void testCase8() {
        assertEquals(4, sol.distinctEchoSubstrings("abababab"), "Test Case 8 Failed");
    }

    @Test
    void testCase9() {
        assertEquals(6, sol.distinctEchoSubstrings("abcabcabcabc"), "Test Case 9 Failed");
    }
}
