package com.up_and_running.ch2.prediction3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexandr Jelimalai
 */
@XmlRootElement(name = "prediction")
public class Prediction implements Comparable<Prediction> {

    private String who;
    private String what;
    private int id;


    @XmlElement
    public String getWho() {
        return who;
    }


    public void setWho(String who) {
        this.who = who;
    }


    @XmlElement
    public String getWhat() {
        return what;
    }


    public void setWhat(String what) {
        this.what = what;
    }


    @XmlElement
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return String.format("%2d: ", id) + who + " ==> " + what + "\n";
    }


    @Override
    public int compareTo(Prediction other) {
        return this.id - other.id;
    }
}
