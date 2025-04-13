package llama3.task59;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task59Test {

    @Test
    public void testAllUniqueCharacters() {
        assertEquals("A-Bb-Ccc-Dddd", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum("abcd"));
    }

    @Test
    public void testMixedCaseCharacters() {
        assertEquals("R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum("RqaEzty"));
    }

    @Test
    public void testMixedCaseCharactersWithRepeating() {
        assertEquals("C-Ww-Aaa-Tttt", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum("cwAt"));
    }

    @Test
    public void testSingleCharacterString() {
        assertEquals("A", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum("a"));
    }

    @Test
    public void testAllUppercaseCharacters() {
        assertEquals("X-Yy-Zzz", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum("XYZ"));
    }

    @Test
    public void testAllLowercaseCharacters() {
        assertEquals("X-Yy-Zzz", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum("xyz"));
    }

    @Test
    public void testMixedCaseWithRepeatingCharacters() {
        assertEquals("A-Aa-Aaa-Aaaa", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum("aAaA"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum(""));
    }

    @Test
    public void testStringWithRepeatedCharacters() {
        assertEquals("A-Aa-Aaa-Bbbb-Bbbbb-Bbbbbb", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum("aaabbb"));
    }

    @Test
    public void testCaseSensitivityCheck() {
        assertEquals("A-Aa-Bbb-Bbbb-Ccccc-Cccccc", Task59_PERPLEXITY_llama_3_sonar_large_32k_chat.accum("AaBbCc"));
    }
}
