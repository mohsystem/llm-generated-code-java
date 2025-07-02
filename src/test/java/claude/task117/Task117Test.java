package claude.task117;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
import org.apache.commons.compress.archivers.tar.*;
import static org.junit.jupiter.api.Assertions.*;

class Task117Test {

    private static final String TEST_DIR = "test_data";
    private static final String ZIP_FILE = TEST_DIR + "/test.zip";
    private static final String TAR_FILE = TEST_DIR + "/test.tar";
    private static final String EXTRACT_DIR = TEST_DIR + "/extract";

    @BeforeAll
    static void setup() throws IOException {
        // Clean any previous test data
        deleteDirectory(Paths.get(TEST_DIR).toFile());

        // Create base directory
        new File(TEST_DIR).mkdirs();

        // Create sample files
        Files.writeString(Paths.get(TEST_DIR, "file1.txt"), "Hello ZIP/TAR");
        Files.writeString(Paths.get(TEST_DIR, "file2.txt"), "Another file");

        // Create ZIP archive
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ZIP_FILE))) {
            addToZip(zos, "file1.txt");
            addToZip(zos, "file2.txt");
        }

        // Create TAR archive
        try (TarArchiveOutputStream tos = new TarArchiveOutputStream(new FileOutputStream(TAR_FILE))) {
            addToTar(tos, "file1.txt");
            addToTar(tos, "file2.txt");
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

    private static void addToTar(TarArchiveOutputStream tos, String fileName) throws IOException {
        File file = new File(TEST_DIR, fileName);
        TarArchiveEntry entry = new TarArchiveEntry(file, fileName);
        tos.putArchiveEntry(entry);
        Files.copy(file.toPath(), tos);
        tos.closeArchiveEntry();
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
        Task117_CLAUDE_claude_3_5_sonnet_20240620.extractArchive(ZIP_FILE, EXTRACT_DIR + "/zip");

        // Validate extraction
        assertTrue(Files.exists(Paths.get(EXTRACT_DIR, "zip", "file1.txt")));
        assertTrue(Files.exists(Paths.get(EXTRACT_DIR, "zip", "file2.txt")));
        assertEquals("Hello ZIP/TAR", Files.readString(Paths.get(EXTRACT_DIR, "zip", "file1.txt")));
        assertEquals("Another file", Files.readString(Paths.get(EXTRACT_DIR, "zip", "file2.txt")));
    }

    @Test
    void testExtractTarArchive() throws IOException {
        Task117_CLAUDE_claude_3_5_sonnet_20240620.extractArchive(TAR_FILE, EXTRACT_DIR + "/tar");

        // Validate extraction
        assertTrue(Files.exists(Paths.get(EXTRACT_DIR, "tar", "file1.txt")));
        assertTrue(Files.exists(Paths.get(EXTRACT_DIR, "tar", "file2.txt")));
        assertEquals("Hello ZIP/TAR", Files.readString(Paths.get(EXTRACT_DIR, "tar", "file1.txt")));
        assertEquals("Another file", Files.readString(Paths.get(EXTRACT_DIR, "tar", "file2.txt")));
    }
}
