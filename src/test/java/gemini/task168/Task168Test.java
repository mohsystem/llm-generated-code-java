package gemini.task168;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task168Test {

    @Test
    public void testCase1() {
        assertEquals("aqold", Solution.tweakLetters("apple", new int[]{0, 1, -1, 0, -1}));
    }

    @Test
    public void testCase2() {
        assertEquals("manx", Solution.tweakLetters("many", new int[]{0, 0, 0, -1}));
    }

    @Test
    public void testCase3() {
        assertEquals("sijop", Solution.tweakLetters("rhino", new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void testCase4() {
        assertEquals("bcd", Solution.tweakLetters("abc", new int[]{1, 1, 1}));
    }

    @Test
    public void testCase5() {
        assertEquals("yza", Solution.tweakLetters("xyz", new int[]{1, 1, 1}));
    }

    @Test
    public void testCase6() {
        assertEquals("gemln", Solution.tweakLetters("hello", new int[]{-1, 0, 1, 0, -1}));
    }

    @Test
    public void testCase7() {
        assertEquals("sdrs", Solution.tweakLetters("test", new int[]{-1, -1, -1, -1}));
    }

    @Test
    public void testCase8() {
        assertEquals("bdfh", Solution.tweakLetters("abcd", new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testCase9() {
        assertEquals("yyy", Solution.tweakLetters("zzz", new int[]{-1, -1, -1}));
    }

    @Test
    public void testCase10() {
        assertEquals("wpqnb", Solution.tweakLetters("world", new int[]{0, 1, -1, 2, -2}));
    }
}
