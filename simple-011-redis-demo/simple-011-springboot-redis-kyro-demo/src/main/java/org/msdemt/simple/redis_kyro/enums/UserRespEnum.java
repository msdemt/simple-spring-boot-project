package org.msdemt.simple.redis_kyro.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.msdemt.simple.unified_exception_handler_demo.exception.assertion.BusinessExceptionAssert;

@Getter
@AllArgsConstructor
public enum UserRespEnum implements BusinessExceptionAssert {

    USER_NOT_EXIST("1001", "user not exists"),

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
