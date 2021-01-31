package org.msdemt.simple.redis_kyro.test;

import java.lang.reflect.ParameterizedType;

public class AbstractDao<T> {
    public Class<T> getActualType() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}


