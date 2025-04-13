package llama3.task97;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task97Test {

    @Test
    void testBrokenXPathReturnsNothing() throws Exception {
         String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<tag id=\"2\">Value Two</tag>";

        Path tempFile = Files.createTempFile("test", ".xml");
        Files.writeString(tempFile, xmlContent);

         ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

         String[] args = { "2", tempFile.toString() };
        Task97_PERPLEXITY_llama_3_sonar_large_32k_chat.main(args);

        System.setOut(originalOut);

        String output = out.toString().trim();
        assertEquals("", output);
    }
}
