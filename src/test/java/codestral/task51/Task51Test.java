package codestral.task51;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task51Test {

    @Test
    public void testBasicEncryption() {
        assertEquals("def", Task51_MISTRAL_codestral_latest.encryptString("abc", 3));
    }

    @Test
    public void testEncryptionWithUppercase() {
        assertEquals("DEF", Task51_MISTRAL_codestral_latest.encryptString("ABC", 3));
    }

    @Test
    public void testEncryptionWithMixedCase() {
        assertEquals("cDe", Task51_MISTRAL_codestral_latest.encryptString("aBc", 2));
    }

    @Test
    public void testEncryptionWithNonAlphaCharacters() {
        assertEquals("f g-h", Task51_MISTRAL_codestral_latest.encryptString("a b-c", 5));
    }

    @Test
    public void testEncryptionWithLargeShiftValue() {
        assertEquals("bcd", Task51_MISTRAL_codestral_latest.encryptString("xyz", 30));
    }

    @Test
    public void testEncryptionWithNegativeShiftValue() {
        assertEquals("abc", Task51_MISTRAL_codestral_latest.encryptString("def", -3));
    }

    @Test
    public void testEncryptionWithShiftValueZero() {
        assertEquals("hello", Task51_MISTRAL_codestral_latest.encryptString("hello", 0));
    }

    @Test
    public void testEncryptionWithShiftValue26() {
        assertEquals("xyz", Task51_MISTRAL_codestral_latest.encryptString("xyz", 26));
    }

    @Test
    public void testEncryptionEmptyString() {
        assertEquals("", Task51_MISTRAL_codestral_latest.encryptString("", 5));
    }

    @Test
    public void testEncryptionNonAlphaCharactersOnly() {
        assertEquals("1234!@#$", Task51_MISTRAL_codestral_latest.encryptString("1234!@#$", 4));
    }
}
