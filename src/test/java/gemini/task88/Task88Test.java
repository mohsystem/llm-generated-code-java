package gemini.task88;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class Task88Test {

    @Test
    public void testCreateTempFileWithUnicode() throws IOException {
        String filePath = Task88_GEMINI_gemini_1_5_pro_001.createTempFileWithUnicode();

        File file = new File(filePath);
        assertTrue(file.exists());

        String content = Files.readString(file.toPath());

        Pattern uuidPattern = Pattern.compile("^[0-9a-fA-F\\-]{36}$");
        assertTrue(content.length() == 36 || content.length() == 32, "Content should be a UUID string");
        assertTrue(content.matches("[\\x00-\\x7F]+"), "Content must be plain UTF-8 ASCII characters");

        file.delete();
    }
}
