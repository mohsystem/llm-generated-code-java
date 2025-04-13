package gemini.task97;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task97Test {

    @Test
    void testXPathTagWithId() throws Exception {
         String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "    <tag id=\"1\">Value One</tag>\n" +
                "    <tag id=\"2\">Value Two</tag>\n" +
                "    <tag id=\"3\">Value Three</tag>\n" +
                "</root>";

         Path tempFile = Files.createTempFile("test", ".xml");
        Files.writeString(tempFile, xmlContent);

         ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

         String[] args = { "/root/tag{}", tempFile.toString(), "2" };
        Task97_GEMINI_gemini_1_5_pro_001.main(args);

         System.setOut(originalOut);

         String output = out.toString().trim();

         assertTrue(output.contains("tag"), "Expected element 'tag' in output but got: " + output);
    }
}
