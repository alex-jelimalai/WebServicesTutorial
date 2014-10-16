package com.up_and_running.ch1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * User: Alexandr Jelimalai
 */
public class UrlConnectionClient {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: UrlConnectionClient <url>");
        }
        try {
            URL url = new URL(args[0].trim());
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String nextRecord;
            while ((nextRecord = reader.readLine()) != null) {
                System.out.println(nextRecord);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
