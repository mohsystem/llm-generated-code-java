package claude.task54;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Task54Test {

    // ثوابت من بايثون باستخدام random.seed(0)
    private final List<String> pythonGeneratedOtps = Arrays.asList(
            "874254", "734595", "276299", "893786", "414699",
            "482850", "738604", "823815", "298403", "591575"
    );

    @Test
    public void testVerifyOtp() {
        for (String otp : pythonGeneratedOtps) {
            assertTrue(Task54_CLAUDE_claude_3_5_sonnet_20240620.verifyOTP(otp, otp),
                    "OTP verification failed for correct OTP: " + otp);
            assertFalse(Task54_CLAUDE_claude_3_5_sonnet_20240620.verifyOTP("000000", otp),
                    "OTP verification incorrectly passed for incorrect OTP vs: " + otp);
        }
    }

    @Test
    public void testOtpLength() {
        for (int i = 0; i < 10; i++) {
            String otp = Task54_CLAUDE_claude_3_5_sonnet_20240620.generateOTP();
            assertEquals(6, otp.length(), "Generated OTP should be 6 digits long");
            assertTrue(otp.matches("\\d{6}"), "OTP should contain only digits");
        }
    }
}
