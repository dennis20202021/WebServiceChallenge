package starter.com.challenge.tiempo.metrologico.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import starter.com.challenge.tiempo.metrologico.exceptions.FileException;
import starter.com.challenge.tiempo.metrologico.exceptions.ReadDataException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXML {

    private static ReadXML instance;

    protected String result;

    private ReadXML() {}

    public static ReadXML getInstance() {
        if (getObject() == null) {
            setObject(new ReadXML());
            return getObject();

        }
        return getObject();
    }

    private static void setObject(ReadXML instance) {
        ReadXML.instance = instance;
    }

    private static ReadXML getObject() {
        return instance;
    }

    public String getDataFrom(String path, String tagName) {
        try {

            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName(tagName);

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);
                setResult(node.getTextContent());
                return getResult();
            }

            return getResult();

        } catch (ParserConfigurationException exception) {

            throw FileException.getInstance("The XML file", path, exception);

        } catch (SAXException | IOException exception) {

            String binaryData = path.replaceAll("[A-z]+/", "");
            throw ReadDataException.getInstance("The data", binaryData, exception);

        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
