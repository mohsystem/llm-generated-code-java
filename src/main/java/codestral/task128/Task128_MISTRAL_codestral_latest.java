package codestral.task128;

import java.util.Random;

public class Task128_MISTRAL_codestral_latest {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int TOKEN_LENGTH = 10;

    public static void main(String[] args) {
        System.out.println(generateRandomToken());
    }

    private static String generateRandomToken() {
        Random random = new Random();
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            token.append(CHARACTERS.charAt(randomIndex));
        }

        return token.toString();
    }
}