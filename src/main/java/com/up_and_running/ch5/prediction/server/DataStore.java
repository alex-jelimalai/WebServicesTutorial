package com.up_and_running.ch5.prediction.server;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexandr Jelimalai
 */
public class DataStore {

    private static Map<String, String> stringStringMap = new HashMap<String, String>() {

        {
            put("moe", "HmacSHA256");
        }
    };


    public static String get(String name) {
        return stringStringMap.get(name);
    }
}
