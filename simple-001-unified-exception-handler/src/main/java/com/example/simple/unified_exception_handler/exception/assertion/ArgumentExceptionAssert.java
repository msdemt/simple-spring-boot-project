package com.example.simple.unified_exception_handler.exception.assertion;

import com.example.simple.unified_exception_handler.constant.IResponseEnum;
import com.example.simple.unified_exception_handler.exception.ArgumentException;
import com.example.simple.unified_exception_handler.exception.BaseException;

import java.text.MessageFormat;


public interface ArgumentExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = this.getMessage();
        if (args != null && args.length > 0) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new ArgumentException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = this.getMessage();
        if (args != null && args.length > 0) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new ArgumentException(this, args, msg, t);
    }

}
