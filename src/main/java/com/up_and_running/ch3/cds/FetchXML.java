package com.up_and_running.ch3.cds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;
import org.json.XML;

/**
 * @author Alexandr Jelimalai
 */
public class FetchXML {

    public void setJson(String json) {
    }


    public String getJson() {
        JSONObject json = null;
        try {
            // Fetch the XML document from the W3C site.
            String xml = "";
            URL url = new URL("http://www.w3schools.com/xml/cd_catalog.xml");
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // Read the document records.
            String line = null;
            while ((line = in.readLine()) != null)
                xml += line;
            in.close();
            xml = xml.replace("'", ""); // Clean up the XML.
            // Transform the XML document into a JSON object.
            json = XML.toJSONObject(xml.toLowerCase());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return json.toString(); // JSON document
    }
}
