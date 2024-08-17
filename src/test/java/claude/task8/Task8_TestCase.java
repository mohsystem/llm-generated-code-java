package claude.task8;

import org.junit.jupiter.api.Test;
import static claude.task8.Task8_CLAUDE_claude_3_5_sonnet_20240620.findMissingLetter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8_TestCase {

    @Test
    void testFindMissingLetterInLowerCaseMiddle() {
        // Test with a missing letter in the middle
        assertEquals('e', findMissingLetter(new char[] {'a', 'b', 'c', 'd', 'f'}));
    }

    @Test
    void testFindMissingLetterInLowerCaseBeginning() {
        // Test with a missing letter at the beginning
        assertEquals('a', findMissingLetter(new char[] {'b', 'c', 'd', 'e', 'f'}));
    }

    @Test
    void testFindMissingLetterInLowerCaseEnd() {
        // Test with a missing letter at the end
        assertEquals('g', findMissingLetter(new char[] {'a', 'b', 'c', 'd', 'e', 'f'}));
    }

    @Test
    void testFindMissingLetterInUpperCaseMiddle() {
        // Test with a missing letter in the middle
        assertEquals('P', findMissingLetter(new char[] {'O', 'Q', 'R', 'S'}));
    }

    @Test
    void testFindMissingLetterInUpperCaseBeginning() {
        // Test with a missing letter at the beginning
        assertEquals('A', findMissingLetter(new char[] {'B', 'C', 'D', 'E'}));
    }

    @Test
    void testFindMissingLetterInUpperCaseEnd() {
        // Test with a missing letter at the end
        assertEquals('G', findMissingLetter(new char[] {'A', 'B', 'C', 'D', 'E', 'F'}));
    }

    @Test
    void testFindMissingLetterWithAdjacentLetters() {
        // Test with only two letters, missing letter is between them
        assertEquals('c', findMissingLetter(new char[] {'a', 'b', 'd'}));
    }

    @Test
    void testFindMissingLetterLargeRange() {
        // Test with a large range of letters missing one letter
        assertEquals('m', findMissingLetter(new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'n'}));
    }

    @Test
    void testFindMissingLetterAtEdge() {
        // Test with a range where missing letter is at the edge
        assertEquals('Z', findMissingLetter(new char[] {'X', 'Y'}));
    }

    @Test
    void testFindMissingLetterSingleMissingLetter() {
        // Test with only two letters, where missing letter is clearly identified
        assertEquals('b', findMissingLetter(new char[] {'a', 'c'}));
    }
}
