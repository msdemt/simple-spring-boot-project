package org.msdemt.simple.unified_exception_handler_demo.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.msdemt.simple.unified_exception_handler_demo.exception.assertion.ArgumentExceptionAssert;

@Getter
@AllArgsConstructor
public enum ArgumentResponseEnum implements ArgumentExceptionAssert {

    PARAMETER_VERIFICATION_FAILED("6000", "参数校验失败"),

    ;

    /**
     * 返回代码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;

}
