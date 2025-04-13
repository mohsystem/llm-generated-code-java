package claude.task55;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task55Test {

    @Test
    public void testValidEmail() {
        assertTrue(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("test.email@example.com"));
    }

    @Test
    public void testValidEmailWithDigits() {
        assertTrue(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("user123@example.com"));
    }

    @Test
    public void testValidEmailWithSpecialCharacters() {
        assertTrue(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("user+name@example.co.uk"));
    }

    @Test
    public void testInvalidEmailMissingAtSymbol() {
        assertFalse(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("invalidemail.com"));
    }

    @Test
    public void testInvalidEmailDoubleAtSymbol() {
        assertFalse(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("user@@example.com"));
    }

    @Test
    public void testInvalidEmailMissingDomain() {
        assertFalse(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("user@.com"));
    }

    @Test
    public void testInvalidEmailMultipleDotsInDomain() {
        assertFalse(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("user@example..com"));
    }

    @Test
    public void testInvalidEmailMissingUsername() {
        assertFalse(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("@example.com"));
    }

    @Test
    public void testInvalidEmailSpecialCharactersInDomain() {
        assertFalse(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("user@ex!ample.com"));
    }

    @Test
    public void testInvalidEmailShortTLD() {
        assertFalse(Task55_CLAUDE_claude_3_5_sonnet_20240620.validateEmail("user@example.c"));
    }
}
