package org.msdemt.simple.unified_exception_handler_demo.exception;


import org.msdemt.simple.unified_exception_handler_demo.constant.IResponseEnum;


public class ArgumentException extends BaseException {

    private static final long serialVersionUID = 1L;

    public ArgumentException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public ArgumentException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
