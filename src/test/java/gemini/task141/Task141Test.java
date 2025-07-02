package gemini.task141;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task141Test {

     private String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    @Test
    void testBasicCase() {
        assertEquals("olleh", reverseString("hello"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", reverseString(""));
    }

    @Test
    void testSingleCharacter() {
        assertEquals("a", reverseString("a"));
    }

    @Test
    void testPalindromeString() {
        assertEquals("madam", reverseString("madam"));
    }

    @Test
    void testStringWithSpaces() {
        assertEquals("dlrow olleh", reverseString("hello world"));
    }

    @Test
    void testStringWithNumbers() {
        assertEquals("54321", reverseString("12345"));
    }

    @Test
    void testStringWithSpecialCharacters() {
        assertEquals(")(*&^%$#@!", reverseString("!@#$%^&*()"));
    }

    @Test
    void testStringWithMixedCase() {
        assertEquals("oLLeH", reverseString("HeLLo"));
    }

    @Test
    void testStringWithLeadingAndTrailingSpaces() {
        assertEquals("  olleh  ", reverseString("  hello  "));
    }

    @Test
    void testLongString() {
        assertEquals("zyxwvutsrqponmlkjihgfedcba", reverseString("abcdefghijklmnopqrstuvwxyz"));
    }
}
