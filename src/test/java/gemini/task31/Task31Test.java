package gemini.task31;

import org.junit.jupiter.api.Test;

import static gemini.task31.Task31_GEMINI_gemini_1_5_pro_001.makeComplement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task31Test {

    @Test
    void testComplementaryStrand1() {
        // Test case with standard input
        assertEquals("TAACG", makeComplement("ATTGC"));
    }

    @Test
    void testComplementaryStrand2() {
        // Test case with standard input
        assertEquals("CATA", makeComplement("GTAT"));
    }

    @Test
    void testSingleCharacterA() {
        // Test case with a single character 'A'
        assertEquals("T", makeComplement("A"));
    }

    @Test
    void testSingleCharacterT() {
        // Test case with a single character 'T'
        assertEquals("A", makeComplement("T"));
    }

    @Test
    void testSingleCharacterC() {
        // Test case with a single character 'C'
        assertEquals("G", makeComplement("C"));
    }

    @Test
    void testSingleCharacterG() {
        // Test case with a single character 'G'
        assertEquals("C", makeComplement("G"));
    }

    @Test
    void testRepeatingCharacters() {
        // Test case with repeating characters
        assertEquals("TTTT", makeComplement("AAAA"));
    }

    @Test
    void testAlternatingCharacters() {
        // Test case with alternating characters
        assertEquals("ATAT", makeComplement("TATA"));
    }

    @Test
    void testLongStrand() {
        // Test case with a long DNA strand
        assertEquals("CGCGCGCGCG", makeComplement("GCGCGCGCGC"));
    }

    @Test
    void testMixedCase() {
        // Test case with a mixed-case DNA strand
        assertEquals("TAACG", makeComplement("ATTGC".toLowerCase()));
    }
}
