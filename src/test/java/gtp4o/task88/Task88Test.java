package gtp4o.task88;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class Task88Test {

    @Test
    public void testGeneratedTempFile() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Task88_OPENAI_gpt_4o.main(new String[0]);

        System.setOut(originalOut);
        String path = outContent.toString().trim();

        Path filePath = Path.of(path);
        assertTrue(Files.exists(filePath));

        String content = Files.readString(filePath, StandardCharsets.UTF_8);
        assertEquals(10, content.length());
        assertTrue(content.matches("[A-Za-z0-9]{10}"));

        Files.deleteIfExists(filePath);
    }
}
