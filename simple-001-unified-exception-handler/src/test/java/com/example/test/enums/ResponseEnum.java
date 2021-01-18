package com.example.test.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.example.simple.unified_exception_handler.exception.assertion.BusinessExceptionAssert;

/**
 * <p>返回结果</p>
 *
 * @author sprainkle
 * @date 2018.09.17
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {

    /**
     *
     */
    BAD_LICENCE_TYPE(7001, "Bad licence type."),
    /**
     *
     */
    LICENCE_NOT_FOUND(7002, "Licence not found.")

    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}
