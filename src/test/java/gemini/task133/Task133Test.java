package gemini.task133;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

class Task133Test {

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private void runMain() {
        Task133_GEMINI_gemini_1_5_pro_001.main(new String[]{});
    }

    @Test
    void testValidPassword() {
        // Provide valid password and confirmation
        provideInput("Valid123\nValid123\n");

        runMain();

        String output = outContent.toString();
        assertTrue(output.contains("Password reset successfully!"),
                "Should successfully reset password with valid matching inputs.");
    }

    @Test
    void testInvalidPasswordShortLength() {
        // Short password, will fail then valid password
        provideInput("Ab1\nAb1\nValid123\nValid123\n");

        runMain();

        String output = outContent.toString();
        assertTrue(output.contains("Invalid password or passwords don't match. Please try again."),
                "Should detect password too short and prompt retry.");
        assertTrue(output.contains("Password reset successfully!"),
                "Should eventually accept a valid password.");
    }

    @Test
    void testMismatchPasswords() {
        // Mismatch passwords first, then valid
        provideInput("Valid123\nDifferent123\nValid123\nValid123\n");

        runMain();

        String output = outContent.toString();
        assertTrue(output.contains("Invalid password or passwords don't match. Please try again."),
                "Should detect password mismatch and prompt retry.");
        assertTrue(output.contains("Password reset successfully!"),
                "Should eventually accept valid matching password.");
    }

    @Test
    void testInvalidPasswordMissingUppercase() {
        // No uppercase in password
        provideInput("valid1234\nvalid1234\nValid123\nValid123\n");

        runMain();

        String output = outContent.toString();
        assertTrue(output.contains("Invalid password or passwords don't match. Please try again."),
                "Should detect missing uppercase and prompt retry.");
        assertTrue(output.contains("Password reset successfully!"),
                "Should eventually accept valid password.");
    }

    @Test
    void testInvalidPasswordMissingDigit() {
        // No digit in password
        provideInput("ValidPassword\nValidPassword\nValid123\nValid123\n");

        runMain();

        String output = outContent.toString();
        assertTrue(output.contains("Invalid password or passwords don't match. Please try again."),
                "Should detect missing digit and prompt retry.");
        assertTrue(output.contains("Password reset successfully!"),
                "Should eventually accept valid password.");
    }
}
