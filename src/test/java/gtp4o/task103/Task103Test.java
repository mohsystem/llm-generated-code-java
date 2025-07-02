import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task103Test {

    private boolean isStrong(String password) {
        return password.length() >= 8 &&
                password.chars().anyMatch(Character::isLowerCase) &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(Character::isDigit);
    }

    @Test
    void testShortPassword() {
        assertFalse(isStrong("Ab1"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(isStrong("abcdefgh1"));
    }

    @Test
    void testNoLowercase() {
        assertFalse(isStrong("ABCDEF1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(isStrong("Abcdefgh"));
    }

    @Test
    void testValidPassword() {
        assertTrue(isStrong("Abcdefg1"));
    }

    @Test
    void testPasswordExactly8Chars() {
        assertTrue(isStrong("A1bcdefg"));
    }

    @Test
    void testPasswordWithSpecialCharacters() {
        assertTrue(isStrong("A1@bcdEf"));
    }

    @Test
    void testAllUppercase() {
        assertFalse(isStrong("ABCDEFGHI"));
    }

    @Test
    void testAllLowercase() {
        assertFalse(isStrong("abcdefgh"));
    }

    @Test
    void testPasswordWithSpaces() {
        assertTrue(isStrong("A1 bcdEf"));
    }
}
