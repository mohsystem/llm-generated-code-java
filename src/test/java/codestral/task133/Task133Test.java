package codestral.task133;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Task133Test {

    @Test
    void testCorrectCurrentPasswordAndMatchingNewPasswords() {
        String result = Task133_MISTRAL_codestral_latest.resetPassword("oldpassword", "newpassword", "newpassword");
        assertEquals("Password reset successful.", result, "Should reset password successfully when current password is correct and new passwords match.");
    }

    @Test
    void testIncorrectCurrentPassword() {
        String result = Task133_MISTRAL_codestral_latest.resetPassword("wrongpassword", "newpassword", "newpassword");
        assertEquals("Current password is incorrect.", result, "Should detect incorrect current password.");
    }

    @Test
    void testNewPasswordAndConfirmPasswordMismatch() {
        String result = Task133_MISTRAL_codestral_latest.resetPassword("oldpassword", "newpassword1", "newpassword2");
        assertEquals("New password and confirm password do not match.", result, "Should detect mismatch between new password and confirmation.");
    }

    @Test
    void testIncorrectCurrentPasswordAndMismatchNewPasswords() {
        String result = Task133_MISTRAL_codestral_latest.resetPassword("wrongpassword", "newpassword1", "newpassword2");
        assertEquals("Current password is incorrect.", result, "Should prioritize checking current password before matching new passwords.");
    }
}
