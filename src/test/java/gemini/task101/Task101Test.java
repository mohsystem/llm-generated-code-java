package gemini.task101;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task101Test {

    private static final String FILE_NAME = "script.sh";
    private static final String EXPECTED_CONTENT = "#!/bin/bash\necho \"Hello from script.sh!\"\n";

    @BeforeAll
    public static void runMain() {
        try {
            Task101_GEMINI_gemini_1_5_pro_001.main(null);
        } catch (IOException e) {
            fail("Main method threw IOException: " + e.getMessage());
        }
    }

    @Test
    @Order(1)
    public void testFileExists() {
        assertTrue(Files.exists(Paths.get(FILE_NAME)), "File script.sh should exist");
    }

    @Test
    @Order(2)
    public void testFileContent() throws IOException {
        String content = Files.readString(Paths.get(FILE_NAME));
        assertEquals(EXPECTED_CONTENT, content, "File content does not match expected");
    }

    @Test
    @Order(3)
    public void testFilePermissions() throws IOException {
        Path path = Paths.get(FILE_NAME);
        try {
            Set<PosixFilePermission> perms = Files.getPosixFilePermissions(path);
            Set<PosixFilePermission> expected = Set.of(
                    PosixFilePermission.OWNER_READ,
                    PosixFilePermission.OWNER_WRITE,
                    PosixFilePermission.OWNER_EXECUTE,
                    PosixFilePermission.GROUP_READ,
                    PosixFilePermission.GROUP_EXECUTE,
                    PosixFilePermission.OTHERS_READ
            );
            assertEquals(expected, perms, "File permissions should match 755 (rwxr-xr-x)");
        } catch (UnsupportedOperationException e) {
            // On non-POSIX systems
            assertTrue(path.toFile().canExecute(), "File should be executable (fallback check on non-POSIX)");
        }
    }

    @AfterAll
    public static void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(FILE_NAME));
    }
}
