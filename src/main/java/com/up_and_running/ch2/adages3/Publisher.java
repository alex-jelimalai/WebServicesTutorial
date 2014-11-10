package com.up_and_running.ch2.adages3;

import javax.xml.ws.Endpoint;

/**
 * @author Alexandr Jelimalai
 */
public class Publisher {

    public static void main(String[] args) {
        int port = 8888;
        String url = "http://localhost:" + port + "/";
        System.out.println("Restfully publishing on port " + port);
        Endpoint.publish(url, new AdagesProvider());
    }
}
