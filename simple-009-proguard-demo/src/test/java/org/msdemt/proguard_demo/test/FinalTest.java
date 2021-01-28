package org.msdemt.proguard_demo.test;

import org.msdemt.proguard_demo.dao.entity.Student;

public class FinalTest {

    public static void main(String[] args) {
        final Student student = new Student("nike");

        //student = new Student("jack");  //error

        //InnerClass innerClass = new InnerClass();
        //innerClass.sayHello();
    }

    public void testFinalParameter(final String name){
        //name = "jack"; //error: Cannot assign a value to final variable 'name'
    }

    String name;

    public void test(boolean is){
        class InnerClass{
            public void sayHello(){
                if(is){
                    System.out.println("Hello " + name);
                }
            }
        }

    }



}
