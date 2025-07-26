package gtp4o.task101;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task101Test {

    private static final String FILE_NAME = "script.sh";
    private static final String EXPECTED_CONTENT = "#!/bin/bash\n\necho 'Hello, World!'";

    @BeforeAll
    public static void runMain() {
        Task101_OPENAI_gpt_4o.main(null);
    }

    @Test
    @Order(1)
    public void testFileExists() {
        File file = new File(FILE_NAME);
        assertTrue(file.exists(), "File script.sh should exist");
    }

    @Test
    @Order(2)
    public void testFileContent() throws IOException {
        String content = Files.readString(Path.of(FILE_NAME));
        assertEquals(EXPECTED_CONTENT, content, "File content does not match expected");
    }

    @Test
    @Order(3)
    public void testFileIsExecutable() {
        File file = new File(FILE_NAME);
        assertTrue(file.canExecute(), "File should be executable");
    }

    @AfterAll
    public static void cleanup() throws IOException {
        Files.deleteIfExists(Path.of(FILE_NAME));
    }
}
