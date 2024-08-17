package codestral.task17;

import codestral.task17.Task17_MISTRAL_codestral_latest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task17_TestCase {

    @Test
    void testCase1() {
        String phrase = "how can mirrors be real if our eyes aren't real";
        String expected = "How Can Mirrors Be Real If Our Eyes Aren't Real";
        assertEquals(expected, new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }

    @Test
    void testCase2() {
        String phrase = "the karate kid is a great movie";
        String expected = "The Karate Kid Is A Great Movie";
        assertEquals(expected, new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }

    @Test
    void testCase3() {
        String phrase = "after earth was released in 2013";
        String expected = "After Earth Was Released In 2013";
        assertEquals(expected, new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }

    @Test
    void testCase4() {
        String phrase = "i think therefore i am";
        String expected = "I Think Therefore I Am";
        assertEquals(expected, new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }

    @Test
    void testCase5() {
        String phrase = "to be or not to be";
        String expected = "To Be Or Not To Be";
        assertEquals(expected, new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }

    @Test
    void testCase6() {
        String phrase = "life is but a dream";
        String expected = "Life Is But A Dream";
        assertEquals(expected, new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }

    @Test
    void testCase7() {
        String phrase = "it's a beautiful day in the neighborhood";
        String expected = "It's A Beautiful Day In The Neighborhood";
        assertEquals(expected, new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }

    @Test
    void testCase8() {
        String phrase = "null string should return null";
        String expected = "Null String Should Return Null";
        assertEquals(expected, new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }

    @Test
    void testCase9() {
        String phrase = "";
        assertNull(new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }

    @Test
    void testCase10() {
        String phrase = null;
        assertNull(new Task17_MISTRAL_codestral_latest().toJadenCase(phrase));
    }
}
