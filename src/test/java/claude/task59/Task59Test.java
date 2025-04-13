package claude.task59;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task59Test {

    @Test
    public void testAllUniqueCharacters() {
        assertEquals("A-Bb-Ccc-Dddd", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum("abcd"));
    }

    @Test
    public void testMixedCaseCharacters() {
        assertEquals("R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum("RqaEzty"));
    }

    @Test
    public void testMixedCaseCharactersWithRepeating() {
        assertEquals("C-Ww-Aaa-Tttt", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum("cwAt"));
    }

    @Test
    public void testSingleCharacterString() {
        assertEquals("A", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum("a"));
    }

    @Test
    public void testAllUppercaseCharacters() {
        assertEquals("X-Yy-Zzz", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum("XYZ"));
    }

    @Test
    public void testAllLowercaseCharacters() {
        assertEquals("X-Yy-Zzz", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum("xyz"));
    }

    @Test
    public void testMixedCaseWithRepeatingCharacters() {
        assertEquals("A-Aa-Aaa-Aaaa", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum("aAaA"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum(""));
    }

    @Test
    public void testStringWithRepeatedCharacters() {
        assertEquals("A-Aa-Aaa-Bbbb-Bbbbb-Bbbbbb", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum("aaabbb"));
    }

    @Test
    public void testCaseSensitivityCheck() {
        assertEquals("A-Aa-Bbb-Bbbb-Ccccc-Cccccc", Task59_CLAUDE_claude_3_5_sonnet_20240620.accum("AaBbCc"));
    }
}
