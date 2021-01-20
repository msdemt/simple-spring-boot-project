package org.msdemt.simple.mybatis_not_use_interface_proxy_demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.msdemt.simple.unified_exception_handler_demo.exception.assertion.BusinessExceptionAssert;

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
     * 请求实体为空
     */
    REQUEST_IS_NULL(1001, "Request is null."),
    /**
     * 用户不存在
     */
    NOT_EXIST_USER(1002, "User not exist.")

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
