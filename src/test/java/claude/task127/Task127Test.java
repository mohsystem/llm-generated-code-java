package claude.task127;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task127Test {

    private static final String TEMP_DIR = "test_temp";
    private static final String SOURCE_FILE = TEMP_DIR + "/source.txt";
    private static final String DEST_FILE = TEMP_DIR + "/copy.txt";

    @BeforeAll
    public static void setup() throws IOException {
        Files.createDirectories(Paths.get(TEMP_DIR));
    }

    @AfterEach
    public void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(SOURCE_FILE));
        Files.deleteIfExists(Paths.get(DEST_FILE));
    }

    @AfterAll
    public static void tearDown() throws IOException {
        Files.walk(Paths.get(TEMP_DIR))
                .sorted(java.util.Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    @Test
    public void testSuccessfulCopy() throws IOException {
        Files.writeString(Paths.get(SOURCE_FILE), "Hello, World!");
        Task127_CLAUDE_claude_3_5_sonnet_20240620.copyFile(SOURCE_FILE, DEST_FILE);
        String copiedContent = Files.readString(Paths.get(DEST_FILE));
        assertEquals("Hello, World!", copiedContent);
    }

    @Test
    public void testFileNotFound() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Task127_CLAUDE_claude_3_5_sonnet_20240620.copyFile("nonexistent.txt", DEST_FILE);

        System.setOut(System.out); // reset
        assertTrue(out.toString().contains("Error: Source file nonexistent.txt not found."));
    }

    @Test
    public void testPermissionDeniedSimulated() {
        // This test simulates AccessDeniedException by pointing to a directory instead of a file
        try {
            Files.writeString(Paths.get(SOURCE_FILE), "data");
            Files.createDirectory(Paths.get(DEST_FILE)); // simulate error: dest is a directory

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            Task127_CLAUDE_claude_3_5_sonnet_20240620.copyFile(SOURCE_FILE, DEST_FILE);

            System.setOut(System.out); // reset
            assertTrue(out.toString().contains("I/O error occurred"));
        } catch (IOException ignored) {
        }
    }
}
