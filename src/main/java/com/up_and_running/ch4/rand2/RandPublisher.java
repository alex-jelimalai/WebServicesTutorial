package com.up_and_running.ch4.rand2;

import javax.xml.ws.Endpoint;

/**
 * @author Alexandr Jelimalai
 */
public class RandPublisher {

    public static void main(String[] args) {
        final String url = "http://localhost:8888/rs";
        System.out.println("Publishing RandService at endpoint " + url);
        Endpoint.publish(url, new RandImpl());
    }

}
