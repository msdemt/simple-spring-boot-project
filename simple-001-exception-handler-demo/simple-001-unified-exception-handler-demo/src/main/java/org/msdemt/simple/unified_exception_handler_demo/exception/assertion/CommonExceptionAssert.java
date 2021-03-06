package org.msdemt.simple.unified_exception_handler_demo.exception.assertion;

import org.msdemt.simple.unified_exception_handler_demo.constant.IResponseEnum;
import org.msdemt.simple.unified_exception_handler_demo.exception.BaseException;
import org.msdemt.simple.unified_exception_handler_demo.exception.CommonException;

import java.text.MessageFormat;

public interface CommonExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = this.getMessage();
        if (args != null && args.length > 0) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new CommonException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = this.getMessage();
        if (args != null && args.length > 0) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new CommonException(this, args, msg, t);
    }

}
