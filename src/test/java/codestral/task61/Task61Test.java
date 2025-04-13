package codestral.task61;

import org.junit.jupiter.api.Test;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

public class Task61Test {

    private String getRootElement(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc.getDocumentElement().getTagName();
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void testBasicXml() {
        String xml = "<root><child1>Content</child1><child2 attr=\"value\"/></root>";
        assertEquals("root", getRootElement(xml));
    }

    @Test
    public void testSingleElementXml() {
        String xml = "<single/>";
        assertEquals("single", getRootElement(xml));
    }

    @Test
    public void testNestedElements() {
        String xml = "<parent><child><subchild/></child></parent>";
        assertEquals("parent", getRootElement(xml));
    }

    @Test
    public void testEmptyDocument() {
        String xml = "<empty></empty>";
        assertEquals("empty", getRootElement(xml));
    }

    @Test
    public void testSelfClosingTag() {
        String xml = "<selfclosing attr=\"value\"/>";
        assertEquals("selfclosing", getRootElement(xml));
    }

    @Test
    public void testXmlWithAttributes() {
        String xml = "<root attr=\"value\"><child/></root>";
        assertEquals("root", getRootElement(xml));
    }

    @Test
    public void testMultipleRootElements() {
        String xml = "<root1/><root2/>";
        assertNull(getRootElement(xml));
    }

    @Test
    public void testLargeXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<root>");
        for (int i = 0; i < 1000; i++) sb.append("<child>");
        for (int i = 0; i < 1000; i++) sb.append("</child>");
        sb.append("</root>");
        assertEquals("root", getRootElement(sb.toString()));
    }

    @Test
    public void testMalformedXml() {
        String xml = "<root><child></root>";
        assertNull(getRootElement(xml));  // malformed → null
    }

    @Test
    public void testXmlWithNamespaces() {
        String xml = "<ns:root xmlns:ns=\"http://example.com\"><ns:child/></ns:root>";
        assertEquals("ns:root", getRootElement(xml));
    }
}
