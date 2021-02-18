package org.msdemt.simple;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            HashMap<String, String> map = new HashMap<String, String>() {
                {
                    put("name", "test");
                    put("age", "20");
                }
            };
        }
        System.out.println(System.currentTimeMillis() - st); // 862


        //for (int i = 0; i < 10000000; i++) {
        //    HashMap<String, String> map = new HashMap<String, String>();
        //    map.put("name", "test");
        //    map.put("age", "20");
        //}
        //System.out.println(System.currentTimeMillis() - st); // 1030
    }
}
