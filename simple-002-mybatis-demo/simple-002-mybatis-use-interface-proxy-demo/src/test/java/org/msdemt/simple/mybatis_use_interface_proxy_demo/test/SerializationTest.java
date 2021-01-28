package org.msdemt.simple.mybatis_use_interface_proxy_demo.test;

import org.junit.jupiter.api.Test;
import org.msdemt.simple.mybatis_use_interface_proxy_demo.dao.entity.User;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SerializationTest {

    /**
     * java对象序列化测试
     */
    @Test
    public void testSerialization() {
        User user = new User(null, "jack", 23, "Shanghai");

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用jdk7 try-with-resources 新特性
     * java对象序列化测试
     */
    @Test
    public void testSerializationForJDK7() {
        User user = new User(null, "jack", 23, "Shanghai");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * java对象反序列化测试
     */
    @Test
    public void testDeserialization(){
        File file = new File("tempFile");
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ois != null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用jdk7 try-with-resources 新特性
     * java对象反序列化测试
     */
    @Test
    public void testDeserializationForJDK7() {
        File file = new File("tempFile");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * jdk7新特性：二进制字面量表示整数
     */
    @Test
    public void testBinaryLiteral(){
        int x = 0B110110;
        System.out.println(x);
    }

    @Test
    public void testNumericLiteral(){
        byte a = 127;
        short b = 10_000;
        int c = 100_000;
        float d = 12.34_56F;
        double e = 12.34_56D;

        //float f = 12.3456_F; //error
        //float f = _12.3456F; //error
        //float f = 12.3456F_; //error
        //float f = 12._3456F; //error

        //java不能直接定义二进制
        int bin = 0b010101;  //二进制，jdk7开始，以0b或0B开头表示
        System.out.println(bin); //输出该二进制值对应的十进制值：21
        int oct = 0177; //八进制，以0开头表示
        System.out.println(oct); //输出该八进制值对应的十进制值：127
        int dec = 123; //十进制
        System.out.println(dec); //输出十进制值：123
        int hex = 0XFD10; //十六进制，以0x或0X开头表示
        System.out.println(hex); //输出该16进制值对应的十进制值：64784
        //int j = 0_x52; //error
        //int j = 0x_52; //error
    }

    @Test
    public void testSwitch(){
        String season = "春天";
        switch (season) {
            case "春天":
                System.out.println("春天来了");
                break;
            case "夏天":
                System.out.println("夏天来了");
                break;
            case "秋天":
                System.out.println("秋天来了");
                break;
            case "冬天":
                System.out.println("冬天来了");
                break;
        }
    }

    @Test
    public void testGeberic(){
        //jdk7之前
        List<String> listPreJDK7 = new ArrayList<String>();
        //jdk7及以后
        List<String> listForJDK7 = new ArrayList<>();
    }



}
