package gtp4o.task97;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task97Test {

    @Test
    void testXPathReturnsCorrectXMLNode() throws Exception {
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

        String[] args = { "/root/tag[@id='2']", tempFile.toString() };
        Task97_OPENAI_gpt_4o.main(args);

        System.setOut(originalOut);

        String output = out.toString().trim();
        String expected = "<tag id=\"2\">Value Two</tag>";

        assertEquals(expected, output);
    }
}
