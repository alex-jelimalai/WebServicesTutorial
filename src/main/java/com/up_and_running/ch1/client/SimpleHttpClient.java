package com.up_and_running.ch1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * User: Alexandr Jelimalai
 */
public class SimpleHttpClient {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: SimpleHttpClient <url>");
        }
        try {
            URL url = new URL(args[0]);
            String host = url.getHost();
            String path = url.getPath();
            int port = url.getPort();
            if (port < 80) {
                port = 80;
            }

            String request = "GET " + path + "HTTP/1.1\n";
            request += "host: " + host;
            request += "\n\n";
            Socket socket = new Socket(host, port);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.print(request);
            printWriter.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String nextRecord;
            while ((nextRecord = reader.readLine()) != null) {
                System.out.println(nextRecord);
            }
            socket.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Bad Url");
        } catch (UnknownHostException e) {
            throw new RuntimeException("Unknown Host");
        } catch (IOException e) {
            throw new RuntimeException("Something wrong");
        }
    }
}
