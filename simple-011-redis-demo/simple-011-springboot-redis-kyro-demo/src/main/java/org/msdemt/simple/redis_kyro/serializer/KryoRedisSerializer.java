package org.msdemt.simple.redis_kyro.serializer;

import org.msdemt.simple.redis_kyro.util.KryoUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;

public class KryoRedisSerializer<T> implements RedisSerializer<T> {

    static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] serialize(@Nullable T t) throws SerializationException {
        if (t == null) {
            return EMPTY_ARRAY;
        }
        return KryoUtil.writeToByteArray(t);
    }

    @Override
    public T deserialize(@Nullable byte[] bytes) throws SerializationException {
        if (bytes == null) {
            return null;
        }
        return KryoUtil.readFromByteArray(bytes);
    }
}