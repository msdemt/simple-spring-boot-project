package org.msdemt.simple.unified_exception_handler_demo.constant;

/**
 * 返回码枚举接口
 */
public interface IResponseEnum {
    /**
     * 获取返回码
     * @return 返回码
     */
    String getCode();

    /**
     * 获取返回信息
     * @return 返回信息
     */
    String getMessage();
}
