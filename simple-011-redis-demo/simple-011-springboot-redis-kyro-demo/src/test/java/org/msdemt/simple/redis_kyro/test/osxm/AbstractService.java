package org.msdemt.simple.redis_kyro.test.osxm;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractService<T> {

    @SuppressWarnings("unchecked")
    public Class<Object> getActualClass() {
        // Class<T> tClass = (Class<T>) ((ParameterizedType)
        // getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Class<Object> actualClass = null;
        Type genType = getClass().getGenericSuperclass();
        System.out.println(getClass().getComponentType());
        System.out.println(getClass().getName());
        System.out.println(getClass().getAnnotatedInterfaces());
        System.out.println(getClass().getAnnotations());
        System.out.println(getClass().getCanonicalName());
        System.out.println(getClass().getDeclaredAnnotations());
        System.out.println(getClass().getDeclaredFields());
        System.out.println(getClass().getComponentType());
        System.out.println(getClass().getFields());
        System.out.println(getClass().getSimpleName());

        if (!(genType instanceof ParameterizedType)) {
            actualClass = Object.class;
        } else {
            ParameterizedType pt = (ParameterizedType) genType;
            actualClass = (Class<Object>) pt.getActualTypeArguments()[0];
        }
        return actualClass;
    }
}