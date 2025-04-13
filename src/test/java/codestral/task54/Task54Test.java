package codestral.task54;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Task54Test {

     private final List<String> pythonOtps = Arrays.asList(
            "874254", "734595", "276299", "893786", "414699",
            "482850", "738604", "823815", "298403", "591575"
    );

    @Test
    public void testOtpLengthAndDigits() {
        for (int i = 0; i < 10; i++) {
            String otp = Task54_MISTRAL_codestral_latest.generateOTP();
            assertEquals(6, otp.length(), "OTP must be 6 digits");
            assertTrue(otp.matches("\\d{6}"), "OTP must contain only digits");
        }
    }

    @Test
    public void testLoginWithValidCredentialsAndMatchingOtpFails() {
          String otp = Task54_MISTRAL_codestral_latest.generateOTP();
        String result = Task54_MISTRAL_codestral_latest.login("user", "password", otp);
        assertEquals("Invalid OTP", result, "Should fail because OTPs will never match due to random generation");
    }

    @Test
    public void testLoginInvalidUsernameOrPassword() {
        for (String otp : pythonOtps) {
            assertEquals("Invalid username or password",
                    Task54_MISTRAL_codestral_latest.login("wrong", "password", otp));
            assertEquals("Invalid username or password",
                    Task54_MISTRAL_codestral_latest.login("user", "wrong", otp));
        }
    }
}
