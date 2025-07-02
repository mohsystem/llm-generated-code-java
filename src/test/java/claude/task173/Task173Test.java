package claude.task173;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task173Test {

    Solution sol = new Solution();

    @Test
    void testCase1() {
        assertEquals("abcabc", sol.longestDupSubstring("abcabcabcd"));
    }

    @Test
    void testCase2() {
        assertEquals("ababab", sol.longestDupSubstring("abababcababab"));
    }

    @Test
    void testCase3() {
        assertEquals("abacaba", sol.longestDupSubstring("abacabadabacaba"));
    }

    @Test
    void testCase4() {
        assertEquals("abcdefgabcdefg", sol.longestDupSubstring("abcdefgabcdefgabcdefg"));
    }

    @Test
    void testCase5() {
        assertEquals("aabbaa", sol.longestDupSubstring("aabbaabbaaccddcc"));
    }

    @Test
    void testCase6() {
        assertEquals("abcdabcdeabcd", sol.longestDupSubstring("abcdabcdeabcdabcdeabcd"));
    }

    @Test
    void testCase7() {
        assertEquals("abcdefghijklmno", sol.longestDupSubstring("abcdefghijklmnoabcdefghijklmno"));
    }

    @Test
    void testCase8() {
        assertEquals("xyzxyzxyzx", sol.longestDupSubstring("xyzxyzxyzxyzx"));
    }

    @Test
    void testCase9() {
        assertEquals("abcdefgh", sol.longestDupSubstring("abcdefgh12345678abcdefgh"));
    }

    @Test
    void testCase10() {
        assertEquals("abc", sol.longestDupSubstring("abcxabcyabczabcdabc"));
    }
}
