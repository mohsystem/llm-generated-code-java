package claude.task132;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class Task132Test {

    private static final String LOG_FILE = "security_events.log";
    private static ByteArrayInputStream testIn;
    private static final PrintStream originalOut = System.out;
    private static ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        // Prepare to capture console output
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        if (testIn != null) {
            System.setIn(System.in);
        }
     }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String readLogFile() throws IOException {
         return Files.readString(Paths.get(LOG_FILE));
    }

    private void runMain() {
        Task132_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
    }

    @Test
    void testSingleEventLogging() throws IOException {
        String input = "Login Attempt\nUser admin attempted login\nq\n";
        provideInput(input);
        runMain();

        String output = outContent.toString();
        assertTrue(output.contains("Security Event Monitoring System"));
        assertTrue(output.contains("Event logged successfully."));
        assertTrue(output.contains("Monitoring ended. Check 'security_events.log' for recorded events."));

        String logContent = readLogFile();
        assertTrue(logContent.contains("Event Type: Login Attempt, Description: User admin attempted login"));
    }

    @Test
    void testMultipleEventsLogging() throws IOException {
        String input = "File Access\nUser accessed sensitive file\nSystem Alert\nUnauthorized access detected\nq\n";
        provideInput(input);
        runMain();

        String output = outContent.toString();
        assertTrue(output.contains("Security Event Monitoring System"));
        assertTrue(output.contains("Event logged successfully."));
        assertTrue(output.contains("Monitoring ended. Check 'security_events.log' for recorded events."));

        String logContent = readLogFile();
        assertTrue(logContent.contains("Event Type: File Access, Description: User accessed sensitive file"));
        assertTrue(logContent.contains("Event Type: System Alert, Description: Unauthorized access detected"));
    }

    @Test
    void testQuitImmediately() throws IOException {
        String input = "q\n";
        provideInput(input);
        runMain();

        String output = outContent.toString();
        assertTrue(output.contains("Security Event Monitoring System"));
        assertTrue(output.contains("Monitoring ended. Check 'security_events.log' for recorded events."));

        String logContent = readLogFile();

        assertFalse(logContent.contains("Event Type:"), "No events should be logged when quitting immediately.");
    }
}
