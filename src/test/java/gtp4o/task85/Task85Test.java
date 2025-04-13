package gtp4o.task85;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task85Test {

    @Test
    public void testGeneratedStringLength() {
        String result = Task85_OPENAI_gpt_4o.generateRandomString(10);
        assertEquals(10, result.length(), "Generated string should be 10 characters long");
    }

    @Test
    public void testGeneratedStringOnlyAsciiLetters() {
        String result = Task85_OPENAI_gpt_4o.generateRandomString(25);
        assertTrue(result.matches("^[a-zA-Z]+$"), "Generated string should contain only ASCII letters");
    }

    @Test
    public void testGeneratedStringIsRandom() {
        String s1 = Task85_OPENAI_gpt_4o.generateRandomString(14);
        String s2 = Task85_OPENAI_gpt_4o.generateRandomString(14);
        assertNotEquals(s1, s2, "Each generated string should be different");
    }
}
