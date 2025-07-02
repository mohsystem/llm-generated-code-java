package llama3.task117;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
import static org.junit.jupiter.api.Assertions.*;

class Task117Test {

    private static final String TEST_DIR = "test_data_llama3";
    private static final String ZIP_FILE = TEST_DIR + "/test.zip";
    private static final String EXTRACT_DIR = TEST_DIR + "/extract";

    @BeforeAll
    static void setup() throws IOException {
        // Clean previous test data
        deleteDirectory(Paths.get(TEST_DIR).toFile());

        // Create base directory
        new File(TEST_DIR).mkdirs();

        // Create sample files
        Files.writeString(Paths.get(TEST_DIR, "file1.txt"), "Hello from Llama3");
        Files.writeString(Paths.get(TEST_DIR, "file2.txt"), "Another test file");

        // Create ZIP archive
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ZIP_FILE))) {
            addToZip(zos, "file1.txt");
            addToZip(zos, "file2.txt");
        }
    }

    @AfterAll
    static void cleanup() {
        deleteDirectory(Paths.get(TEST_DIR).toFile());
    }

    private static void addToZip(ZipOutputStream zos, String fileName) throws IOException {
        File file = new File(TEST_DIR, fileName);
        try (FileInputStream fis = new FileInputStream(file)) {
            ZipEntry entry = new ZipEntry(fileName);
            zos.putNextEntry(entry);
            fis.transferTo(zos);
            zos.closeEntry();
        }
    }

    private static void deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                deleteDirectory(file);
            }
        }
        dir.delete();
    }

    @Test
    void testExtractZipArchive() throws Exception {
        Task117_PERPLEXITY_llama_3_sonar_large_32k_chat.extractZip(ZIP_FILE, EXTRACT_DIR);

        // Validate extraction
        assertTrue(Files.exists(Paths.get(EXTRACT_DIR, "file1.txt")));
        assertTrue(Files.exists(Paths.get(EXTRACT_DIR, "file2.txt")));
        assertEquals("Hello from Llama3", Files.readString(Paths.get(EXTRACT_DIR, "file1.txt")));
        assertEquals("Another test file", Files.readString(Paths.get(EXTRACT_DIR, "file2.txt")));
    }
}
