package codestral.task173;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task173Test {

    @Test
    public void testCase1() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        assertEquals("ana", solver.longestDupSubstring("banana"));
    }

    @Test
    public void testCase2() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        assertEquals("", solver.longestDupSubstring("abcd"));
    }

    @Test
    public void testCase3() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        assertEquals("abcabc", solver.longestDupSubstring("abcabcabc"));
    }

    @Test
    public void testCase4() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        assertEquals("aaaaa", solver.longestDupSubstring("aaaaaa"));
    }

    @Test
    public void testCase5() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        assertEquals("", solver.longestDupSubstring(""));
    }

    @Test
    public void testCase6() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        assertEquals("", solver.longestDupSubstring("a"));
    }

    @Test
    public void testCase7() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        String input = "abcpqrabcpqr";
        assertEquals("abcpqr", solver.longestDupSubstring(input));
    }

    @Test
    public void testCase8() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        String input = "abcabcdabcde";
        assertEquals("abc", solver.longestDupSubstring(input));
    }

    @Test
    public void testCase9() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        String input = "zxyabcxyzxyzabc";
        assertEquals("xyzabc", solver.longestDupSubstring(input));
    }

    @Test
    public void testCase10() {
        Task173_MISTRAL_codestral_latest solver = new Task173_MISTRAL_codestral_latest();
        String input = "abababab";
        assertEquals("ababab", solver.longestDupSubstring(input));
    }
}
