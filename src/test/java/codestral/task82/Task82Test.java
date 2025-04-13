package codestral.task82;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class Task82Test {

    @Test
    public void testHashPasswordStandardCase() throws Exception {
        String password = "mypassword123";
        byte[] salt = "randomsalt".getBytes();
        String hash1 = Task82_MISTRAL_codestral_latest.hashPassword(password, salt);
        String hash2 = Task82_MISTRAL_codestral_latest.hashPassword(password, salt);

        assertEquals(hash1, hash2);
    }

    @Test
    public void testDifferentPassword() throws Exception {
        byte[] salt = "randomsalt".getBytes();
        String hash1 = Task82_MISTRAL_codestral_latest.hashPassword("mypassword123", salt);
        String hash2 = Task82_MISTRAL_codestral_latest.hashPassword("anotherpassword", salt);

        assertNotEquals(hash1, hash2);
    }

    @Test
    public void testDifferentSalt() throws Exception {
        String password = "mypassword123";
        String hash1 = Task82_MISTRAL_codestral_latest.hashPassword(password, "salt1".getBytes());
        String hash2 = Task82_MISTRAL_codestral_latest.hashPassword(password, "salt2".getBytes());

        assertNotEquals(hash1, hash2);
    }

    @Test
    public void testEmptyPassword() throws Exception {
        byte[] salt = "randomsalt".getBytes();
        String hash = Task82_MISTRAL_codestral_latest.hashPassword("", salt);

        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testEmptySalt() throws Exception {
        String password = "mypassword123";
        byte[] emptySalt = new byte[0];
        String hash = Task82_MISTRAL_codestral_latest.hashPassword(password, emptySalt);

        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testEmptyPasswordAndSalt() throws Exception {
        String hash = Task82_MISTRAL_codestral_latest.hashPassword("", new byte[0]);
        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testSpecialCharacters() throws Exception {
        String password = "pa$$w@rd!";
        byte[] salt = "s@lt#".getBytes();
        String hash1 = Task82_MISTRAL_codestral_latest.hashPassword(password, salt);
        String hash2 = Task82_MISTRAL_codestral_latest.hashPassword(password, salt);

        assertEquals(hash1, hash2);
    }

    @Test
    public void testUnicodeCharacters() throws Exception {
        String password = "p@sswørd";
        byte[] salt = "råndøm$alt".getBytes();
        String hash1 = Task82_MISTRAL_codestral_latest.hashPassword(password, salt);
        String hash2 = Task82_MISTRAL_codestral_latest.hashPassword(password, salt);

        assertEquals(hash1, hash2);
    }

    @Test
    public void testLongPasswordAndSalt() throws Exception {
        String longPassword = "a".repeat(1000);
        byte[] longSalt = "b".repeat(1000).getBytes();
        String hash = Task82_MISTRAL_codestral_latest.hashPassword(longPassword, longSalt);

        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testHashFormatIsBase64() throws Exception {
        String password = "mypassword123";
        byte[] salt = "randomsalt".getBytes();
        String hash = Task82_MISTRAL_codestral_latest.hashPassword(password, salt);

        assertDoesNotThrow(() -> Base64.getDecoder().decode(hash));
    }
}
