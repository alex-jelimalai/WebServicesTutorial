package com.up_and_running.ch2.adage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Alexandr Jelimalai
 */
@XmlRootElement(name = "adage")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"words", "wordCount"})
public class Adage {

    private String words;
    private int wordCount;


    public Adage() {
    }


    public void setWords(String words) {
        this.words = words;
        this.wordCount = words.trim().split("\\s+").length;
    }


    public String getWords() {
        return this.words;
    }


    public void setWordCount(int wordCount) {
    }


    public int getWordCount() {
        return this.wordCount;
    }


    @Override
    public String toString() {
        return words + " -- " + wordCount + " words";
    }

}
