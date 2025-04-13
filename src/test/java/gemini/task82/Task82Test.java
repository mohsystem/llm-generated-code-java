package gemini.task82;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import static org.junit.jupiter.api.Assertions.*;

public class Task82Test {

    private String computeExpectedHash(String password, String salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes(StandardCharsets.UTF_8));
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }

    @Test
    public void testStandardCase() throws Exception {
        String password = "mypassword123";
        String salt = "randomsalt";
        String expected = computeExpectedHash(password, salt);
        String actual = Task82_GEMINI_gemini_1_5_pro_001.hashPassword(password, salt);

        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyPassword() throws Exception {
        String salt = "randomsalt";
        String expected = computeExpectedHash("", salt);
        String actual = Task82_GEMINI_gemini_1_5_pro_001.hashPassword("", salt);

        assertEquals(expected, actual);
    }

    @Test
    public void testEmptySalt() throws Exception {
        String password = "mypassword123";
        String expected = computeExpectedHash(password, "");
        String actual = Task82_GEMINI_gemini_1_5_pro_001.hashPassword(password, "");

        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyPasswordAndSalt() throws Exception {
        String expected = computeExpectedHash("", "");
        String actual = Task82_GEMINI_gemini_1_5_pro_001.hashPassword("", "");

        assertEquals(expected, actual);
    }

    @Test
    public void testDifferentPassword() throws Exception {
        String salt = "randomsalt";
        String result1 = Task82_GEMINI_gemini_1_5_pro_001.hashPassword("mypassword123", salt);
        String result2 = Task82_GEMINI_gemini_1_5_pro_001.hashPassword("otherpassword", salt);

        assertNotEquals(result1, result2);
    }

    @Test
    public void testDifferentSalt() throws Exception {
        String password = "mypassword123";
        String result1 = Task82_GEMINI_gemini_1_5_pro_001.hashPassword(password, "salt1");
        String result2 = Task82_GEMINI_gemini_1_5_pro_001.hashPassword(password, "salt2");

        assertNotEquals(result1, result2);
    }

    @Test
    public void testSpecialCharacters() throws Exception {
        String password = "pa$$w@rd!";
        String salt = "s@lt#";
        String expected = computeExpectedHash(password, salt);
        String actual = Task82_GEMINI_gemini_1_5_pro_001.hashPassword(password, salt);

        assertEquals(expected, actual);
    }

    @Test
    public void testUnicodeCharacters() throws Exception {
        String password = "p@sswørd";
        String salt = "råndøm$alt";
        String expected = computeExpectedHash(password, salt);
        String actual = Task82_GEMINI_gemini_1_5_pro_001.hashPassword(password, salt);

        assertEquals(expected, actual);
    }

    @Test
    public void testLongPasswordAndSalt() throws Exception {
        String password = "a".repeat(1000);
        String salt = "b".repeat(1000);
        String expected = computeExpectedHash(password, salt);
        String actual = Task82_GEMINI_gemini_1_5_pro_001.hashPassword(password, salt);

        assertEquals(expected, actual);
    }
}
