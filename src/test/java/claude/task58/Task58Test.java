package claude.task58;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task58Test {

    @Test
    public void testAllXAndO() {
        assertTrue(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO("ooxx"));
    }

    @Test
    public void testMoreXThanO() {
        assertFalse(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO("xooxx"));
    }

    @Test
    public void testMoreOThanX() {
        assertTrue(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO("xxoo"));
    }

    @Test
    public void testCaseInsensitive() {
        assertTrue(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO("ooxXm"));
    }

    @Test
    public void testNoXNoO() {
        assertTrue(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO("zpzpzpp"));
    }

    @Test
    public void testNoXWithO() {
        assertFalse(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO("zzoo"));
    }

    @Test
    public void testNoOWithX() {
        assertFalse(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO("xxxx"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO(""));
    }

    @Test
    public void testSingleCharacterO() {
        assertFalse(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO("o"));
    }

    @Test
    public void testSingleCharacterX() {
        assertFalse(Task58_CLAUDE_claude_3_5_sonnet_20240620.getXO("x"));
    }
}
