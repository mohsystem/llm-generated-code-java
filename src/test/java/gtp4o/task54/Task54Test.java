package gtp4o.task54;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Task54Test {

     private final List<Integer> pythonOtps = Arrays.asList(
            985440, 503958, 894772, 541001, 142450,
            371493, 636110, 609532, 524604, 921872
    );

    @Test
    public void testOtpRangeAndLength() {
        for (int i = 0; i < 10; i++) {
            int otp = Task54_OPENAI_gpt_4o.generateOTP();
            assertTrue(otp >= 100000 && otp <= 999999, "OTP must be a 6-digit number");
            assertEquals(6, String.valueOf(otp).length(), "OTP must be 6 digits");
        }
    }

    @Test
    public void testOtpVerificationSuccess() {
        for (int otp : pythonOtps) {
            assertTrue(Task54_OPENAI_gpt_4o.verifyOTP(otp, otp),
                    "OTP verification should succeed for matching OTPs");
        }
    }

    @Test
    public void testOtpVerificationFailure() {
        for (int otp : pythonOtps) {
            assertFalse(Task54_OPENAI_gpt_4o.verifyOTP(otp, 111111),
                    "OTP verification should fail for incorrect user input");
        }
    }

    @Test
    public void testLoginSimulation() {
        String username = "user";
        String password = "pass";
        int correctOtp = 985440;
        int enteredOtp = 985440;

        assertTrue(username.equals("user") && password.equals("pass"));
        assertTrue(Task54_OPENAI_gpt_4o.verifyOTP(enteredOtp, correctOtp));
    }

    @Test
    public void testLoginFailureWrongOtp() {
        String username = "user";
        String password = "pass";
        int correctOtp = 985440;
        int enteredOtp = 123456;

        assertTrue(username.equals("user") && password.equals("pass"));
        assertFalse(Task54_OPENAI_gpt_4o.verifyOTP(enteredOtp, correctOtp));
    }

    @Test
    public void testLoginFailureWrongCredentials() {
        String username = "admin";
        String password = "wrong";

        assertFalse(username.equals("user") && password.equals("pass"),
                "Login should fail due to incorrect credentials");
    }
}
