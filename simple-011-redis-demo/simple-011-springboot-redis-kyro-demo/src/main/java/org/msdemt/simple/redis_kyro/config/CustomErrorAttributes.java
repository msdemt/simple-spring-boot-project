//package org.msdemt.simple.redis_kyro.config;
//
//import org.springframework.boot.web.error.ErrorAttributeOptions;
//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.WebRequest;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@Component
//public class CustomErrorAttributes extends DefaultErrorAttributes {
//
//    public CustomErrorAttributes() {
//        System.out.println("123");
//    }
//
//    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
//        Map<String, Object> errorAttributes = new HashMap<>();
//
//        //404, 500错误 统一返回如下信息
//        errorAttributes.put("code","9999");
//        errorAttributes.put("mess", "failed");
//
//        return errorAttributes;
//    }
//}