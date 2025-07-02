package llama3.task128;

import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class Task128Test {

    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    @RepeatedTest(100)
    public void testGeneratedTokenLengthAndCharacters() {
        String token = generateToken(10);

         assertEquals(10, token.length(), "Token length should be 10");

         for (char c : token.toCharArray()) {
            assertTrue(VALID_CHARACTERS.indexOf(c) >= 0, "Invalid character found: " + c);
        }
    }

    @RepeatedTest(50)
    public void testGeneratedTokensNotIdentical() {
        String token1 = generateToken(10);
        String token2 = generateToken(10);
        assertNotEquals(token1, token2, "Tokens should be different");
    }

     private String generateToken(int length) {
        String lettersAndDigits = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder token = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            token.append(lettersAndDigits.charAt(random.nextInt(lettersAndDigits.length())));
        }
        return token.toString();
    }
}
