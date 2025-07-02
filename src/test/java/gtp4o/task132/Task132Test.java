package gtp4o.task132;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Task132Test {

    private SecurityEventLogger logger;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        logger = new SecurityEventLogger();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testLogAndShowEvents() throws InterruptedException {
         logger.logEvent("User login");
        logger.logEvent("File accessed");

         Thread.sleep(1000);

         logger.logEvent("User logout");

         logger.showEvents();

         String output = outContent.toString().trim();
        String[] lines = output.split("\\r?\\n");

         assertEquals(3, lines.length, "There should be exactly 3 logged events");

         assertTrue(lines[0].contains("User login"), "First event should be 'User login'");
        assertTrue(lines[1].contains("File accessed"), "Second event should be 'File accessed'");
        assertTrue(lines[2].contains("User logout"), "Third event should be 'User logout'");

         for (String line : lines) {
            assertTrue(line.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2} - .+"),
                    "Each line should start with a timestamp and a message");
        }
    }
}
