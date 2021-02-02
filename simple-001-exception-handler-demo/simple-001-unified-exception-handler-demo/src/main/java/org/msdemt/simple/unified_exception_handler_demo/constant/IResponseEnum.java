package org.msdemt.simple.unified_exception_handler_demo.constant;

/**
 * 返回枚举接口
 */
public interface IResponseEnum {
    /**
     * 获取返回代码
     * @return 返回代码
     */
    String getCode();

    /**
     * 获取返回描述
     * @return 返回描述
     */
    String getMessage();
}
