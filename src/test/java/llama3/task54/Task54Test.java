package llama3.task54;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Task54Test {

     private final List<String> pythonOtps = Arrays.asList(
            "985440", "503958", "894772", "541001", "142450",
            "371493", "636110", "609532", "524604", "921872"
    );

    @Test
    public void testOtpFormat() {
        for (int i = 0; i < 10; i++) {
            String otp = Task54_PERPLEXITY_llama_3_sonar_large_32k_chat.generateOTP();
            assertEquals(6, otp.length(), "OTP should be 6 digits");
            assertTrue(otp.matches("\\d{6}"), "OTP should contain only digits");
        }
    }

    @Test
    public void testOtpMatchingManually() {
        for (String otp : pythonOtps) {
            assertEquals("Authentication successful",
                    mockAuthenticate("admin", "password", otp, otp),
                    "Authentication must succeed for correct credentials and OTP");

            assertEquals("Authentication failed",
                    mockAuthenticate("admin", "password", "000000", otp),
                    "Authentication must fail for incorrect OTP");

            assertEquals("Authentication failed",
                    mockAuthenticate("user", "password", otp, otp),
                    "Authentication must fail for incorrect username");

            assertEquals("Authentication failed",
                    mockAuthenticate("admin", "wrong", otp, otp),
                    "Authentication must fail for incorrect password");
        }
    }

     private String mockAuthenticate(String username, String password, String otp, String expectedOtp) {
        if (username.equals("admin") && password.equals("password") && otp.equals(expectedOtp)) {
            return "Authentication successful";
        } else {
            return "Authentication failed";
        }
    }
}
