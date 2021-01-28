package org.msdemt.proguard_demo.dao.entity;

public class Person {

    private String name;
    private int age;
    private String address;
    private static String country;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
