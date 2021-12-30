package org.msdemt.simple.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.msdemt.simple.dto.ServiceResult;
import org.msdemt.simple.enums.ErrorCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    ServiceResult handleException(Exception e){
        log.error(ExceptionUtils.getStackTrace(e));
      return new ServiceResult(ErrorCode.STA_ERROR.getCode(), ErrorCode.STA_ERROR.getMessage());
    }

    /**
     * 统一校验注解解析 校验结果封装
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ServiceResult handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        String defaultMessage = result.getFieldError().getDefaultMessage();
        if (StringUtils.isBlank(defaultMessage)){
            return new ServiceResult(ErrorCode.STA_ERROR.getCode(), ErrorCode.STA_ERROR.getMessage());
        }
        return new ServiceResult(ErrorCode.getGeneralStatusCode(Integer.parseInt(defaultMessage)).getCode(),
                ErrorCode.getGeneralStatusCode(Integer.parseInt(defaultMessage)).getMessage());

    }
}
