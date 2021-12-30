package org.msdemt.simple.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JsonUtil {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();

        objectMapper
                //BigDecimal数字以字符串形式输出
                .configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)
                //若json转对象时，json中多字段，配置为忽略多余的字段，从而转对象时不会失败
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                //json反序列化为对象时大小写脱敏
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                //支持json中含有特殊字符
                //.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true)
                ;



        //若值为null则转为空字符串
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString("");
            }
        });
        //不包含值为null的字段
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    /**
     * 对象转json
     *
     * @param obj
     * @return
     */
    public static <T> String obj2String(T obj) {
        if (obj == null) {
            //log.error("对象转json失败，对象为null");
            return null;
        }

        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("对象转json失败，错误：{}", e.getMessage());
            return null;
        }
    }


    /**
     * 对象转json,优雅展示json
     *
     * @param obj
     * @return
     */
    public static <T> String obj2StringPretty(T obj) {
        if (obj == null) {
            log.error("对象转字符串失败，对象为null");
            return null;
        }

        try {
            return obj instanceof String ? (String) obj : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("对象转字符串失败，错误：{}", e.getMessage());
            return null;
        }
    }

    public static <T> T string2Obj(String str, Class<T> clazz) {
        if (str == null || str.length() == 0 || clazz == null) {
            log.error("字符串转对象失败，字符串为null");
            return null;
        }

        try {
            return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
        } catch (JsonMappingException e) {
            log.error("字符串转对象失败，错误：{}", e.getMessage());
            return null;
        } catch (JsonProcessingException e) {
            log.error("字符串转对象失败，错误：{}", e.getMessage());
            return null;
        } catch (IOException e) {
            log.error("字符串转对象失败，错误：{}", e.getMessage());
            return null;
        }

    }


    public static <T> T string2Obj(String str, TypeReference<T> typeReference) {
        if (str == null || str.length() == 0 || typeReference == null) {
            log.error("字符串转对象失败，字符串为null");
            return null;
        }

        try {
            return (T) (typeReference.getType().equals(String.class) ? str : objectMapper.readValue(str, typeReference));
        } catch (IOException e) {
            log.error("字符串转对象失败，错误：{}", e.getMessage());
            return null;
        }
    }

    /**
     *
     * @param str
     * @param collectionClazz
     * @param elementClazzes
     * @param <T>
     * @return
     */
    public static <T> T string2Obj(String str, Class<?> collectionClazz, Class<?>... elementClazzes) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClazz, elementClazzes);

        try {
            return objectMapper.readValue(str, javaType);
        } catch (IOException e) {
            log.error("字符串转对象失败，错误：{}", e.getMessage());
            return null;
        }
    }

    public static JsonBuilder builder(){
        return new JsonBuilder();
    }

    public static class JsonBuilder {
        private Map<String, Object> map = new HashMap<>();


        public JsonBuilder put(String key, Object value){
            map.put(key, value);
            return this;
        }

        public String build(){
            ObjectMapper objectMapper = new ObjectMapper();

            try{
                return objectMapper.writeValueAsString(this.map);
            } catch (JsonProcessingException e) {
                log.error("Map转Json失败，错误：{}", e.getMessage());
                return null;
            }
        }
    }

}
