package com.up_and_running.ch5.prediction.server;

import java.io.Serializable;

/**
 * @author Alexandr Jelimalai
 */
public class Prediction implements Serializable, Comparable<Prediction> {

    private String who; // person
    private String what; // his/her prediction
    private int id; // identifier used as lookup key


    public Prediction() {
    }


    public void setWho(String who) {
        this.who = who;
    }


    public String getWho() {
        return this.who;
    }


    public void setWhat(String what) {
        this.what = what;
    }


    public String getWhat() {
        return this.what;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return this.id;
    }


    @Override
    public int compareTo(Prediction other) {
        return this.id - other.id;
    }
}
