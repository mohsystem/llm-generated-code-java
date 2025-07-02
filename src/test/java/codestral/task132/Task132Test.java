package codestral.task132;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class Task132MistralTest {

    private static final String LOG_FILE = "security.log";
    private static final PrintStream originalOut = System.out;
    private static ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    private String readLogFile() throws IOException {
        return Files.readString(Paths.get(LOG_FILE));
    }

    @Test
    void testSecurityEventLogging() throws IOException, InterruptedException {
        // Run the main method in a separate thread to simulate the logger running
        Thread appThread = new Thread(() -> {
            Task132_MISTRAL_codestral_latest.main(new String[]{});
        });
        appThread.start();

        // Wait a bit to allow some log entries to be created
        Thread.sleep(3500); // 3.5 seconds => should have ~3 events

        // Kill the thread after sleep
        appThread.stop(); // ⚠️ Warning: stop() is unsafe for production, fine for this controlled test only!

        // Read the log file
        String logContent = readLogFile();

        // Assertions
        assertTrue(logContent.contains("Security event detected"), "Log should contain security event messages.");

        // Count number of security events logged
        long count = logContent.lines()
                .filter(line -> line.contains("Security event detected"))
                .count();

        assertTrue(count >= 3, "At least 3 security events should be logged.");
    }
}
