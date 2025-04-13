package gemini.task55;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task55Test {

    @Test
    public void testValidEmail() {
        assertTrue(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("test.email@example.com"));
    }

    @Test
    public void testValidEmailWithDigits() {
        assertTrue(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("user123@example.com"));
    }

    @Test
    public void testValidEmailWithSpecialCharacters() {
        assertTrue(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("user+name@example.co.uk"));
    }

    @Test
    public void testInvalidEmailMissingAtSymbol() {
        assertFalse(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("invalidemail.com"));
    }

    @Test
    public void testInvalidEmailDoubleAtSymbol() {
        assertFalse(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("user@@example.com"));
    }

    @Test
    public void testInvalidEmailMissingDomain() {
        assertFalse(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("user@.com"));
    }

    @Test
    public void testInvalidEmailMultipleDotsInDomain() {
        assertFalse(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("user@example..com"));
    }

    @Test
    public void testInvalidEmailMissingUsername() {
        assertFalse(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("@example.com"));
    }

    @Test
    public void testInvalidEmailSpecialCharactersInDomain() {
        assertFalse(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("user@ex!ample.com"));
    }

    @Test
    public void testInvalidEmailShortTLD() {
        assertFalse(Task55_GEMINI_gemini_1_5_pro_001.isValidEmail("user@example.c"));
    }
}
