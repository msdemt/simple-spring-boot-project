package org.msdemt.simple.exception_handler.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.msdemt.simple.exception_handler.pojo.BaseResult;
import org.msdemt.simple.exception_handler.pojo.WebResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public BaseResult handleException(HttpServletResponse response, NullPointerException ex) {

        log.info("NullPointerException 错误代码：" + response.getStatus());

        BaseResult result = new WebResult(WebResult.RESULT_FAIL, "request error:" + response.getStatus()
                , "ControllerExceptionHandler:" + ex.getMessage());
        return result;
    }
}
