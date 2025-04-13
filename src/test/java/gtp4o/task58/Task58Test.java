package gtp4o.task58;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task58Test {

    @Test
    public void testAllXAndO() {
        assertTrue(Task58_OPENAI_gpt_4o.XO("ooxx"));
    }

    @Test
    public void testMoreXThanO() {
        assertFalse(Task58_OPENAI_gpt_4o.XO("xooxx"));
    }

    @Test
    public void testMoreOThanX() {
        assertTrue(Task58_OPENAI_gpt_4o.XO("xxoo"));
    }

    @Test
    public void testCaseInsensitive() {
        assertTrue(Task58_OPENAI_gpt_4o.XO("ooxXm"));
    }

    @Test
    public void testNoXNoO() {
        assertTrue(Task58_OPENAI_gpt_4o.XO("zpzpzpp"));
    }

    @Test
    public void testNoXWithO() {
        assertFalse(Task58_OPENAI_gpt_4o.XO("zzoo"));
    }

    @Test
    public void testNoOWithX() {
        assertFalse(Task58_OPENAI_gpt_4o.XO("xxxx"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(Task58_OPENAI_gpt_4o.XO(""));
    }

    @Test
    public void testSingleCharacterO() {
        assertFalse(Task58_OPENAI_gpt_4o.XO("o"));
    }

    @Test
    public void testSingleCharacterX() {
        assertFalse(Task58_OPENAI_gpt_4o.XO("x"));
    }
}
