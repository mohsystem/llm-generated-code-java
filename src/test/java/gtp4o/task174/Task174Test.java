package gtp4o.task174;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task174Test {

    @Test
    public void testCase1() {
        assertEquals("racecar", Task174_OPENAI_gpt_4o.shortestPalindrome("racecar"), "Test Case 1 Failed");
    }

    @Test
    public void testCase2() {
        assertEquals("aaacecaaa", Task174_OPENAI_gpt_4o.shortestPalindrome("aacecaaa"), "Test Case 2 Failed");
    }

    @Test
    public void testCase3() {
        assertEquals("dcbabcd", Task174_OPENAI_gpt_4o.shortestPalindrome("abcd"), "Test Case 3 Failed");
    }

    @Test
    public void testCase4() {
        assertEquals("", Task174_OPENAI_gpt_4o.shortestPalindrome(""), "Test Case 4 Failed");
    }

    @Test
    public void testCase5() {
        assertEquals("a", Task174_OPENAI_gpt_4o.shortestPalindrome("a"), "Test Case 5 Failed");
    }

    @Test
    public void testCase6() {
        assertEquals("aaaaaaaa", Task174_OPENAI_gpt_4o.shortestPalindrome("aaaaaaaa"), "Test Case 6 Failed");
    }

    @Test
    public void testCase7() {
        assertEquals("adcbaabcda", Task174_OPENAI_gpt_4o.shortestPalindrome("abcda"), "Test Case 7 Failed");
    }

    @Test
    public void testCase8() {
        assertEquals("bababababab", Task174_OPENAI_gpt_4o.shortestPalindrome("ababababab"), "Test Case 8 Failed");
    }

    @Test
    public void testCase9() {
        assertEquals("zyxyz", Task174_OPENAI_gpt_4o.shortestPalindrome("xyz"), "Test Case 9 Failed");
    }

    @Test
    public void testCase10() {
        assertEquals("caabbaac", Task174_OPENAI_gpt_4o.shortestPalindrome("abbaac"), "Test Case 10 Failed");
    }
}
