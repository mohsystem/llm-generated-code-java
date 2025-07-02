package gemini.task117;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
import static org.junit.jupiter.api.Assertions.*;

class Task117Test {

    private static final String TEST_DIR = "test_data_gemini";
    private static final String ZIP_FILE = TEST_DIR + "/test.zip";
    private static final String EXTRACT_DIR = TEST_DIR + "/extract";

    @BeforeAll
    static void setup() throws IOException {
        // Clean any previous test data
        deleteDirectory(Paths.get(TEST_DIR).toFile());

        // Create base directory
        new File(TEST_DIR).mkdirs();

        // Create sample files
        Files.writeString(Paths.get(TEST_DIR, "file1.txt"), "Hello ZIP Only");
        Files.writeString(Paths.get(TEST_DIR, "file2.txt"), "Another file in ZIP");

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
    void testExtractZipArchive() throws IOException {
        Task117_GEMINI_gemini_1_5_pro_001.extractZip(ZIP_FILE, EXTRACT_DIR);

        // Validate extraction
        assertTrue(Files.exists(Paths.get(EXTRACT_DIR, "file1.txt")));
        assertTrue(Files.exists(Paths.get(EXTRACT_DIR, "file2.txt")));
        assertEquals("Hello ZIP Only", Files.readString(Paths.get(EXTRACT_DIR, "file1.txt")));
        assertEquals("Another file in ZIP", Files.readString(Paths.get(EXTRACT_DIR, "file2.txt")));
    }
}
