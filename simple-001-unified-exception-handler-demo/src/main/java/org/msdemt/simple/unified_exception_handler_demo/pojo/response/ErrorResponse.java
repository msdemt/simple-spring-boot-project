package org.msdemt.simple.unified_exception_handler_demo.pojo.response;

/**
 * <p>错误返回结果</p>
 */
public class ErrorResponse extends BaseResponse {

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message) {
        super(code, message);
    }
}
