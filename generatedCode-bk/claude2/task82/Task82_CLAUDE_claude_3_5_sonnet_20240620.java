package claude2.task82;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Task82_CLAUDE_claude_3_5_sonnet_20240620 {
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwordWithSalt = password + salt;
            byte[] hashedPassword = md.digest(passwordWithSalt.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String password = "myPassword123";
        String salt = "randomSalt";
        String hashedPassword = hashPassword(password, salt);
        System.out.println("Hashed password: " + hashedPassword);
    }
}
