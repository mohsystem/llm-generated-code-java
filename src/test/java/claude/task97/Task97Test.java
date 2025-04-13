package claude.task97;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class Task97Test {

    @Test
    void testXPathQueryReturnsCorrectTitle() throws Exception {
        // Create temporary XML file
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<library>\n" +
                "    <book id=\"1\">\n" +
                "        <title>Effective Java</title>\n" +
                "        <author>Joshua Bloch</author>\n" +
                "        <year>2018</year>\n" +
                "        <publisher>Addison-Wesley</publisher>\n" +
                "    </book>\n" +
                "    <book id=\"2\">\n" +
                "        <title>Clean Code</title>\n" +
                "        <author>Robert C. Martin</author>\n" +
                "        <year>2008</year>\n" +
                "        <publisher>Prentice Hall</publisher>\n" +
                "    </book>\n" +
                "    <book id=\"3\">\n" +
                "        <title>The Pragmatic Programmer</title>\n" +
                "        <author>Andrew Hunt</author>\n" +
                "        <author>David Thomas</author>\n" +
                "        <year>1999</year>\n" +
                "        <publisher>Addison-Wesley</publisher>\n" +
                "    </book>\n" +
                "</library>";


        Path tempFile = Files.createTempFile("test", ".xml");
        Files.writeString(tempFile, xmlContent);

        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the main method with XPath to get the title of book with id=2
        String[] args = { tempFile.toString(), "/library/book[@id=2]/title" };
        Task97_CLAUDE_claude_3_5_sonnet_20240620.main(args);

        // Restore System.out
        System.setOut(originalOut);

        // Assert output
        String output = outContent.toString().trim();
        assertEquals("Clean Code", output);
    }
}
