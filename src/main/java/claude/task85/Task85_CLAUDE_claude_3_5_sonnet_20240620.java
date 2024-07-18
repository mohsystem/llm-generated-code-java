package claude.task85;

import java.security.SecureRandom;

public class Task85_CLAUDE_claude_3_5_sonnet_20240620 {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int length = 10;
        String randomString = generateRandomString(length);
        System.out.println("Random string: " + randomString);
    }
}
