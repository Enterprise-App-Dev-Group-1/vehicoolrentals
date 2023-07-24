package com.vehicoolrentals.app.business;

// SearchServiceImpl.java
import com.vehicoolrentals.app.domain.Car;
import com.vehicoolrentals.app.domain.ISearch;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class SearchServiceImpl implements ISearch {

    private static final String API_BASE_URL = "https://vpic.nhtsa.dot.gov/api/";

    @Override
    public Car searchCarByVin(String vin) {
        try {
            URL url = new URI(API_BASE_URL + "vehicles/DecodeVINValuesBatch/" + vin + "?format=xml").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");

            if (connection.getResponseCode() == 200) {
                InputStream xmlStream = connection.getInputStream();
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(xmlStream);

                NodeList results = doc.getElementsByTagName("DecodedVariable");
                int carId = 0;
                Car car = new Car("Dummy Make", "Dummy Model", 0);

                for (int i = 0; i < results.getLength(); i++) {
                    Node result = results.item(i);
                    if (result.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) result;
                        String variable = element.getElementsByTagName("Variable").item(0).getTextContent();
                        String value = element.getElementsByTagName("Value").item(0).getTextContent();

                        switch (variable) {
                            case "Make" -> car.setMake(value);
                            case "Model" -> car.setModel(value);
                            case "Model Year" -> car.setModelYear(Integer.parseInt(value));

                            // Add more properties if needed
                            default -> {
                            }
                            // Ignore other properties for now
                        }
                    }
                }

                return car;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
// // SearchController.java
