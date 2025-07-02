package claude.task116;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class Task116Test {

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

    @Test
    void testRunAsNonRoot() {
        String originalUser = System.getProperty("user.name");
        System.setProperty("user.name", "nonroot");

        Exception exception = assertThrows(SecurityException.class, () -> {
            Task116_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
        });

        String output = outContent.toString();
        assertTrue(output.contains("This program must be run as root."));

        System.setProperty("user.name", originalUser);
    }

    @Test
    void testRunAsRootWithPasswordChange() throws IOException {
        String originalUser = System.getProperty("user.name");
        System.setProperty("user.name", "root");

        // Mock user input
        String input = "testuser\nnewpassword\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Since the real console won't be available during JUnit test,
        // we assume 'No console available' error will happen.
        Task116_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("No console available"));

        System.setProperty("user.name", originalUser);
    }
}
