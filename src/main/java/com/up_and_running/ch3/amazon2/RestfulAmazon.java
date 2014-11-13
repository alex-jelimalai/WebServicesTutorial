package com.up_and_running.ch3.amazon2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.up_and_running.ch3.amazon2.generated.Item;
import com.up_and_running.ch3.amazon2.generated.ItemAttributes;
import com.up_and_running.ch3.amazon2.generated.ItemLookupResponse;
import com.up_and_running.ch3.amazon2.generated.Items;

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
            // Create an XML Schema object
            final String fileName = "amazon.xsd"; // downloaded XML Schema
            final String schemaUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(schemaUri);
            Schema schema = factory.newSchema(new StreamSource(fileName));
            // Create a JAX-B context for unmarshaling
            JAXBContext ctx = JAXBContext.newInstance(ItemLookupResponse.class);
            Unmarshaller um = ctx.createUnmarshaller();
            um.setSchema(schema);
            // Generate a Java ItemSearchResponse instance.
            ItemLookupResponse ilr = (ItemLookupResponse)um.unmarshal(new ByteArrayInputStream(xml.getBytes()));
            // Use the standard POJO idiom to extract the author.
            List<Items> itemsList = ilr.getItems(); // list of lists
            for (Items items : itemsList) { // outer list
                List<Item> list = items.getItem(); // inner list
                for (Item item : list) { // items in inner list
                    ItemAttributes attributes = item.getItemAttributes();
                    List<String> authors = attributes.getAuthor(); // could be several
                    author = authors.get(0); // in this case, only one
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return author;
    }
}
