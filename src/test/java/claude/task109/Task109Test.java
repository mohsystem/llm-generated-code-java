package claude.task109;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Task109Test {

    // Email validation logic
    public String validateEmail(String email) {
        String emailPattern = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        return email.matches(emailPattern) ? "Valid email" : "Invalid email";
    }

    // Phone validation logic
    public String validatePhone(String phone) {
        String phonePattern = "^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$";
        return phone.matches(phonePattern) ? "Valid phone number" : "Invalid phone number";
    }

    // Password validation logic
    public String validatePassword(String password) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        return password.matches(passwordPattern) ? "Valid password" : "Invalid password";
    }

    // Email tests
    @Test
    public void testValidEmail() {
        assertEquals("Valid email", validateEmail("test@example.com"));
    }

    @Test
    public void testInvalidEmail() {
        assertEquals("Invalid email", validateEmail("invalid-email"));
    }

    @Test
    public void testValidEmailWithSubdomain() {
        assertEquals("Valid email", validateEmail("user@domain.co.uk"));
    }

    @Test
    public void testInvalidEmailMissingUsername() {
        assertEquals("Invalid email", validateEmail("user@.com"));
    }

    @Test
    public void testInvalidEmailMissingAtSymbol() {
        assertEquals("Invalid email", validateEmail("userdomain.com"));
    }

    // Phone tests
    @Test
    public void testValidPhone() {
        assertEquals("Valid phone number", validatePhone("(123) 456-7890"));
    }

    @Test
    public void testInvalidPhoneWithLetters() {
        assertEquals("Invalid phone number", validatePhone("123-abc-7890"));
    }

    @Test
    public void testValidPhoneWithDashes() {
        assertEquals("Valid phone number", validatePhone("123-456-7890"));
    }

    @Test
    public void testInvalidPhoneWithExtraDigits() {
        assertEquals("Invalid phone number", validatePhone("123-456-78901"));
    }

    // Password tests
    @Test
    public void testValidPassword() {
        assertEquals("Valid password", validatePassword("Password1"));
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        assertEquals("Invalid password", validatePassword("password1"));
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        assertEquals("Invalid password", validatePassword("Password"));
    }

    @Test
    public void testInvalidPasswordTooShort() {
        assertEquals("Invalid password", validatePassword("Pass1"));
    }
}
