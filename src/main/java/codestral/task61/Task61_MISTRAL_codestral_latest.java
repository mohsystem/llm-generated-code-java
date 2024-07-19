package codestral.task61;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import java.io.StringReader;

public class Task61_MISTRAL_codestral_latest {
    public static void main(String[] args) throws Exception {
        String xmlString = "<root><child>Data</child></root>";
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
        Element rootElement = doc.getDocumentElement();
        System.out.println("Root element: " + rootElement.getNodeName());
    }
}