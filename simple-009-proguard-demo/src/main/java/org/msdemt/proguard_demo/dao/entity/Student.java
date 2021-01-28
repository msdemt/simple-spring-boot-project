package org.msdemt.proguard_demo.dao.entity;

public class Student extends User{

    final String name;
    final String age = "29"; //final修饰的成员变量在定义时完成初始化
    String address;
    String country;

    public Student(String name) {
        this.name = name; //final修饰的成员变量在构造方法中完成初始化
    }

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Student(String name, String address, String country) {
        this(name);  //多个构造方法，最终完成对final变量的赋值
        this.address = address;
        this.country = country;
    }

    public void testFinal0(String str){
        String hello;
        hello = str;
        System.out.println(hello);
    }
    public void testFinal1(final String str){
        String hello;
        hello = str;
        System.out.println(hello);
    }
    public void testFinal2(final String str){
        final String hello;
        hello = str;
        System.out.println(hello);
    }
    public void testFinal3(String str){
        final String hello;
        hello = str;
        System.out.println(hello);
    }


}
