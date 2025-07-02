package claude.task174;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task174Test {

    Solution sln = new Solution();

    @Test
    public void testCase1() {
        assertEquals("racecar", sln.shortestPalindrome("racecar"), "Test Case 1 Failed");
    }

    @Test
    public void testCase2() {
        assertEquals("aaacecaaa", sln.shortestPalindrome("aacecaaa"), "Test Case 2 Failed");
    }

    @Test
    public void testCase3() {
        assertEquals("dcbabcd", sln.shortestPalindrome("abcd"), "Test Case 3 Failed");
    }

    @Test
    public void testCase4() {
        assertEquals("", sln.shortestPalindrome(""), "Test Case 4 Failed");
    }

    @Test
    public void testCase5() {
        assertEquals("a", sln.shortestPalindrome("a"), "Test Case 5 Failed");
    }

    @Test
    public void testCase6() {
        assertEquals("aaaaaaaa", sln.shortestPalindrome("aaaaaaaa"), "Test Case 6 Failed");
    }

    @Test
    public void testCase7() {
        assertEquals("adcbaabcda", sln.shortestPalindrome("abcda"), "Test Case 7 Failed");
    }

    @Test
    public void testCase8() {
        assertEquals("bababababab", sln.shortestPalindrome("ababababab"), "Test Case 8 Failed");
    }

    @Test
    public void testCase9() {
        assertEquals("zyxyz", sln.shortestPalindrome("xyz"), "Test Case 9 Failed");
    }

    @Test
    public void testCase10() {
        assertEquals("caabbaac", sln.shortestPalindrome("abbaac"), "Test Case 10 Failed");
    }
}
