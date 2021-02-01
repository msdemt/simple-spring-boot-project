package org.msdemt.simple.unified_exception_handler_demo.pojo.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class ErrorResponse extends BaseResponse {

    public ErrorResponse() {
    }

    public ErrorResponse(String code, String message) {
        super(code, message);
    }
}
