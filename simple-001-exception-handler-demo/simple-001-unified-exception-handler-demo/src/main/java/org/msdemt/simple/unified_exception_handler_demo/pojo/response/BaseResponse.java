package org.msdemt.simple.unified_exception_handler_demo.pojo.response;

import lombok.experimental.Accessors;
import org.msdemt.simple.unified_exception_handler_demo.constant.IResponseEnum;
import org.msdemt.simple.unified_exception_handler_demo.constant.enums.CommonResponseEnum;
import lombok.Data;

@Accessors(fluent = true)
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
        this(CommonResponseEnum.SUCCESS);
    }

    public BaseResponse(String code, String mess) {
        this.code = code;
        this.mess = mess;
    }

    public BaseResponse(IResponseEnum responseEnum) {
        this(responseEnum.getCode(), responseEnum.getMessage());
    }

}
