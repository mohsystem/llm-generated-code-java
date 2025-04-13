package gtp4o.task59;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task59Test {

    @Test
    public void testAllUniqueCharacters() {
        assertEquals("A-Bb-Ccc-Dddd", Task59_OPENAI_gpt_4o.accum("abcd"));
    }

    @Test
    public void testMixedCaseCharacters() {
        assertEquals("R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy", Task59_OPENAI_gpt_4o.accum("RqaEzty"));
    }

    @Test
    public void testMixedCaseCharactersWithRepeating() {
        assertEquals("C-Ww-Aaa-Tttt", Task59_OPENAI_gpt_4o.accum("cwAt"));
    }

    @Test
    public void testSingleCharacterString() {
        assertEquals("A", Task59_OPENAI_gpt_4o.accum("a"));
    }

    @Test
    public void testAllUppercaseCharacters() {
        assertEquals("X-Yy-Zzz", Task59_OPENAI_gpt_4o.accum("XYZ"));
    }

    @Test
    public void testAllLowercaseCharacters() {
        assertEquals("X-Yy-Zzz", Task59_OPENAI_gpt_4o.accum("xyz"));
    }

    @Test
    public void testMixedCaseWithRepeatingCharacters() {
        assertEquals("A-Aa-Aaa-Aaaa", Task59_OPENAI_gpt_4o.accum("aAaA"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", Task59_OPENAI_gpt_4o.accum(""));
    }

    @Test
    public void testStringWithRepeatedCharacters() {
        assertEquals("A-Aa-Aaa-Bbbb-Bbbbb-Bbbbbb", Task59_OPENAI_gpt_4o.accum("aaabbb"));
    }

    @Test
    public void testCaseSensitivityCheck() {
        assertEquals("A-Aa-Bbb-Bbbb-Ccccc-Cccccc", Task59_OPENAI_gpt_4o.accum("AaBbCc"));
    }
}
