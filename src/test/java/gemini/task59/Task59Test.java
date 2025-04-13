package codestral.task59;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task59Test {

    @Test
    public void testAllUniqueCharacters() {
        assertEquals("A-Bb-Ccc-Dddd", Task59_MISTRAL_codestral_latest.accum("abcd"));
    }

    @Test
    public void testMixedCaseCharacters() {
        assertEquals("R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy", Task59_MISTRAL_codestral_latest.accum("RqaEzty"));
    }

    @Test
    public void testMixedCaseCharactersWithRepeating() {
        assertEquals("C-Ww-Aaa-Tttt", Task59_MISTRAL_codestral_latest.accum("cwAt"));
    }

    @Test
    public void testSingleCharacterString() {
        assertEquals("A", Task59_MISTRAL_codestral_latest.accum("a"));
    }

    @Test
    public void testAllUppercaseCharacters() {
        assertEquals("X-Yy-Zzz", Task59_MISTRAL_codestral_latest.accum("XYZ"));
    }

    @Test
    public void testAllLowercaseCharacters() {
        assertEquals("X-Yy-Zzz", Task59_MISTRAL_codestral_latest.accum("xyz"));
    }

    @Test
    public void testMixedCaseWithRepeatingCharacters() {
        assertEquals("A-Aa-Aaa-Aaaa", Task59_MISTRAL_codestral_latest.accum("aAaA"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", Task59_MISTRAL_codestral_latest.accum(""));
    }

    @Test
    public void testStringWithRepeatedCharacters() {
        assertEquals("A-Aa-Aaa-Bbbb-Bbbbb-Bbbbbb", Task59_MISTRAL_codestral_latest.accum("aaabbb"));
    }

    @Test
    public void testCaseSensitivityCheck() {
        assertEquals("A-Aa-Bbb-Bbbb-Ccccc-Cccccc", Task59_MISTRAL_codestral_latest.accum("AaBbCc"));
    }
}
