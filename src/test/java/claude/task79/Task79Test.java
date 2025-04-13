package claude.task79;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task79Test {

    @Test
    public void testBasicEncryption() {
        String result = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("HELLO", 3);
        assertEquals("KHOOR", result);  // Expected from Python
    }

    @Test
    public void testEncryptionWithSpaces() {
        String result = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("HELLO WORLD", 5);
        assertEquals("QNUXZ DMJFZ", result);  // Expected from Python
    }

    @Test
    public void testEncryptionWithSpecialCharacters() {
        String result = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("HELLO, WORLD!", 2);
        assertEquals("RDSSV, UFSVF!", result);  // Expected from Python
    }

    @Test
    public void testEmptyMessage() {
        String result = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("", 10);
        assertEquals("", result);
    }

    @Test
    public void testEncryptionWithNumbers() {
        String result = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("HELLO123", 4);
        assertEquals("GDKKN123", result);  // Expected from Python
    }

    @Test
    public void testSameKeyProducesSameOutput() {
        String result1 = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("PYTHON", 6);
        String result2 = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("PYTHON", 6);
        assertEquals(result1, result2);
    }

    @Test
    public void testDifferentKeyProducesDifferentOutput() {
        String result1 = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("PYTHON", 6);
        String result2 = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("PYTHON", 8);
        assertNotEquals(result1, result2);
    }

    @Test
    public void testCaseInsensitiveEncryption() {
        String result = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("Python", 7);
        assertEquals("DKSOQD", result);  // Expected from Python
    }

    @Test
    public void testKeyAffectsShuffling() {
        String result1 = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("TEST", 9);
        String result2 = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("TEST", 10);
        assertNotEquals(result1, result2);
    }

    @Test
    public void testSameKeyAndMessageDifferentCases() {
        String result1 = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("test", 11);
        String result2 = Task79_CLAUDE_claude_3_5_sonnet_20240620.encryptMessage("TEST", 11);
        assertEquals(result1, result2);
    }
}
