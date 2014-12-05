package com.up_and_running.ch6.service;

import com.sun.net.httpserver.HttpExchange;

/**
 * @author Alexandr Jelimalai
 */
public interface IService {

    public void doGet(HttpExchange e);


    public void doPost(HttpExchange e);


    public void doPut(HttpExchange e);


    public void doDelete(HttpExchange e);
}
