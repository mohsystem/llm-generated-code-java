package gemini.task19;

import gemini.task19.Task19_GEMINI_gemini_1_5_pro_001;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task19_TestCase {

    @Test
    void testCase1() {
        String sentence = "Hey fellow warriors";
        String expected = "Hey wollef sroirraw";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }

    @Test
    void testCase2() {
        String sentence = "This is a test";
        String expected = "This is a test";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }

    @Test
    void testCase3() {
        String sentence = "This is another test";
        String expected = "This is rehtona test";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }

    @Test
    void testCase4() {
        String sentence = "Welcome to the jungle";
        String expected = "emocleW to the elgnuj";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }

    @Test
    void testCase5() {
        String sentence = "You are amazing";
        String expected = "You are gnizama";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }

    @Test
    void testCase6() {
        String sentence = "Just a simple example";
        String expected = "Just a elpmis elpmaxe";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }

    @Test
    void testCase7() {
        String sentence = "Short words are not reversed";
        String expected = "trohS sdrow are not desrever";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }

    @Test
    void testCase8() {
        String sentence = "Reverse only long words";
        String expected = "esreveR only long sdrow";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }

    @Test
    void testCase9() {
        String sentence = "Exceptional cases should work too";
        String expected = "lanoitpecxE sesac dluohs work too";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }

    @Test
    void testCase10() {
        String sentence = "This sentence contains multiple long words";
        String expected = "This ecnetnes sniatnoc elpitlum long sdrow";
        assertEquals(expected, new Task19_GEMINI_gemini_1_5_pro_001().spinWords(sentence));
    }
}
