package claude.task61;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.*;

public class Task61Test {

    @Test
    public void testBasicXml() {
        String xml = "<root><child1>Content</child1><child2 attr=\"value\"/></root>";
        assertEquals("root", Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(xml));
    }

    @Test
    public void testSingleElementXml() {
        String xml = "<single/>";
        assertEquals("single", Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(xml));
    }

    @Test
    public void testNestedElements() {
        String xml = "<parent><child><subchild/></child></parent>";
        assertEquals("parent", Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(xml));
    }

    @Test
    public void testEmptyDocument() {
        String xml = "<empty></empty>";
        assertEquals("empty", Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(xml));
    }

    @Test
    public void testSelfClosingTag() {
        String xml = "<selfclosing attr=\"value\"/>";
        assertEquals("selfclosing", Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(xml));
    }

    @Test
    public void testXmlWithAttributes() {
        String xml = "<root attr=\"value\"><child/></root>";
        assertEquals("root", Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(xml));
    }

    @Test
    public void testMultipleRootElements() {
        String xml = "<root1/><root2/>";
        String result = Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(xml);
        assertNull(result);
    }

    @Test
    public void testLargeXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<root>");
        for (int i = 0; i < 1000; i++) sb.append("<child>");
        for (int i = 0; i < 1000; i++) sb.append("</child>");
        sb.append("</root>");
        assertEquals("root", Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(sb.toString()));
    }

    @Test
    public void testMalformedXml() {
        String xml = "<root><child></root>";
        String result = Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(xml);
        assertNull(result);
    }

    @Test
    public void testXmlWithNamespaces() {
        String xml = "<ns:root xmlns:ns=\"http://example.com\"><ns:child/></ns:root>";
        assertEquals("ns:root", Task61_CLAUDE_claude_3_5_sonnet_20240620.getRootElement(xml));
    }
}
