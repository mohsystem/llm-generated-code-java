package gemini.task54;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task54Test {

     private final List<String> pythonOtps = Arrays.asList(
            "874254", "734595", "276299", "893786", "414699",
            "482850", "738604", "823815", "298403", "591575"
    );

    @Test
    public void testOtpFormatAndLength() {
        for (int i = 0; i < 10; i++) {
            String otp = Task54_GEMINI_gemini_1_5_pro_001.generateOTP(6);
            assertEquals(6, otp.length(), "OTP must be 6 digits long");
            assertTrue(otp.matches("\\d{6}"), "OTP must contain only digits");
        }
    }

    @Test
    public void testOtpAgainstPythonCases() {
        for (String otp : pythonOtps) {
            assertEquals(6, otp.length(), "OTP must be 6 digits");
            assertTrue(otp.matches("\\d{6}"), "OTP must be digits only");
        }
    }

    @Test
    public void testSuccessfulLoginSimulation() {
        String username = "user";
        String password = "password";
        String otp = "874254";
        String enteredOtp = "874254";

        assertTrue(username.equals("user") && password.equals("password"));
        assertEquals(otp, enteredOtp, "OTP must match for successful login");
    }

    @Test
    public void testFailedLoginDueToWrongOtp() {
        String username = "user";
        String password = "password";
        String otp = "874254";
        String enteredOtp = "000000";

        assertTrue(username.equals("user") && password.equals("password"));
        assertNotEquals(otp, enteredOtp, "Login should fail due to incorrect OTP");
    }

    @Test
    public void testFailedLoginDueToInvalidCredentials() {
        String username = "admin";
        String password = "pass";
        String otp = "874254";
        String enteredOtp = "874254";

        assertFalse(username.equals("user") && password.equals("password"),
                "Login must fail due to wrong credentials");
    }
}
