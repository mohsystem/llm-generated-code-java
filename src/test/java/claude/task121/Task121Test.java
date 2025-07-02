package claude.task121;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class Task121Test {

    private static final String TEST_DIR = "testFiles";

    @BeforeAll
    static void setupFiles() throws IOException {
        Files.createDirectories(Paths.get(TEST_DIR));

        createFile("test_file_1.txt", "Hello, world!");
        createFile("large_file.txt", "A".repeat(10_000));  // 10KB
        // Removed: createFile("file_with_!@#$%^&*()_+[]{};,.txt", "Special characters");
        createFile("file_no_extension", "No extension here");
        createFile("empty_file.txt", "");
        createFile("file with spaces.txt", "Spacey");
        createFile("a_very_long_filename_that_exceeds_normal_length_limits_for_filenames.txt", "Long name file");
        createFile("image_file.png", new byte[]{(byte) 137, 80, 78, 71});  // PNG Header
        createFile("file_with_newlines.txt", "Line1\nLine2\nLine3");
        // Do NOT create "non_existent_file.txt" and "file_not_found.txt"
    }

    private static void createFile(String filename, String content) throws IOException {
        Path path = Paths.get(TEST_DIR, filename);
        Files.write(path, content.getBytes());
    }

    private static void createFile(String filename, byte[] content) throws IOException {
        Path path = Paths.get(TEST_DIR, filename);
        Files.write(path, content);
    }

    @AfterAll
    static void cleanupFiles() throws IOException {
        Files.walk(Paths.get(TEST_DIR))
                .map(Path::toFile)
                .forEach(File::delete);
    }

    @Test
    void testAllFiles() {
        String[] filenames = {
                "test_file_1.txt",
                "large_file.txt",
                "file_no_extension",
                "empty_file.txt",
                "non_existent_file.txt",
                "file with spaces.txt",
                "a_very_long_filename_that_exceeds_normal_length_limits_for_filenames.txt",
                "image_file.png",
                "file_with_newlines.txt",
                "file_not_found.txt"
        };

        for (String filename : filenames) {
            runUploadFileTest(Paths.get(TEST_DIR, filename).toString());
        }
    }

    private void runUploadFileTest(String fullPath) {
        File file = new File(fullPath);
        boolean exists = file.exists();

        String input = fullPath + System.lineSeparator();
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            Task121_CLAUDE_claude_3_5_sonnet_20240620.uploadFile();

            String output = outContent.toString().trim();

            if (exists) {
                assertTrue(output.contains("uploaded successfully."), "Expected upload success for: " + fullPath);
                assertTrue(output.matches("(?s).*File size: \\d+ bytes.*"), "Expected file size info for: " + fullPath);
            } else {
                assertTrue(output.contains("not found."), "Expected not found message for: " + fullPath);
            }

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
