package com.up_and_running.ch5.prediction.server;

/**
 * @author Alexandr Jelimalai
 */
public class VerbosityException extends Exception {

    private String details;


    public VerbosityException(String reason, String details) {
        super(reason);
        this.details = details;
    }


    public String getFaultInfo() {
        return this.details;
    }
}
