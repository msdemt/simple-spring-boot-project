package org.msdemt.simple.unified_exception_handler_demo.pojo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.msdemt.simple.unified_exception_handler_demo.constant.enums.CommonResponseEnum;

/**
 * 通用返回结果，同{@link CommonResponse}
 *
 * @param <T>
 * @see CommonResponse
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class R<T> extends CommonResponse<T> {

    /**
     * 私有默认构造器
     */
    private R() {
    }

    /**
     * 返回成功
     * @return
     */
    public static R ok() {
        return (R) new R()
                .code(CommonResponseEnum.SUCCESS.getCode())
                .mess(CommonResponseEnum.SUCCESS.getMessage());
    }

    /**
     * 返回成功
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> R<T> ok(T t) {
        return (R<T>) new R<>().data(t)
                .code(CommonResponseEnum.SUCCESS.getCode())
                .mess(CommonResponseEnum.SUCCESS.getMessage());
    }

    /**
     * 返回失败
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> R<T> error(T t) {
        return (R<T>) new R<>().data(t)
                .code(CommonResponseEnum.SERVER_ERROR.getCode())
                .mess(CommonResponseEnum.SERVER_ERROR.getMessage());
    }
}
