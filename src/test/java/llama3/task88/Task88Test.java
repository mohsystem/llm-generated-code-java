package llama3.task88;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class Task88Test {

    @Test
    public void testUnicodeFileContent() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Task88_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[0]);

        System.setOut(originalOut);
        String path = outContent.toString().trim();

        Path filePath = Path.of(path);
        assertTrue(Files.exists(filePath));

        String content = Files.readString(filePath);

         Pattern unicodePattern = Pattern.compile("^(\\\\u[0-9a-fA-F]{4}){10,20}$");
        assertTrue(unicodePattern.matcher(content).matches(), "Content should contain 10-20 unicode escaped bytes");

        Files.deleteIfExists(filePath);
    }
}
