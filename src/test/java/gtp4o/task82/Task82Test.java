package gtp4o.task82;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import static org.junit.jupiter.api.Assertions.*;

public class Task82Test {

    private String computeExpected(String password, String salt) throws Exception {
        String combined = password + salt;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(combined.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @Test
    public void testStandardCase() throws Exception {
        String password = "mypassword123";
        String salt = "randomsalt";
        String expected = computeExpected(password, salt);
        String actual = Task82_OPENAI_gpt_4o.computeHash(password, salt);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyPassword() throws Exception {
        String salt = "randomsalt";
        String expected = computeExpected("", salt);
        String actual = Task82_OPENAI_gpt_4o.computeHash("", salt);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptySalt() throws Exception {
        String password = "mypassword123";
        String expected = computeExpected(password, "");
        String actual = Task82_OPENAI_gpt_4o.computeHash(password, "");
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyPasswordAndSalt() throws Exception {
        String expected = computeExpected("", "");
        String actual = Task82_OPENAI_gpt_4o.computeHash("", "");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferentPassword() throws Exception {
        String salt = "randomsalt";
        String result1 = Task82_OPENAI_gpt_4o.computeHash("mypassword123", salt);
        String result2 = Task82_OPENAI_gpt_4o.computeHash("otherpassword", salt);
        assertNotEquals(result1, result2);
    }

    @Test
    public void testDifferentSalt() throws Exception {
        String password = "mypassword123";
        String result1 = Task82_OPENAI_gpt_4o.computeHash(password, "salt1");
        String result2 = Task82_OPENAI_gpt_4o.computeHash(password, "salt2");
        assertNotEquals(result1, result2);
    }

    @Test
    public void testSpecialCharacters() throws Exception {
        String password = "pa$$w@rd!";
        String salt = "s@lt#";
        String expected = computeExpected(password, salt);
        String actual = Task82_OPENAI_gpt_4o.computeHash(password, salt);
        assertEquals(expected, actual);
    }

    @Test
    public void testUnicodeCharacters() throws Exception {
        String password = "p@sswørd";
        String salt = "råndøm$alt";
        String expected = computeExpected(password, salt);
        String actual = Task82_OPENAI_gpt_4o.computeHash(password, salt);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongPasswordAndSalt() throws Exception {
        String password = "a".repeat(1000);
        String salt = "b".repeat(1000);
        String expected = computeExpected(password, salt);
        String actual = Task82_OPENAI_gpt_4o.computeHash(password, salt);
        assertEquals(expected, actual);
    }
}
