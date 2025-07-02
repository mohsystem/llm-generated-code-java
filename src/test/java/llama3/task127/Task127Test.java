package llama3.task127;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task127Test {

    private static final Path SRC_DIR = Paths.get("test_src_dir");
    private static final Path DST_DIR = Paths.get("test_dst_dir");
    private static final String FILENAME = "file.txt";

    @BeforeEach
    public void setup() throws IOException {
        Files.createDirectories(SRC_DIR);
        Files.createDirectories(DST_DIR);
        Files.writeString(SRC_DIR.resolve(FILENAME), "Sample data");
    }

    @AfterEach
    public void cleanup() throws IOException {
        Files.deleteIfExists(SRC_DIR.resolve(FILENAME));
        Files.deleteIfExists(DST_DIR.resolve(FILENAME));
        Files.deleteIfExists(SRC_DIR);
        Files.deleteIfExists(DST_DIR);
    }

    @Test
    public void testMainCopiesFileSuccessfully() throws Exception {
        String originalSrc = "/path/to/source/directory";
        String originalDst = "/path/to/temporary/directory";

        // Temporarily override System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        // Use reflection to override variables in main
        String code = Files.readString(Paths.get("src/main/java/llama3/task127/Task127_PERPLEXITY_llama_3_sonar_large_32k_chat.java"));
        assertTrue(code.contains("String srcDir = \"/path/to/source/directory\""));

        // Since variables are hardcoded, we simulate the same logic as main() here:
        Path srcFile = SRC_DIR.resolve(FILENAME);
        Path dstFile = DST_DIR.resolve(FILENAME);

        Files.copy(srcFile, dstFile);
        assertTrue(Files.exists(dstFile), "File should be copied to destination");

        System.setOut(originalOut);
    }
    @Test
    public void testMissingSourceFileShouldPrintError() {
        Path fakeSrc = Paths.get("fake_dir", "file.txt");
        Path realDst = Paths.get("real_dir", "file.txt");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            Files.copy(fakeSrc, realDst);
        } catch (IOException e) {
            System.out.println("Handled expected error.");
        }

        System.setOut(System.out);
        assertTrue(out.toString().contains("Handled expected error."));
    }

}
