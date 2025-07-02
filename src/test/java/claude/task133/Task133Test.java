package claude.task133;

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
        Task133_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
    }

    @Test
    void testPasswordResetOutput() {
        String username = "testuser";
        provideInput(username + "\n");

        runMain();

        String output = outContent.toString().trim();
        String[] lines = output.split("\\r?\\n");

        assertTrue(lines.length >= 2, "Output should contain at least two lines.");
        assertTrue(lines[0].contains("Password for " + username + " has been reset."),
                "First line should confirm password reset for the username.");

        String newPasswordLine = lines[1];
        assertTrue(newPasswordLine.startsWith("New password:"),
                "Second line should start with 'New password:'.");

        String newPassword = newPasswordLine.substring("New password:".length()).trim();
        assertFalse(newPassword.isEmpty(),
                "Generated password should not be empty.");
    }
}
