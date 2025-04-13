package codestral.task79;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task79Test {

    @Test
    public void test_basic_encryption() {
        String result = Task79_MISTRAL_codestral_latest.encrypt("HELLO", 3);
        assertEquals("KHOOR", result);
    }

    @Test
    public void test_encryption_with_spaces() {
        String result = Task79_MISTRAL_codestral_latest.encrypt("HELLO WORLD", 5);
        assertEquals("MJQQT BTWQI", result);
    }

    @Test
    public void test_encryption_with_special_characters() {
        String result = Task79_MISTRAL_codestral_latest.encrypt("HELLO, WORLD!", 2);
        assertEquals("JGNNQ, YQTNF!", result);
    }

    @Test
    public void test_empty_message() {
        String result = Task79_MISTRAL_codestral_latest.encrypt("", 10);
        assertEquals("", result);
    }

    @Test
    public void test_encryption_with_numbers() {
        String result = Task79_MISTRAL_codestral_latest.encrypt("HELLO123", 4);
        assertEquals("LIPPS123", result);
    }

    @Test
    public void test_same_key_produces_same_output() {
        String result1 = Task79_MISTRAL_codestral_latest.encrypt("PYTHON", 6);
        String result2 = Task79_MISTRAL_codestral_latest.encrypt("PYTHON", 6);
        assertEquals(result1, result2);
    }

    @Test
    public void test_different_key_produces_different_output() {
        String result1 = Task79_MISTRAL_codestral_latest.encrypt("PYTHON", 6);
        String result2 = Task79_MISTRAL_codestral_latest.encrypt("PYTHON", 8);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_case_insensitive_encryption() {
        String result = Task79_MISTRAL_codestral_latest.encrypt("Python", 7);
        assertEquals("WFAOVU", result.toUpperCase());  // to match the Python behavior
    }

    @Test
    public void test_key_affects_shuffling() {
        String result1 = Task79_MISTRAL_codestral_latest.encrypt("TEST", 9);
        String result2 = Task79_MISTRAL_codestral_latest.encrypt("TEST", 10);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_same_key_and_message_different_cases() {
        String result1 = Task79_MISTRAL_codestral_latest.encrypt("test", 11);
        String result2 = Task79_MISTRAL_codestral_latest.encrypt("TEST", 11);
        assertEquals(result1.toUpperCase(), result2.toUpperCase());
    }
}
