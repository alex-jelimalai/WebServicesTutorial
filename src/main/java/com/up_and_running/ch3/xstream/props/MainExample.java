package com.up_and_running.ch3.xstream.props;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author Alexandr Jelimalai
 */
public class MainExample {

    public static void main(String[] args) {
        PersonProps  person = new PersonProps();
        person.setName("Bruno");
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new PersonPropsConverter());
        xStream.alias("name", PersonProps.class);
        String xml = xStream.toXML(person);
        System.out.println(xml);
        PersonProps clonePerson = (PersonProps)xStream.fromXML(xml);
        System.out.println(clonePerson.getName());

    }

}
