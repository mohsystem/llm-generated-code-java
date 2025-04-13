package gemini.task51;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task51Test {

    @Test
    public void testBasicEncryption() {
        assertEquals("def", Task51_GEMINI_gemini_1_5_pro_001.encrypt("abc", 3));
    }

    @Test
    public void testEncryptionWithUppercase() {
        assertEquals("DEF", Task51_GEMINI_gemini_1_5_pro_001.encrypt("ABC", 3));
    }

    @Test
    public void testEncryptionWithMixedCase() {
        assertEquals("cDe", Task51_GEMINI_gemini_1_5_pro_001.encrypt("aBc", 2));
    }

    @Test
    public void testEncryptionWithNonAlphaCharacters() {
        assertEquals("f g-h", Task51_GEMINI_gemini_1_5_pro_001.encrypt("a b-c", 5));
    }

    @Test
    public void testEncryptionWithLargeShiftValue() {
        assertEquals("bcd", Task51_GEMINI_gemini_1_5_pro_001.encrypt("xyz", 30));
    }

    @Test
    public void testEncryptionWithNegativeShiftValue() {
        assertEquals("abc", Task51_GEMINI_gemini_1_5_pro_001.encrypt("def", -3));
    }

    @Test
    public void testEncryptionWithShiftValueZero() {
        assertEquals("hello", Task51_GEMINI_gemini_1_5_pro_001.encrypt("hello", 0));
    }

    @Test
    public void testEncryptionWithShiftValue26() {
        assertEquals("xyz", Task51_GEMINI_gemini_1_5_pro_001.encrypt("xyz", 26));
    }

    @Test
    public void testEncryptionEmptyString() {
        assertEquals("", Task51_GEMINI_gemini_1_5_pro_001.encrypt("", 5));
    }

    @Test
    public void testEncryptionNonAlphaCharactersOnly() {
        assertEquals("1234!@#$", Task51_GEMINI_gemini_1_5_pro_001.encrypt("1234!@#$", 4));
    }
}
