package gemini.task132;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

class Task132Test {

    private static final String LOG_FILE = "security_events.log";
    private static Path tempFile;
    private static Thread monitorThread;

    @BeforeAll
    static void setUp() throws Exception {
         Files.deleteIfExists(Paths.get(LOG_FILE));

         tempFile = Files.createTempFile("important_file", ".txt");

         monitorThread = new Thread(() -> {
            try {
                Task132_GEMINI_gemini_1_5_pro_001.watchFileChanges(tempFile.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        monitorThread.start();

         Thread.sleep(1000);
    }

    @AfterAll
    static void tearDown() throws IOException {
         monitorThread.interrupt();

         Files.deleteIfExists(tempFile);

         Files.deleteIfExists(Paths.get(LOG_FILE));
    }

    @Test
    void testFileModificationIsLogged() throws Exception {
         Files.write(tempFile, "Modified content".getBytes(), StandardOpenOption.APPEND);

         Thread.sleep(2000);

         assertTrue(Files.exists(Paths.get(LOG_FILE)), "Log file should exist after file modification");

         List<String> logLines = Files.readAllLines(Paths.get(LOG_FILE));

         boolean found = logLines.stream().anyMatch(line -> line.contains("File Change Detected"));
        assertTrue(found, "Log file should contain 'File Change Detected' message");
    }
}
