package com.up_and_running.ch2;

import java.io.Serializable;

/**
 * @author Alexandr Jelimalai
 */
public class Prediction implements Serializable, Comparable<Prediction> {

    private String who;
    private String what;
    private int id;


    public String getWho() {
        return who;
    }


    public void setWho(String who) {
        this.who = who;
    }


    public String getWhat() {
        return what;
    }


    public void setWhat(String what) {
        this.what = what;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int compareTo(Prediction o) {
        return id - o.id;
    }
}
