package codestral.task12;

import org.junit.jupiter.api.Test;

import static codestral.task12.Task12_MISTRAL_codestral_latest.highScoringWord;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task12_TestCase {

    @Test
    void testBasicExample1() {
        // Test basic example with diverse words
        assertEquals("taxi", highScoringWord("man i need a taxi up to ubud"));
    }

    @Test
    void testBasicExample2() {
        // Test basic example with different set of words
        assertEquals("volcano", highScoringWord("what time are we climbing up the volcano"));
    }

    @Test
    void testBasicExample3() {
        // Test basic example with a smaller set of words
        assertEquals("semynak", highScoringWord("take me to semynak"));
    }

    @Test
    void testSingleWord() {
        // Test with a single word
        assertEquals("hello", highScoringWord("hello"));
    }

    @Test
    void testMultipleWordsSameScore() {
        // Test with multiple words having the same score
        assertEquals("apple", highScoringWord("apple banana cherry"));
    }

    @Test
    void testDifferentScores() {
        // Test with words having different scores
        assertEquals("zebra", highScoringWord("ant bear zebra"));
    }

    @Test
    void testWordsWithOneLetter() {
        // Test with single-letter words
        assertEquals("z", highScoringWord("a b c d e f g h i j k l m n o p q r s t u v w x y z"));
    }

    @Test
    void testEmptyString() {
        // Test with an empty string
        assertEquals("", highScoringWord(""));
    }

    @Test
    void testWordsWithSpecialCharacters() {
        // Test with words containing special characters (should be handled as invalid input in this context)
        assertEquals("hello", highScoringWord("hello@ world!"));
    }

    @Test
    void testLongWords() {
        // Test with long words to check performance
        assertEquals("pneumoultramicroscopicsilicovolcanoconiosis", highScoringWord(
                "pneumoultramicroscopicsilicovolcanoconiosis supercalifragilisticexpialidocious antidisestablishmentarianism"));
    }
}
