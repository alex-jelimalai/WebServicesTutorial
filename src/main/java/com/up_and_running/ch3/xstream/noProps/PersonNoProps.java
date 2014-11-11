package com.up_and_running.ch3.xstream.noProps;

/**
 * @author Alexandr Jelimalai
 */
public class PersonNoProps {

    private String name;
    private int age;
    private String gender;


    public PersonNoProps(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "PersonNoProps{" + "name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + '}';
    }
}
