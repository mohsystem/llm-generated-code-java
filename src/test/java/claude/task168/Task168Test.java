package claude.task168;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task168Test {

    @Test
    public void testCase1() {
        assertEquals("aqold", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("apple", new int[]{0, 1, -1, 0, -1}));
    }

    @Test
    public void testCase2() {
        assertEquals("manx", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("many", new int[]{0, 0, 0, -1}));
    }

    @Test
    public void testCase3() {
        assertEquals("sijop", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("rhino", new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void testCase4() {
        assertEquals("bcd", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("abc", new int[]{1, 1, 1}));
    }

    @Test
    public void testCase5() {
        assertEquals("yza", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("xyz", new int[]{1, 1, 1}));
    }

    @Test
    public void testCase6() {
        assertEquals("gemln", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("hello", new int[]{-1, 0, 1, 0, -1}));
    }

    @Test
    public void testCase7() {
        assertEquals("sdrs", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("test", new int[]{-1, -1, -1, -1}));
    }

    @Test
    public void testCase8() {
        assertEquals("bdfh", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("abcd", new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testCase9() {
        assertEquals("yyy", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("zzz", new int[]{-1, -1, -1}));
    }

    @Test
    public void testCase10() {
        assertEquals("wpqnb", Task168_CLAUDE_claude_3_5_sonnet_20240620.tweakLetters("world", new int[]{0, 1, -1, 2, -2}));
    }
}
