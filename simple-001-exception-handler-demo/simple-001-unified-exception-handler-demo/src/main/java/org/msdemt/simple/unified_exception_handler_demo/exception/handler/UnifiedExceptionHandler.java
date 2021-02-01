package org.msdemt.simple.unified_exception_handler_demo.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.msdemt.simple.unified_exception_handler_demo.constant.enums.ArgumentResponseEnum;
import org.msdemt.simple.unified_exception_handler_demo.constant.enums.CommonResponseEnum;
import org.msdemt.simple.unified_exception_handler_demo.constant.enums.ServletResponseEnum;
import org.msdemt.simple.unified_exception_handler_demo.exception.BaseException;
import org.msdemt.simple.unified_exception_handler_demo.exception.BusinessException;
import org.msdemt.simple.unified_exception_handler_demo.i18n.UnifiedMessageSource;
import org.msdemt.simple.unified_exception_handler_demo.pojo.response.ErrorResponse;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class UnifiedExceptionHandler {
    /**
     * 生产环境
     */
    private final static String ENV_PROD = "prod";

    private UnifiedMessageSource unifiedMessageSource;

    @Autowired
    public UnifiedExceptionHandler(UnifiedMessageSource unifiedMessageSource) {
        this.unifiedMessageSource = unifiedMessageSource;
    }

    /**
     * 当前环境，默认dev环境
     */
    @Value("${spring.profiles.active:dev}")
    private String profile;

    /**
     * 获取国际化消息
     *
     * @param e 异常
     * @return
     */
    public String getMessage(BaseException e) {
        String code = "response." + e.getResponseEnum().toString();
        String message = unifiedMessageSource.getMessage(code, e.getArgs());

        if (message == null || message.isEmpty()) {
            return e.getMessage();
        }

        return message;
    }

    /**
     * 业务异常处理器
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BusinessException.class)
    public ErrorResponse handleBusinessException(BaseException e) {
        log.error(e.getMessage(), e);

        return new ErrorResponse(e.getResponseEnum().getCode(), getMessage(e));
    }

    /**
     * 自定义异常处理器
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BaseException.class)
    public ErrorResponse handleBaseException(BaseException e) {
        log.error(e.getMessage(), e);

        return new ErrorResponse(e.getResponseEnum().getCode(), getMessage(e));
    }

    /**
     * Controller上一层相关异常 处理器
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler({
            //NoHandlerFoundException.class, //该异常由自定义控制器捕获处理
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMediaTypeNotAcceptableException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            // BindException.class,
            // MethodArgumentNotValidException.class
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public ErrorResponse handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        String code = CommonResponseEnum.SERVER_ERROR.getCode();
        try {
            ServletResponseEnum servletExceptionEnum = ServletResponseEnum.valueOf(e.getClass().getSimpleName());
            code = servletExceptionEnum.getCode();
        } catch (IllegalArgumentException e1) {
            log.error("class [{}] not defined in enum {}", e.getClass().getName(), ServletResponseEnum.class.getName());
        }

        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如404.
            code = CommonResponseEnum.SERVER_ERROR.getCode();
            BaseException baseException = new BaseException(CommonResponseEnum.SERVER_ERROR);
            String message = getMessage(baseException);
            return new ErrorResponse(code, message);
        }

        return new ErrorResponse(code, e.getMessage());
    }


    /**
     * 参数绑定异常处理器
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BindException.class)
    public ErrorResponse handleBindException(BindException e) {
        log.error("参数绑定校验异常", e);

        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 参数校验(Valid)异常处理器
     * 将校验失败的所有异常组合成一条错误信息
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorResponse handleValidException(MethodArgumentNotValidException e) {
        log.error("参数绑定校验异常", e);

        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 包装绑定异常结果
     *
     * @param bindingResult 绑定结果
     * @return 异常结果
     */
    private ErrorResponse wrapperBindingResult(BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();

        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(", ");
            if (error instanceof FieldError) {
                msg.append(((FieldError) error).getField()).append(": ");
            }
            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());

        }

        return new ErrorResponse(ArgumentResponseEnum.PARAMETER_VERIFICATION_FAILED.getCode(), msg.substring(2));
    }

    /**
     * 空指针异常单独处理
     * 若在Exception中处理，则返回的 e.getMessage() 为 null，不太友好
     * @param nullPointerException 空指针异常
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ErrorResponse handleNullPointerException(NullPointerException nullPointerException) {
        log.error(nullPointerException.getMessage(), nullPointerException);

        ErrorResponse errorResponse =  new ErrorResponse(CommonResponseEnum.Null_POINTER_EXCEPTION.getCode(),
                CommonResponseEnum.Null_POINTER_EXCEPTION.getMessage());
        return errorResponse;
    }

    /**
     * 未定义异常处理器
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = Exception.class)
    public ErrorResponse handleException(Exception e) {
        log.error(e.getMessage(), e);

        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
            String code = CommonResponseEnum.SERVER_ERROR.getCode();
            BaseException baseException = new BaseException(CommonResponseEnum.SERVER_ERROR);
            String message = getMessage(baseException);
            return new ErrorResponse(code, message);
        }

        ErrorResponse errorResponse =  new ErrorResponse(CommonResponseEnum.SERVER_ERROR.getCode(), e.getMessage());
        return errorResponse;
    }

}
