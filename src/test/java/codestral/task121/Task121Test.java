package codestral.task121;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class Task121Test {

    private static final String TEST_DIR = "testFiles";
    private static final String UPLOAD_DIR = "/path/to/the/uploads"; // Ensure this is writable

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setup() throws IOException {
        Files.createDirectories(Paths.get(TEST_DIR));
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        Files.write(Paths.get(TEST_DIR, "test_file_1.txt"), "Hello".getBytes());
        Files.write(Paths.get(TEST_DIR, "empty_file.txt"), new byte[0]);
        Files.write(Paths.get(TEST_DIR, "file_with_spaces.txt"), "Space file".getBytes());
        Files.write(Paths.get(TEST_DIR, "image_file.png"), new byte[]{(byte)137, 80, 78, 71});
    }

    @AfterAll
    static void cleanup() throws IOException {
        // Clean uploads
        Files.walk(Paths.get(UPLOAD_DIR))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(File::delete);
    }

    @Test
    void testUploadExistingFiles() throws Exception {
        uploadAndCheck("test_file_1.txt", 200, true);
        uploadAndCheck("file_with_spaces.txt", 200, true);
        uploadAndCheck("image_file.png", 200, true);
    }

    @Test
    void testUploadEmptyFile() throws Exception {
        uploadAndCheck("empty_file.txt", 302, false); // redirect without upload
    }

    @Test
    void testNonExistentFile() {
        assertThrows(IOException.class, () -> {
            new FileInputStream(Paths.get(TEST_DIR, "non_existent_file.txt").toFile());
        });
    }

    private void uploadAndCheck(String filename, int expectedStatus, boolean shouldBeSaved) throws Exception {
        File file = new File(TEST_DIR + "/" + filename);
        try (FileInputStream fis = new FileInputStream(file)) {
            MockMultipartFile mockFile = new MockMultipartFile("file", filename, "text/plain", fis);

            mockMvc.perform(multipart("/upload").file(mockFile))
                    .andExpect(status().is(expectedStatus));

            Path uploadedFile = Paths.get(UPLOAD_DIR, filename);
            if (shouldBeSaved) {
                assertTrue(Files.exists(uploadedFile), "File should be saved: " + filename);
            } else {
                assertFalse(Files.exists(uploadedFile), "Empty file should not be saved: " + filename);
            }
        }
    }
}
