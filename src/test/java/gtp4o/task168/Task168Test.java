package gtp4o.task168;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task168Test {

    @Test
    public void testCase1() {
        assertEquals("aqold", Task168_OPENAI_gpt_4o.tweakLetters("apple", new int[]{0, 1, -1, 0, -1}));
    }

    @Test
    public void testCase2() {
        assertEquals("manx", Task168_OPENAI_gpt_4o.tweakLetters("many", new int[]{0, 0, 0, -1}));
    }

    @Test
    public void testCase3() {
        assertEquals("sijop", Task168_OPENAI_gpt_4o.tweakLetters("rhino", new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void testCase4() {
        assertEquals("bcd", Task168_OPENAI_gpt_4o.tweakLetters("abc", new int[]{1, 1, 1}));
    }

    @Test
    public void testCase5() {
        assertEquals("yza", Task168_OPENAI_gpt_4o.tweakLetters("xyz", new int[]{1, 1, 1}));
    }

    @Test
    public void testCase6() {
        assertEquals("gemln", Task168_OPENAI_gpt_4o.tweakLetters("hello", new int[]{-1, 0, 1, 0, -1}));
    }

    @Test
    public void testCase7() {
        assertEquals("sdrs", Task168_OPENAI_gpt_4o.tweakLetters("test", new int[]{-1, -1, -1, -1}));
    }

    @Test
    public void testCase8() {
        assertEquals("bdfh", Task168_OPENAI_gpt_4o.tweakLetters("abcd", new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testCase9() {
        assertEquals("yyy", Task168_OPENAI_gpt_4o.tweakLetters("zzz", new int[]{-1, -1, -1}));
    }

    @Test
    public void testCase10() {
        assertEquals("wpqnb", Task168_OPENAI_gpt_4o.tweakLetters("world", new int[]{0, 1, -1, 2, -2}));
    }
}
