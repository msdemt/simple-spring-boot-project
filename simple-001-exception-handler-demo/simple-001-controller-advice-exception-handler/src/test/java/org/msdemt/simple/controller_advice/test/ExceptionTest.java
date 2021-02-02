package org.msdemt.simple.controller_advice.test;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ExceptionTest {

    /**
     * Assert that an object is not null.
     * Assert.notNull(clazz, "The class must not be null");
     * Params:
     * object – the object to check
     * message – the exception message to use if the assertion fails
     * Throws:
     * IllegalArgumentException – if the object is null
     */
    @Test
    public void test1() {
        Integer i = null;
        if (i == null) {
            throw new IllegalArgumentException("参数 i 不能为 null");
        }
    }

    @Test
    public void test2() {
        Integer i = null;
        Assert.notNull(i, "参数 i 不能为 null");
    }

}
