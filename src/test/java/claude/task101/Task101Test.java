package claude.task101;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task101Test {

    private static final String FILE_NAME = "script.sh";
    private static final String EXPECTED_CONTENT = "#!/bin/bash \n echo \"Hello, World!\"";

    @BeforeAll
    public static void runMain() {
        Task101_CLAUDE_claude_3_5_sonnet_20240620.main(null);
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
    public void testFileIsExecutable() throws IOException {
        Path path = Paths.get(FILE_NAME);
        try {
            Set<PosixFilePermission> perms = Files.getPosixFilePermissions(path);
            Set<PosixFilePermission> expected = Set.of(
                    PosixFilePermission.OWNER_READ,
                    PosixFilePermission.OWNER_WRITE,
                    PosixFilePermission.OWNER_EXECUTE,
                    PosixFilePermission.GROUP_READ,
                    PosixFilePermission.GROUP_EXECUTE,
                    PosixFilePermission.OTHERS_READ,
                    PosixFilePermission.OTHERS_EXECUTE
            );
            assertEquals(expected, perms, "File permissions do not match expected 755");
        } catch (UnsupportedOperationException e) {
            // Windows fallback
            assertTrue(path.toFile().canExecute(), "File should be executable on non-POSIX system");
        }
    }

    @AfterAll
    public static void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(FILE_NAME));
    }
}
