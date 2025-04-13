package codestral.task58;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task58Test {

    @Test
    public void testAllXAndO() {
        assertTrue(Task58_MISTRAL_codestral_latest.getXO("ooxx"));
    }

    @Test
    public void testMoreXThanO() {
        assertFalse(Task58_MISTRAL_codestral_latest.getXO("xooxx"));
    }

    @Test
    public void testMoreOThanX() {
        assertTrue(Task58_MISTRAL_codestral_latest.getXO("xxoo"));
    }

    @Test
    public void testCaseInsensitive() {
        assertTrue(Task58_MISTRAL_codestral_latest.getXO("ooxXm"));
    }

    @Test
    public void testNoXNoO() {
        assertTrue(Task58_MISTRAL_codestral_latest.getXO("zpzpzpp"));
    }

    @Test
    public void testNoXWithO() {
        assertFalse(Task58_MISTRAL_codestral_latest.getXO("zzoo"));
    }

    @Test
    public void testNoOWithX() {
        assertFalse(Task58_MISTRAL_codestral_latest.getXO("xxxx"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(Task58_MISTRAL_codestral_latest.getXO(""));
    }

    @Test
    public void testSingleCharacterO() {
        assertFalse(Task58_MISTRAL_codestral_latest.getXO("o"));
    }

    @Test
    public void testSingleCharacterX() {
        assertFalse(Task58_MISTRAL_codestral_latest.getXO("x"));
    }
}
