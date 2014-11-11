package com.up_and_running.ch3.xstream.noProps;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

/**
 * @author Alexandr Jelimalai
 */
public class MainExample {

    public static void main(String[] args) {
        PersonNoProps bd = new PersonNoProps("Bjoern Daehlie", 49, "Male");
        // setup
        XStream xstream = new XStream(new Dom4JDriver());
        xstream.alias("skier", PersonNoProps.class); // for readability
        // serialize
        String xml = xstream.toXML(bd);
        System.out.println(xml);
        // deserialize and confirm
        PersonNoProps bdClone = (PersonNoProps)xstream.fromXML(xml);
        System.out.println(bdClone);
        System.out.println();
        System.out.println(xstream.toXML(bdClone));
    }
}
