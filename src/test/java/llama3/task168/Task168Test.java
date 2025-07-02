package llama3.task168;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task168Test {

    @Test
    public void testCase1() {
        assertEquals("aqold", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("apple", new int[]{0, 1, -1, 0, -1}));
    }

    @Test
    public void testCase2() {
        assertEquals("manx", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("many", new int[]{0, 0, 0, -1}));
    }

    @Test
    public void testCase3() {
        assertEquals("sijop", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("rhino", new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void testCase4() {
        assertEquals("bcd", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("abc", new int[]{1, 1, 1}));
    }

    @Test
    public void testCase5() {
        assertEquals("yza", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("xyz", new int[]{1, 1, 1}));
    }

    @Test
    public void testCase6() {
        assertEquals("gemln", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("hello", new int[]{-1, 0, 1, 0, -1}));
    }

    @Test
    public void testCase7() {
        assertEquals("sdrs", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("test", new int[]{-1, -1, -1, -1}));
    }

    @Test
    public void testCase8() {
        assertEquals("bdfh", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("abcd", new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testCase9() {
        assertEquals("yyy", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("zzz", new int[]{-1, -1, -1}));
    }

    @Test
    public void testCase10() {
        assertEquals("wpqnb", Task168_PERPLEXITY_llama_3_sonar_large_32k_chat.tweakLetters("world", new int[]{0, 1, -1, 2, -2}));
    }
}
