package gemini.task56;

import java.security.SecureRandom;
import java.util.Base64;

public class Task56_GEMINI_gemini_1_5_pro_001 {

    public static void main(String[] args) {
        String token = generateToken();
        System.out.println(token);
    }

    public static String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[32];
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }
}