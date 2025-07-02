package gtp4o.task127;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task127Test {

    private static final String SOURCE_PATH = "gtp4o_source.txt";
    private static final String DEST_PATH = "gtp4o_dest.txt";

    @BeforeEach
    public void setup() throws IOException {
        try (FileWriter writer = new FileWriter(SOURCE_PATH)) {
            writer.write("Test content for GPT-4o file copy.");
        }
    }

    @AfterEach
    public void cleanup() {
        new File(SOURCE_PATH).delete();
        new File(DEST_PATH).delete();
    }

    @Test
    public void testCopyFileSuccess() throws IOException {
        File source = new File(SOURCE_PATH);
        File dest = new File(DEST_PATH);

        Task127_OPENAI_gpt_4o.copyFile(source, dest);

        assertTrue(dest.exists(), "Destination file should exist.");
        String copied = new String(java.nio.file.Files.readAllBytes(dest.toPath()));
        assertEquals("Test content for GPT-4o file copy.", copied);
    }

    @Test
    public void testCopyFileNotFound() {
        File source = new File("nonexistent.txt");
        File dest = new File(DEST_PATH);

        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            Task127_OPENAI_gpt_4o.copyFile(source, dest);
        });

        assertTrue(exception.getMessage().contains("nonexistent.txt"));
    }

    @Test
    public void testCopyToSameFilePathHandledGracefully() throws IOException {
        File source = new File(SOURCE_PATH);
        // Try to copy to the same path
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        try {
            Task127_OPENAI_gpt_4o.copyFile(source, source);
        } catch (IOException e) {
            // acceptable if thrown
        }

        System.setOut(originalOut);
        String output = out.toString();

        // Accept either silent or exception-based behavior
        assertTrue(output.contains("error") || output.isEmpty());
    }

}
