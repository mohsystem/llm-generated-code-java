package gemini.task12;

import org.junit.jupiter.api.Test;
import static gemini.task12.Task12_GEMINI_gemini_1_5_pro_001.high;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task12_TestCase {

    @Test
    void testBasicExample1() {
        // Test basic example with diverse words
        assertEquals("taxi", high("man i need a taxi up to ubud"));
    }

    @Test
    void testBasicExample2() {
        // Test basic example with different set of words
        assertEquals("volcano", high("what time are we climbing up the volcano"));
    }

    @Test
    void testBasicExample3() {
        // Test basic example with a smaller set of words
        assertEquals("semynak", high("take me to semynak"));
    }

    @Test
    void testSingleWord() {
        // Test with a single word
        assertEquals("hello", high("hello"));
    }

    @Test
    void testMultipleWordsSameScore() {
        // Test with multiple words having the same score
        assertEquals("apple", high("apple banana cherry"));
    }

    @Test
    void testDifferentScores() {
        // Test with words having different scores
        assertEquals("zebra", high("ant bear zebra"));
    }

    @Test
    void testWordsWithOneLetter() {
        // Test with single-letter words
        assertEquals("z", high("a b c d e f g h i j k l m n o p q r s t u v w x y z"));
    }

    @Test
    void testEmptyString() {
        // Test with an empty string
        assertEquals("", high(""));
    }

    @Test
    void testWordsWithSpecialCharacters() {
        // Test with words containing special characters (should be handled as invalid input in this context)
        assertEquals("hello", high("hello@ world!"));
    }

    @Test
    void testLongWords() {
        // Test with long words to check performance
        assertEquals("pneumoultramicroscopicsilicovolcanoconiosis", high(
                "pneumoultramicroscopicsilicovolcanoconiosis supercalifragilisticexpialidocious antidisestablishmentarianism"));
    }
}
