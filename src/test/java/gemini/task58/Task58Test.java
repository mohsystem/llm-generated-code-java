package gemini.task58;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task58Test {

    @Test
    public void testAllXAndO() {
        assertTrue(Task58_GEMINI_gemini_1_5_pro_001.XO("ooxx"));
    }

    @Test
    public void testMoreXThanO() {
        assertFalse(Task58_GEMINI_gemini_1_5_pro_001.XO("xooxx"));
    }

    @Test
    public void testMoreOThanX() {
        assertTrue(Task58_GEMINI_gemini_1_5_pro_001.XO("xxoo"));
    }

    @Test
    public void testCaseInsensitive() {
        assertTrue(Task58_GEMINI_gemini_1_5_pro_001.XO("ooxXm"));
    }

    @Test
    public void testNoXNoO() {
        assertTrue(Task58_GEMINI_gemini_1_5_pro_001.XO("zpzpzpp"));
    }

    @Test
    public void testNoXWithO() {
        assertFalse(Task58_GEMINI_gemini_1_5_pro_001.XO("zzoo"));
    }

    @Test
    public void testNoOWithX() {
        assertFalse(Task58_GEMINI_gemini_1_5_pro_001.XO("xxxx"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(Task58_GEMINI_gemini_1_5_pro_001.XO(""));
    }

    @Test
    public void testSingleCharacterO() {
        assertFalse(Task58_GEMINI_gemini_1_5_pro_001.XO("o"));
    }

    @Test
    public void testSingleCharacterX() {
        assertFalse(Task58_GEMINI_gemini_1_5_pro_001.XO("x"));
    }
}
