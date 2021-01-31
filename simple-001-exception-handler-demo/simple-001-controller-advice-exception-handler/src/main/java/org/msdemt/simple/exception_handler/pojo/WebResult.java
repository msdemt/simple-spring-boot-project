package org.msdemt.simple.exception_handler.pojo;

public class WebResult extends BaseResult{

    public WebResult(Integer code, String mess) {
        super(code, mess);
    }

    public WebResult(Integer code, String mess, Object object) {
        super(code, mess, object);
    }
}
