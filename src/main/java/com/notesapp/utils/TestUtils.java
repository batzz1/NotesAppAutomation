package com.notesapp.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;

public class TestUtils {
    public static final long WAIT = 10;

    /**
     *
     * @param file
     * @return <p>Map of key value pairs used for error mapping</p>
     * @throws Exception
     */
    public HashMap<String, String> parseXML(InputStream file) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();

        Element element = document.getDocumentElement();
        NodeList nodeList = element.getElementsByTagName("string");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                map.put(e.getAttribute("name"), e.getTextContent());
            }
        }
        return map;
    }
}
