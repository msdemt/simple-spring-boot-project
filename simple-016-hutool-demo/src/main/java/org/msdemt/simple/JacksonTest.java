package org.msdemt.simple;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.*;

public class JacksonTest {

    @Accessors(chain = true)
    @Data
    static
    class Link {
        private String phone;
        private String address;
        private String email;
    }

    @Accessors(chain = true)
    @Data
    static class User {
        private String name;
        private Integer age;
        private Double pay;
        private boolean valid;
        private char one;
        private Date birtiday;
        private Link link;

        private Map map;
        private List list;
        private Set set;
    }

    /**
     * https://www.iteye.com/blog/rsy-2303323
     * https://www.cnblogs.com/pejsidney/p/9235343.html
     * @param args
     * @throws JsonProcessingException
     */
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User()
                .setName("张三")
                .setAge(30)
                .setPay(8888.88)
                .setValid(true)
                .setOne('A')
                .setBirtiday(new Date())
                .setLink(new Link()
                        .setPhone("123456")
                        .setAddress("bj")
                        .setEmail("123@g.com"))
                .setMap(new HashMap<String, String>() {
                    {
                        put("map1", "111");
                        put("map2", "222");
                    }
                })
                .setList(new ArrayList() {
                    {
                        add("list1");
                        add("list2");
                    }
                })
                .setSet(new HashSet() {
                    {
                        add("set1");
                        add("set2");
                    }
                })
                ;

        ObjectMapper objectMapper = new ObjectMapper(); //转换器

        //对象转json
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        //json转map
        Map map = objectMapper.readValue(json, Map.class);
        map.forEach((k,v) -> System.out.printf("key: %s,\tvalue: %s\n", k, v));

        //map转json
        String str = objectMapper.writeValueAsString(map);
        System.out.println(str);

        //json转对象
        User user1 = objectMapper.readValue(json, User.class);
        System.out.println(user1);

        //对象转二进制
        byte[] bytes = objectMapper.writeValueAsBytes(user);


    }

}
