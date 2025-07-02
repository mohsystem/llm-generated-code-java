package llama3.task173;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task173Test {

    Task173_PERPLEXITY_llama_3_sonar_large_32k_chat sol = new Task173_PERPLEXITY_llama_3_sonar_large_32k_chat();

    @Test
    public void testCase1() {
        assertEquals("abcabc", sol.longestDupSubstring("abcabcabcd"));
    }

    @Test
    public void testCase2() {
        assertEquals("ababab", sol.longestDupSubstring("abababcababab"));
    }

    @Test
    public void testCase3() {
        assertEquals("abacaba", sol.longestDupSubstring("abacabadabacaba"));
    }

    @Test
    public void testCase4() {
        assertEquals("abcdefgabcdefg", sol.longestDupSubstring("abcdefgabcdefgabcdefg"));
    }

    @Test
    public void testCase5() {
        assertEquals("aabbaa", sol.longestDupSubstring("aabbaabbaaccddcc"));
    }

    @Test
    public void testCase6() {
        assertEquals("abcdabcdeabcd", sol.longestDupSubstring("abcdabcdeabcdabcdeabcd"));
    }

    @Test
    public void testCase7() {
        assertEquals("abcdefghijklmno", sol.longestDupSubstring("abcdefghijklmnoabcdefghijklmno"));
    }

    @Test
    public void testCase8() {
        assertEquals("xyzxyzxyzx", sol.longestDupSubstring("xyzxyzxyzxyzx"));
    }

    @Test
    public void testCase9() {
        assertEquals("abcdefgh", sol.longestDupSubstring("abcdefgh12345678abcdefgh"));
    }

    @Test
    public void testCase10() {
        assertEquals("abc", sol.longestDupSubstring("abcxabcyabczabcdabc"));
    }
}
