package com.up_and_running.ch3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Alexandr Jelimalai
 */
public class RestfulAmazon {

    private static final String endpoint = "ecs.amazonaws.com";
    private static final String itemId = "0545010225"; // Harry Potter


    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("RestfulAmazon <accessKeyId> <secretKey>");
            return;
        }

        new RestfulAmazon().lookupStuff(args[0].trim(), args[1].trim());
    }


    private void lookupStuff(String accessKeyId, String secretKey) {
        RequestHelper helper = new RequestHelper(endpoint, accessKeyId, secretKey);
        String requestUrl = null;
        String title = null;
        // Store query strings params in a hash
        Map<String, String> params = new HashMap<>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2009-03-31");
        params.put("Operation", "ItemLookup");
        params.put("ItemId", itemId);
        params.put("ResponseGroup", "Small");
        params.put("AssociateTag", "kalin");

        requestUrl = helper.sign(params);
        String response = requestAmazon(requestUrl);
        // The string null is returned before the XML document
        String noNullResponse = response.replaceFirst("null", "");

        System.out.println("Raw XML:\n" + noNullResponse);
        System.out.println("Author: " + getAuthor(noNullResponse));
    }


    private String requestAmazon(String requestUrl) {
        String response = null;
        try {
            URL url = new URL(requestUrl);
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String chunk;
            while ((chunk = bufferedReader.readLine()) != null) {
                response += chunk;
            }
            bufferedReader.close();
        } catch (Exception e) {

        }
        return response;
    }


    private String getAuthor(String xml) {
        String author = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final Document document = documentBuilder.parse(bais);
            NodeList result = document.getElementsByTagName("Author");
            for (int i = 0; i < result.getLength(); i++) {
                Element e = (Element)result.item(i);
                NodeList nodes = e.getChildNodes();
                for (int j = 0; j < nodes.getLength(); j++) {
                    final Node child = nodes.item(j);
                    if (child.getNodeType() == Node.TEXT_NODE) {
                        author = child.getNodeValue();
                    }
                }
            }
        } catch (Exception ex) {

        }
        return author;
    }
}
