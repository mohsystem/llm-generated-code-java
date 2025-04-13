package codestral.task97;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task97Test {

    @Test
    void testXPathTagById() throws Exception {
         String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "    <tag id=\"1\">Python</tag>\n" +
                "    <tag id=\"2\">Value Two</tag>\n" +
                "    <tag id=\"3\">Java</tag>\n" +
                "</root>";

         Path tempFile = Files.createTempFile("test", ".xml");
        Files.writeString(tempFile, xmlContent);

         ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

         String[] args = { "2", tempFile.toString() };
        Task97_MISTRAL_codestral_latest.main(args);

         System.setOut(originalOut);

         String output = out.toString().trim();

         assertEquals("Value Two", output);
    }
}
