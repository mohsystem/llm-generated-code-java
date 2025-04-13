package claude.task88;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class Task88Test {

    @Test
    public void testCreateTempFileWithUnicode() throws IOException {
        String path = Task88_CLAUDE_claude_3_5_sonnet_20240620.createTempFileWithUnicode();

        // 1. Check that file exists
        File file = new File(path);
        assertTrue(file.exists(), "File should exist");

        // 2. Read file content
        String content = Files.readString(file.toPath());

        // 3. Check length (should be 10 Unicode sequences like \\u0041)
        Pattern unicodePattern = Pattern.compile("(\\\\u[0-9a-fA-F]{4}){10}");
        assertTrue(unicodePattern.matcher(content).matches(), "Content should contain exactly 10 Unicode sequences");

        // 4. Cleanup
        file.delete();
    }
}
