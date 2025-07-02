package gtp4o.task173;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task173Test {

    @Test
    public void testCase1() {
        assertEquals("ana", Task173_OPENAI_gpt_4o.longestDupSubstring("banana"));
    }

    @Test
    public void testCase2() {
        assertEquals("", Task173_OPENAI_gpt_4o.longestDupSubstring("abcd"));
    }

    @Test
    public void testCase3() {
        assertEquals("abcabc", Task173_OPENAI_gpt_4o.longestDupSubstring("abcabcabc"));
    }

    @Test
    public void testCase4() {
        assertEquals("aaaaa", Task173_OPENAI_gpt_4o.longestDupSubstring("aaaaaa"));
    }

    @Test
    public void testCase5() {
        assertEquals("", Task173_OPENAI_gpt_4o.longestDupSubstring(""));
    }

    @Test
    public void testCase6() {
        assertEquals("", Task173_OPENAI_gpt_4o.longestDupSubstring("a"));
    }

    @Test
    public void testCase7() {
        assertEquals("abcpqr", Task173_OPENAI_gpt_4o.longestDupSubstring("abcpqrabcpqr"));
    }

    @Test
    public void testCase8() {
        assertEquals("abc", Task173_OPENAI_gpt_4o.longestDupSubstring("abcabcdabcde"));
    }

    @Test
    public void testCase9() {
        assertEquals("xyzabc", Task173_OPENAI_gpt_4o.longestDupSubstring("zxyabcxyzxyzabc"));
    }

    @Test
    public void testCase10() {
        assertEquals("ababab", Task173_OPENAI_gpt_4o.longestDupSubstring("abababab"));
    }
}
