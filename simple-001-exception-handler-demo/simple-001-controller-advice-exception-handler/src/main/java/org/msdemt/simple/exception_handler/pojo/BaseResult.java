package org.msdemt.simple.exception_handler.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;

    //返回代码
    private Integer  code;

    //返回消息
    private String mess;

    //返回对象
    private  Object data;

    public BaseResult(Integer code, String mess) {
        this.code = code;
        this.mess = mess;
    }

    public BaseResult(Integer code, String mess, Object object) {
        this.code = code;
        this.mess = mess;
        this.data = object;
    }


}
