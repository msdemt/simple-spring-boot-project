package org.msdemt.simple.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class JsonTest {
    /**
     * 序列化为JSON
     */
    @Test
    public void testJsonSerializationBigDecimal() throws JsonProcessingException {
        Person person = new Person();
        person.setMoney(new BigDecimal("1E11"));
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(person)); //{"name":null,"age":null,"money":1E+11,"hobby":null}
        objectMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN); //使用BigDecimal#toPlainString()方法输出
        System.out.println(objectMapper.writeValueAsString(person)); //{"name":null,"age":null,"money":100000000000,"hobby":null}
    }

    /**
     * 反序列化为对象时，JSON中多出属性，反序列化出现异常：com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
     *
     * 解决：
     *     方式一：ObjectMapper对象配置 DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES 为false
     *     方式二：在反序列化对象上添加注解 @JsonIgnoreProperties(ignoreUnknown = true)
     */
    @Test
    public void testJsonDeserializationExtraAttr() throws JsonProcessingException {
        String str = "{\"name\":\"nike\",\"age\":\"21\",\"gender\":\"male\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        //System.out.println(objectMapper.readValue(str, Person.class)); //com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //和上一行的作用相同
        System.out.println(objectMapper.readValue(str, Person.class)); //Person(name=nike, age=21, money=null, HOBBY=null)
    }

    /**
     * 反序列化为对象时，JSON中的属性是大写的，但是对象中的属性是小写的，反序列化抛出异常：com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
     *
     * 如何和上一个示例一样配置DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES，会导致反序列化后得不到大写的属性对应的值。
     *
     * 解决方式1：objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
     * 解决方式2：在对象实体的属性上添加 @JsonProperty("NAME")  该方式的缺陷：如果JSON中使用小写的name，会报错
     */
    @Test
    public void testJsonDeserializationHigherCase() throws JsonProcessingException {
        String str = "{\"NAME\":\"nike\",\"age\":\"21\"}";
        ObjectMapper objectMapper = new ObjectMapper();

        //System.out.println(objectMapper.readValue(str, Person.class)); //com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "NAME"

        //objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //System.out.println(objectMapper.readValue(str, Person.class)); //Person(name=null, age=21, money=null, HOBBY=null)  无效

        objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        System.out.println(objectMapper.readValue(str, Person.class)); //Person(name=nike, age=21, money=null, HOBBY=null)
        String str1 = "{\"name\":\"nike\",\"age\":\"21\"}";
        System.out.println(objectMapper.readValue(str1, Person.class)); //Person(name=nike, age=21, money=null, HOBBY=null)

        //添加 @JsonProperty("NAME") 在执行
        //String str1 = "{\"name\":\"nike\",\"age\":\"21\"}";
        //System.out.println(objectMapper.readValue(str1, Person.class)); //com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException:
    }

    /**
     * 如果我们希望对象序列化为JSON时，JSON中的属性默认是小写的，怎么让属性大写呢？
     * 在对象实体的属性上添加 @JsonProperty("NAME") ，加上该属性后，只支持NAME，不再支持name
     *
     * 暂未找到方式，既支持对象序列化为JSON时，输出的json属性大写，又支持JSON反序列化为对象时，支持json中的属性小写。
     * 因为@JsonProperty("NAME")将对象的属性绑定为了大写，不再支持小写
     */
    @Test
    public void testJsonSerializationHigherCase() throws JsonProcessingException {
        Person person = new Person();
        person.setName("nike");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(person)); //{"name":"nike","age":null,"money":null,"hobby":null}
        //添加 @JsonProperty("NAME") 在执行
        System.out.println(objectMapper.writeValueAsString(person)); //{"age":null,"money":null,"hobby":null,"NAME":"nike"}

        //添加 @JsonProperty("NAME")后使用NAME进行反序列化
        String str0 = "{\"NAME\":\"nike\",\"age\":\"21\"}";
        ObjectMapper objectMapper1 = new ObjectMapper();
        System.out.println(objectMapper1.readValue(str0, Person.class)); //Person(name=nike, age=21, money=null, HOBBY=null)

        //添加 @JsonProperty("NAME")后，就不再支持name进行反序列化了
        String str1 = "{\"name\":\"nike\",\"age\":\"21\"}";
        ObjectMapper objectMapper2 = new ObjectMapper();
        System.out.println(objectMapper2.readValue(str1, Person.class)); //com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "name"

        //添加 @JsonProperty("NAME")后,即便开启MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES，也不支持name进行反序列化
        String str2 = "{\"name\":\"nike\",\"age\":\"21\"}";
        ObjectMapper objectMapper3 = new ObjectMapper();
        objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        System.out.println(objectMapper3.readValue(str2, Person.class)); //com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "name"

    }

    /**
     * 支持蛇形命名的JSON
     * https://www.baeldung.com/jackson-deserialize-snake-to-camel-case
     */
    @Test
    public void testJsonSNAKECase() throws JsonProcessingException {
        String str = "{\"name\":\"nike\",\"first_name\":\"he\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        //System.out.println(objectMapper.readValue(str, Person.class)); //com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "first_name"

        //方式一：使用@JsonProperty注解
        //System.out.println(objectMapper.readValue(str, Person.class)); //Person(name=nike, age=null, money=null, firstName=he, HOBBY=null)

        //方式二：使用@JsonNaming注解(要求JSON的全部属性都要为蛇形命名，所以此处报错了)
        //System.out.println(objectMapper.readValue(str, Person.class)); //com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "name"

        //方式三：配置命名策略（要求JSON的全部属性都要为蛇形命名，所以此处报错了）
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        System.out.println(objectMapper.readValue(str, Person.class)); //com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "name"
    }

    /**
     * 反序列化时若JSON中含有控制字符或特殊字符，会报错
     * 解决：configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true)
     *
     * 建议关闭，否则反序列化后得到的对象中会多出一些不可见的东西，可能导致后续业务出现问题
     */
    @Test
    public void testJsonDeserializationUnescapedControlCharacters() throws JsonProcessingException {
        String str = "{\"name\":\"nike\u001F\",\"age\":\"21\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.readValue(str, Person.class)); //com.fasterxml.jackson.databind.JsonMappingException: Illegal unquoted character ((CTRL-CHAR, code 31)): has to be escaped using backslash to be included in string value

        //objectMapper.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
        objectMapper.enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature());
        System.out.println(objectMapper.readValue(str, Person.class)); //Person(name=nike, age=21, money=null, firstName=null, HOBBY=null)

    }

    /**
     * jackson序列化时，将属性值null转为空字符串
     *
     * 注意：需要注释掉第一个System.out才能看到第二个System.out正确的结果
     *
     * https://www.cnblogs.com/qingmuchuanqi48/p/11917018.html
     */
    @Test
    public void testJsonSerializationReturnEmpty() throws JsonProcessingException {
        Person person = new Person();
        person.setName("nike");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(person)); //{"name":"nike","age":null,"money":null,"firstName":null,"hobby":null}

        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString("");
            }
        });
        System.out.println(objectMapper.writeValueAsString(person)); //{"name":"nike","age":"","money":"","firstName":"","hobby":""}

    }

    /**
     * jackson序列化时，将属性值null的属性忽略
     * 方式一：在对象上添加注解 @JsonInclude(JsonInclude.Include.NON_NULL)
     * 方式二：objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
     *
     * 注意：需要注释掉第一个System.out才能看到第二个System.out正确的结果
     */
    @Test
    public void testJsonSerializationIgnoreNull() throws JsonProcessingException {
        Person person = new Person();
        person.setName("nike");
        ObjectMapper objectMapper = new ObjectMapper();
        //System.out.println(objectMapper.writeValueAsString(person)); //{"name":"nike","age":null,"money":null,"firstName":null,"hobby":null}
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        System.out.println(objectMapper.writeValueAsString(person)); //{"name":"nike"}
    }

    /**
     * https://www.jianshu.com/p/307ad48978d6
     *
     * jackson设置日期格式的方式
     * 方式一：objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")); 此外还需要配置中国时区 objectMapper.setLocale(Locale.CHINA);
     * 方式二：在实体参数上添加注解： @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
     *
     * timezone可以是GMT+8，也可以是 Asia/Shanghai
     *
     * 如果使用的是spring容器中的ObjectMapper，可以在yml中配置如下
     * spring:
     *   jackson:
     *     date-format: yyyy-MM-dd HH:mm:ss
     *     time-zone: GMT+8
     * @throws JsonProcessingException
     */
    @Test
    public void testJsonDate() throws JsonProcessingException {
        Person person = Person.builder().name("nike").birthday(new Date()).build();
        ObjectMapper objectMapper = new ObjectMapper();

        //对象进行序列化时，Date类型默认转为 timestamps 形式
        System.out.println(objectMapper.writeValueAsString(person)); //{"name":"nike","age":null,"money":null,"firstName":null,"birthday":1640843993749,"hobby":null}

        //若Json反序列化为对象时，Json中的Date格式为yyyy-MM-dd HH:mm:ss ，此时会出现异常
        String str = "{\"name\":\"nike\",\"birthday\":\"2021-12-30 06:32:54\"}";
        //System.out.println(objectMapper.readValue(str, Person.class)); //com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `java.util.Date` from String "2021-12-30 06:07:05": not a valid representation

        //配置Date类型不输出为timestamps形式，配置后输出的时间格式为：yyyy-MM-dd'T'HH:mm:ss.SSSZ，为ISO-8601数据类型
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        System.out.println(objectMapper.writeValueAsString(person)); //{"name":"nike","age":null,"money":null,"firstName":null,"birthday":"2021-12-30T06:32:54.634+00:00","hobby":null}

        //若Json反序列化为对象时，Json中的Date格式为yyyy-MM-dd HH:mm:ss ，此时会出现异常
        //System.out.println(objectMapper.readValue(str, Person.class)); //com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `java.util.Date` from String "2021-12-30 06:07:05": not a valid representation

        //"yyyy-MM-dd HH:mm:ss"日期格式JSON反序列化
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        Person person1 = objectMapper.readValue(str, Person.class);
        System.out.println(person1); //Person(name=nike, age=null, money=null, firstName=null, HOBBY=null, birthday=Thu Dec 30 06:32:54 CST 2021)

        //反序列化后的对象再进行序列化
        System.out.println(objectMapper.writeValueAsString(person1)); //{"name":"nike","age":null,"money":null,"firstName":null,"birthday":"2021-12-30 06:32:54","hobby":null}

        //可以看到，当前时间时 12-30 14:33 ,但是jackson输出的时间是 2021-12-30 06:32:54，相差8个小时
        objectMapper.setLocale(Locale.CHINA); //配置中国时区
        System.out.println(objectMapper.writeValueAsString(person)); //{"name":"nike","age":null,"money":null,"firstName":null,"birthday":"2021-12-30 14:38:15","hobby":null}
    }

}
