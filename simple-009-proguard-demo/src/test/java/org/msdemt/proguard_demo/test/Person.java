package org.msdemt.proguard_demo.test;

public class Person {
    int name;
    int age;

    public void test(){
        final int num;
        num = 1;
        //num = 2; //error
        //num = 3; //error
    }
}
