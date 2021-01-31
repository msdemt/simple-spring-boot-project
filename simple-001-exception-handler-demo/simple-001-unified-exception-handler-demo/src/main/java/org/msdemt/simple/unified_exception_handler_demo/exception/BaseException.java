package org.msdemt.simple.unified_exception_handler_demo.exception;

import org.msdemt.simple.unified_exception_handler_demo.constant.IResponseEnum;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 异常信息枚举
     */
    protected IResponseEnum responseEnum;
    /**
     * 异常消息参数
     */
    protected Object[] args;

    public BaseException(IResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.responseEnum = responseEnum;
    }

    public BaseException(String code, String message) {
        super(message);
        this.responseEnum = new IResponseEnum() {
            @Override
            public String getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(message);
        this.responseEnum = responseEnum;
        this.args = args;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.responseEnum = responseEnum;
        this.args = args;
    }
}
