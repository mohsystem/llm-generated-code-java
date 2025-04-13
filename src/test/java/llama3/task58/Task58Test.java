package llama3.task58;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task58Test {

    @Test
    public void testAllXAndO() {
        assertTrue(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo("ooxx"));
    }

    @Test
    public void testMoreXThanO() {
        assertFalse(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo("xooxx"));
    }

    @Test
    public void testMoreOThanX() {
        assertTrue(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo("xxoo"));
    }

    @Test
    public void testCaseInsensitive() {
        assertTrue(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo("ooxXm"));
    }

    @Test
    public void testNoXNoO() {
        assertTrue(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo("zpzpzpp"));
    }

    @Test
    public void testNoXWithO() {
        assertFalse(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo("zzoo"));
    }

    @Test
    public void testNoOWithX() {
        assertFalse(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo("xxxx"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo(""));
    }

    @Test
    public void testSingleCharacterO() {
        assertFalse(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo("o"));
    }

    @Test
    public void testSingleCharacterX() {
        assertFalse(Task58_PERPLEXITY_llama_3_sonar_large_32k_chat.xo("x"));
    }
}
