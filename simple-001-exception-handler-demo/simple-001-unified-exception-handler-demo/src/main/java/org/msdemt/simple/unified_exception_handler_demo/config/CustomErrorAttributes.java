package org.msdemt.simple.unified_exception_handler_demo.config;

import org.msdemt.simple.unified_exception_handler_demo.constant.enums.CommonResponseEnum;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    public CustomErrorAttributes() {

    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = new HashMap<>();

        //404错误 统一返回如下信息
        errorAttributes.put("code", CommonResponseEnum.NO_MATCHIING_BUSINESS_FOUND.getCode());
        errorAttributes.put("mess", CommonResponseEnum.NO_MATCHIING_BUSINESS_FOUND.getMessage());

        return errorAttributes;
    }
}