package llama3.task132;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

class Task132Test {

    private static final String LOG_FILE = "security_log.txt";
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() throws IOException {
         Files.deleteIfExists(Paths.get(LOG_FILE));
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testMonitorAndLogEvents() throws Exception {
         String simulatedInput = "User login\nFile access\nquit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
         Task132_PERPLEXITY_llama_3_sonar_large_32k_chat.monitorEvents();

         Thread.sleep(500);

         assertTrue(Files.exists(Paths.get(LOG_FILE)), "Log file should exist after events are logged");

          List<String> lines = Files.readAllLines(Paths.get(LOG_FILE));

         assertEquals(2, lines.size(), "There should be exactly 2 logged events");

         assertTrue(lines.get(0).contains("User login"), "First log should contain 'User login'");
        assertTrue(lines.get(1).contains("File access"), "Second log should contain 'File access'");


        for (String line : lines) {
            assertTrue(line.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d+.* - .+"),
                    "Each log line should start with a timestamp in ISO format and an event description");
        }
    }
}
