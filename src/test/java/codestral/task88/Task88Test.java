package codestral.task88;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class Task88Test {

    @Test
    public void testTempFileContainsUnicodeEscapedString() throws IOException {
         Task88_MISTRAL_codestral_latest.main(new String[0]);

         File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File latestTempFile = null;
        long latestModified = Long.MIN_VALUE;

        for (File file : tempDir.listFiles()) {
            if (file.getName().startsWith("temp") && file.getName().endsWith(".txt")) {
                if (file.lastModified() > latestModified) {
                    latestTempFile = file;
                    latestModified = file.lastModified();
                }
            }
        }

        assertNotNull(latestTempFile, "Temp file was not created");

         String content = Files.readString(latestTempFile.toPath());

         Pattern pattern = Pattern.compile("(\\\\u[0-9a-fA-F]{4}){10}");
        assertTrue(pattern.matcher(content).matches(), "File content must contain exactly 10 Unicode escape sequences");

         latestTempFile.delete();
    }
}
