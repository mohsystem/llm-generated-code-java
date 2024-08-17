package llama3.task30;

import org.junit.jupiter.api.Test;
import static llama3.task30.Task30_PERPLEXITY_llama_3_sonar_large_32k_chat.longest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task30Test {

    @Test
    void testDistinctCharacters() {
        // Test with distinct characters in s1 and s2
        assertEquals("abcdefklmopqwxy", longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
    }

    @Test
    void testIdenticalStrings() {
        // Test with identical strings
        assertEquals("abcdefghijklmnopqrstuvwxyz", longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void testEmptyStrings() {
        // Test with both strings empty
        assertEquals("", longest("", ""));
    }

    @Test
    void testOneEmptyString() {
        // Test with one string empty and the other full
        assertEquals("abcdef", longest("", "abcdef"));
    }

    @Test
    void testNoOverlappingCharacters() {
        // Test with no overlapping characters between s1 and s2
        assertEquals("abcdef", longest("abc", "def"));
    }

    @Test
    void testAllOverlappingCharacters() {
        // Test with all characters in s1 and s2 overlapping
        assertEquals("abcd", longest("abc", "abcd"));
    }

    @Test
    void testCaseInsensitive() {
        // Test with case sensitivity (input should only include lowercase letters)
        assertEquals("abcfxyz", longest("abc", "xyzf"));
    }

    @Test
    void testLongStrings() {
        // Test with long strings
        String s1 = "abcdefghijklmnopqrstuvwxyzaaa";
        String s2 = "zyxwvutsrqponmlkjihgfedcbaaaa";
        assertEquals("abcdefghijklmnopqrstuvwxyz", longest(s1, s2));
    }

    @Test
    void testSingleCharacterStrings() {
        // Test with single character strings
        assertEquals("a", longest("a", "a"));
    }

    @Test
    void testRepeatedCharacters() {
        // Test with repeated characters in both strings
        assertEquals("abcd", longest("aaaa", "bbbbccccdddd"));
    }
}
