package org.msdemt.simple.unified_exception_handler_demo.pojo.response;

import org.msdemt.simple.unified_exception_handler_demo.constant.IResponseEnum;
import org.msdemt.simple.unified_exception_handler_demo.constant.enums.CommonExceptionResponseEnum;
import lombok.Data;

@Data
public class BaseResponse {
    /**
     * 返回代码
     */
    protected String code;
    /**
     * 返回消息
     */
    protected String mess;

    public BaseResponse() {
        this(CommonExceptionResponseEnum.SUCCESS);
    }

    public BaseResponse(String code, String mess) {
        this.code = code;
        this.mess = mess;
    }

    public BaseResponse(IResponseEnum responseEnum) {
        this(responseEnum.getCode(), responseEnum.getMessage());
    }

}
