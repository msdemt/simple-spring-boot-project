package org.msdemt.simple.unified_exception_handler_demo.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.msdemt.simple.unified_exception_handler_demo.exception.assertion.CommonExceptionAssert;

@Getter
@AllArgsConstructor
public enum CommonResponseEnum implements CommonExceptionAssert {

    SUCCESS("0000", "success"),

    NO_MATCHIING_BUSINESS_FOUND("6666", "未查询到匹配的业务"),
    Null_POINTER_EXCEPTION("9997", "空指针异常"),
    SERVER_BUSY("9998", "服务器繁忙"),
    SERVER_ERROR("9999", "网络异常"),
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
