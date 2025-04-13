package llama3.task55;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task55Test {

    @Test
    public void testValidEmail() {
        assertTrue(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("test.email@example.com"));
    }

    @Test
    public void testValidEmailWithDigits() {
        assertTrue(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("user123@example.com"));
    }

    @Test
    public void testValidEmailWithSpecialCharacters() {
        assertTrue(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("user+name@example.co.uk"));
    }

    @Test
    public void testInvalidEmailMissingAtSymbol() {
        assertFalse(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("invalidemail.com"));
    }

    @Test
    public void testInvalidEmailDoubleAtSymbol() {
        assertFalse(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("user@@example.com"));
    }

    @Test
    public void testInvalidEmailMissingDomain() {
        assertFalse(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("user@.com"));
    }

    @Test
    public void testInvalidEmailMultipleDotsInDomain() {
        assertFalse(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("user@example..com"));
    }

    @Test
    public void testInvalidEmailMissingUsername() {
        assertFalse(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("@example.com"));
    }

    @Test
    public void testInvalidEmailSpecialCharactersInDomain() {
        assertFalse(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("user@ex!ample.com"));
    }

    @Test
    public void testInvalidEmailShortTLD() {
        assertFalse(Task55_PERPLEXITY_llama_3_sonar_large_32k_chat.validateEmail("user@example.c"));
    }
}
