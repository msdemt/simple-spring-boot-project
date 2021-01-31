package org.msdemt.simple.exception_handler.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.msdemt.simple.exception_handler.pojo.BaseResult;
import org.msdemt.simple.exception_handler.pojo.WebResult;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义 ErrorController
 * 覆盖 {@link BasicErrorController}
 */
@Slf4j
@RestController
public class CustomErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @RequestMapping(path  = ERROR_PATH )
    public BaseResult error(HttpServletRequest request, HttpServletResponse response){
        log.info("访问/error" + "  错误代码："  + response.getStatus());
        BaseResult result = new WebResult(WebResult.RESULT_FAIL,"HttpErrorController error:"+response.getStatus());
        return result;
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
