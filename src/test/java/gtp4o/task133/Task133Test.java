package gtp4o.task133;

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
        Task133_OPENAI_gpt_4o.main(new String[]{});
    }

    @Test
    void testPasswordResetOutput() {
        String username = "testuser";
        String password = "newpassword123";
        provideInput(username + "\n" + password + "\n");

        runMain();

        String output = outContent.toString().trim();
        String expectedOutput = "Password for " + username + " has been reset to " + password;
        assertTrue(output.contains(expectedOutput),
                "Output should contain the correct reset message with username and password.");
    }
}
