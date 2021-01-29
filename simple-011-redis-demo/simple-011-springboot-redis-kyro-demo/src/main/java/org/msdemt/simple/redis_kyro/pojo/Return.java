package org.msdemt.simple.redis_kyro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Return<T> {

    private String code;
    private String msg;
    private T t;

    public Return(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Return{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", tb=" + t +
                '}';
    }
}
