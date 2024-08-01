package claude2.task61;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class Task61_CLAUDE_claude_3_5_sonnet_20240620 {
    public static Element parseXMLString(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));
            return document.getDocumentElement();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String xmlString = "<root><child1>Value1</child1><child2>Value2</child2></root>";
        Element rootElement = parseXMLString(xmlString);
        if (rootElement != null) {
            System.out.println("Root element: " + rootElement.getTagName());
        }
    }
}
