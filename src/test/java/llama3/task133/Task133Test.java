package llama3.task133;

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
        Task133_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
    }

    @Test
    void testPasswordResetSuccess() {
        String input = String.join("\n",
                "testuser",    // username
                "oldpassword", // old password
                "newpassword", // new password
                "newpassword"  // confirm password
        ) + "\n";

        provideInput(input);
        runMain();

        String output = outContent.toString().trim();
        assertTrue(output.contains("Password reset successfully!"),
                "Should print success message when new password and confirmation match.");
    }

    @Test
    void testPasswordMismatch() {
        String input = String.join("\n",
                "testuser",     // username
                "oldpassword",  // old password
                "newpassword",  // new password
                "differentpassword" // confirm password (does not match)
        ) + "\n";

        provideInput(input);
        runMain();

        String output = outContent.toString().trim();
        assertTrue(output.contains("New password and confirm password do not match. Try again!"),
                "Should print mismatch message when new password and confirmation do not match.");
    }
}
