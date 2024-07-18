package claude.task56;

import java.security.SecureRandom;
import java.util.Base64;

public class Task56_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[24];
        random.nextBytes(bytes);
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        System.out.println("Generated token: " + token);
    }
}
