package org.msdemt.simple.unified_exception_handler_demo.config;

import org.msdemt.simple.unified_exception_handler_demo.constant.enums.CommonResponseEnum;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomErrorController extends BasicErrorController {

    //public CustomErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
    //    super(errorAttributes, errorProperties);
    //}
    //
    //public CustomErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
    //    super(errorAttributes, errorProperties, errorViewResolvers);
    //}

    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        ResponseEntity<Map<String, Object>> responseEntity = super.error(request);
        Map<String, Object> errorAttributes = responseEntity.getBody();
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView()).addAllObjects(errorAttributes);
        return modelAndView;
    }

    //@RequestMapping
    //public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
    //
    //    HttpStatus status = getStatus(request);
    //
    //    Map<String, Object> errorAttributes = new HashMap<>();
    //    if(status == HttpStatus.NOT_FOUND){
    //        //404错误 统一返回如下信息
    //        errorAttributes.put("code", CommonResponseEnum.NO_MATCHIING_BUSINESS_FOUND.getCode());
    //        errorAttributes.put("mess", CommonResponseEnum.NO_MATCHIING_BUSINESS_FOUND.getMessage());
    //    }
    //    if (status == HttpStatus.NO_CONTENT) {
    //        return new ResponseEntity<>(status);
    //    }
    //
    //    Map<String, Object> body = errorAttributes;
    //    return new ResponseEntity<>(body, status);
    //}
}
