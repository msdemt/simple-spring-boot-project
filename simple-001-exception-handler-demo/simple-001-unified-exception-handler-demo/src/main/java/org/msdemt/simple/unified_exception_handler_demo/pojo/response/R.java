package org.msdemt.simple.unified_exception_handler_demo.pojo.response;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 通用返回结果，同{@link CommonResponse}
 *
 * @param <T>
 * @see CommonResponse
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class R<T> extends CommonResponse<T> {

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String message) {
        super();
        this.data = data;
        this.mess = message;
    }

    public R(Throwable e) {
        super();
        this.mess = e.getMessage();
        this.code = "-1";
    }
}
