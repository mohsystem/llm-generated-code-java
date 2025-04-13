package gtp4o.task55;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task55Test {

    @Test
    public void testValidEmail() {
        assertTrue(Task55_OPENAI_gpt_4o.validateEmail("test.email@example.com"));
    }

    @Test
    public void testValidEmailWithDigits() {
        assertTrue(Task55_OPENAI_gpt_4o.validateEmail("user123@example.com"));
    }

    @Test
    public void testValidEmailWithSpecialCharacters() {
        assertTrue(Task55_OPENAI_gpt_4o.validateEmail("user+name@example.co.uk"));
    }

    @Test
    public void testInvalidEmailMissingAtSymbol() {
        assertFalse(Task55_OPENAI_gpt_4o.validateEmail("invalidemail.com"));
    }

    @Test
    public void testInvalidEmailDoubleAtSymbol() {
        assertFalse(Task55_OPENAI_gpt_4o.validateEmail("user@@example.com"));
    }

    @Test
    public void testInvalidEmailMissingDomain() {
        assertFalse(Task55_OPENAI_gpt_4o.validateEmail("user@.com"));
    }

    @Test
    public void testInvalidEmailMultipleDotsInDomain() {
        assertFalse(Task55_OPENAI_gpt_4o.validateEmail("user@example..com"));
    }

    @Test
    public void testInvalidEmailMissingUsername() {
        assertFalse(Task55_OPENAI_gpt_4o.validateEmail("@example.com"));
    }

    @Test
    public void testInvalidEmailSpecialCharactersInDomain() {
        assertFalse(Task55_OPENAI_gpt_4o.validateEmail("user@ex!ample.com"));
    }

    @Test
    public void testInvalidEmailShortTLD() {
        assertFalse(Task55_OPENAI_gpt_4o.validateEmail("user@example.c"));
    }
}
