package org.msdemt.simple.unified_exception_handler_demo.pojo.response;

public class ErrorResponse extends BaseResponse {

    public ErrorResponse() {
    }

    public ErrorResponse(String code, String message) {
        super(code, message);
    }
}
