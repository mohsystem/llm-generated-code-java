package gtp4o.task61;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task61Test {

    private String getRootElement(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xmlString.getBytes()));
        return doc.getDocumentElement().getTagName();
    }

    @Test
    public void testBasicXml() throws Exception {
        String xml = "<root><child1>Content</child1><child2 attr=\"value\"/></root>";
        assertEquals("root", getRootElement(xml));
    }

    @Test
    public void testSingleElementXml() throws Exception {
        String xml = "<single/>";
        assertEquals("single", getRootElement(xml));
    }

    @Test
    public void testNestedElements() throws Exception {
        String xml = "<parent><child><subchild/></child></parent>";
        assertEquals("parent", getRootElement(xml));
    }

    @Test
    public void testEmptyDocument() throws Exception {
        String xml = "<empty></empty>";
        assertEquals("empty", getRootElement(xml));
    }

    @Test
    public void testSelfClosingTag() throws Exception {
        String xml = "<selfclosing attr=\"value\"/>";
        assertEquals("selfclosing", getRootElement(xml));
    }

    @Test
    public void testXmlWithAttributes() throws Exception {
        String xml = "<root attr=\"value\"><child/></root>";
        assertEquals("root", getRootElement(xml));
    }

    @Test
    public void testMultipleRootElements() {
        String xml = "<root1/><root2/>";
        assertThrows(SAXException.class, () -> getRootElement(xml));
    }

    @Test
    public void testLargeXml() throws Exception {
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
        assertThrows(SAXException.class, () -> getRootElement(xml));
    }

    @Test
    public void testXmlWithNamespaces() throws Exception {
        String xml = "<ns:root xmlns:ns=\"http://example.com\"><ns:child/></ns:root>";
        assertEquals("ns:root", getRootElement(xml));
    }
}
