package org.msdemt.simple.unified_exception_handler_demo.exception;

import org.msdemt.simple.unified_exception_handler_demo.constant.IResponseEnum;

public class CommonException extends BaseException{
    private static final long serialVersionUID = 1L;

    public CommonException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public CommonException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
