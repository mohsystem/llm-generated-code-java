package gtp4o.task31;

import org.junit.jupiter.api.Test;

import static gtp4o.task31.Task31_OPENAI_gpt_4o.dnaStrand;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task31Test {

    @Test
    void testComplementaryStrand1() {
        // Test case with standard input
        assertEquals("TAACG", dnaStrand("ATTGC"));
    }

    @Test
    void testComplementaryStrand2() {
        // Test case with standard input
        assertEquals("CATA", dnaStrand("GTAT"));
    }

    @Test
    void testSingleCharacterA() {
        // Test case with a single character 'A'
        assertEquals("T", dnaStrand("A"));
    }

    @Test
    void testSingleCharacterT() {
        // Test case with a single character 'T'
        assertEquals("A", dnaStrand("T"));
    }

    @Test
    void testSingleCharacterC() {
        // Test case with a single character 'C'
        assertEquals("G", dnaStrand("C"));
    }

    @Test
    void testSingleCharacterG() {
        // Test case with a single character 'G'
        assertEquals("C", dnaStrand("G"));
    }

    @Test
    void testRepeatingCharacters() {
        // Test case with repeating characters
        assertEquals("TTTT", dnaStrand("AAAA"));
    }

    @Test
    void testAlternatingCharacters() {
        // Test case with alternating characters
        assertEquals("ATAT", dnaStrand("TATA"));
    }

    @Test
    void testLongStrand() {
        // Test case with a long DNA strand
        assertEquals("CGCGCGCGCG", dnaStrand("GCGCGCGCGC"));
    }

    @Test
    void testMixedCase() {
        // Test case with a mixed-case DNA strand
        assertEquals("TAACG", dnaStrand("ATTGC".toLowerCase()));
    }
}
