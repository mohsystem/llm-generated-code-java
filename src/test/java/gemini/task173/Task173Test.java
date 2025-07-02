package gemini.task173;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task173Test {

    @Test
    public void testCase1() {
        Solution solver = new Solution();
        assertEquals("ana", solver.longestDupSubstring("banana"));
    }

    @Test
    public void testCase2() {
        Solution solver = new Solution();
        assertEquals("", solver.longestDupSubstring("abcd"));
    }

    @Test
    public void testCase3() {
        Solution solver = new Solution();
        assertEquals("abcabc", solver.longestDupSubstring("abcabcabc"));
    }

    @Test
    public void testCase4() {
        Solution solver = new Solution();
        assertEquals("aaaaa", solver.longestDupSubstring("aaaaaa"));
    }

    @Test
    public void testCase5() {
        Solution solver = new Solution();
        assertEquals("", solver.longestDupSubstring(""));
    }

    @Test
    public void testCase6() {
        Solution solver = new Solution();
        assertEquals("", solver.longestDupSubstring("a"));
    }

    @Test
    public void testCase7() {
        Solution solver = new Solution();
        String input = "abcpqrabcpqr";
        assertEquals("abcpqr", solver.longestDupSubstring(input));
    }

    @Test
    public void testCase8() {
        Solution solver = new Solution();
        String input = "abcabcdabcde";
        assertEquals("abc", solver.longestDupSubstring(input));
    }

    @Test
    public void testCase9() {
        Solution solver = new Solution();
        String input = "zxyabcxyzxyzabc";
        assertEquals("xyzabc", solver.longestDupSubstring(input));
    }

    @Test
    public void testCase10() {
        Solution solver = new Solution();
        String input = "abababab";
        assertEquals("ababab", solver.longestDupSubstring(input));
    }
}
