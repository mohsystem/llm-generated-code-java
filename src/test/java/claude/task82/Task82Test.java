package claude.task82;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import static org.junit.jupiter.api.Assertions.*;

public class Task82Test {

    private String password;
    private String salt;
    private String expectedHash;

    private String computeExpectedHash(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }

    @BeforeEach
    public void setUp() throws Exception {
        password = "mypassword123";
        salt = "randomsalt";
        expectedHash = computeExpectedHash(password + salt);
    }

    @Test
    public void testStandardCase() {
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword(password, salt);
        assertEquals(expectedHash, result);
    }

    @Test
    public void testEmptyPassword() throws Exception {
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword("", salt);
        String expected = computeExpectedHash(salt);
        assertEquals(expected, result);
    }

    @Test
    public void testEmptySalt() throws Exception {
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword(password, "");
        String expected = computeExpectedHash(password);
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyPasswordAndSalt() throws Exception {
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword("", "");
        String expected = computeExpectedHash("");
        assertEquals(expected, result);
    }

    @Test
    public void testDifferentPassword() {
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword("differentpassword", salt);
        assertNotEquals(expectedHash, result);
    }

    @Test
    public void testDifferentSalt() {
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword(password, "differentsalt");
        assertNotEquals(expectedHash, result);
    }

    @Test
    public void testDifferentPasswordAndSalt() {
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword("differentpassword", "differentsalt");
        assertNotEquals(expectedHash, result);
    }

    @Test
    public void testSpecialCharacters() throws Exception {
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword("passw@rd!$", "s@lt#");
        String expected = computeExpectedHash("passw@rd!$s@lt#");
        assertEquals(expected, result);
    }

    @Test
    public void testUnicodeCharacters() throws Exception {
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword("p@sswørd", "råndøm$alt");
        String expected = computeExpectedHash("p@sswørdråndøm$alt");
        assertEquals(expected, result);
    }

    @Test
    public void testLongString() throws Exception {
        String longPassword = "a".repeat(1000);
        String longSalt = "b".repeat(1000);
        String result = Task82_CLAUDE_claude_3_5_sonnet_20240620.hashPassword(longPassword, longSalt);
        String expected = computeExpectedHash(longPassword + longSalt);
        assertEquals(expected, result);
    }
}
