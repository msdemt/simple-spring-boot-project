package org.msdemt.simple.redis_kyro.serializer;

import org.msdemt.simple.redis_kyro.util.KryoUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class KryoRedisSerializer<T> implements RedisSerializer<T> {

    //public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    //private static final ThreadLocal<Kryo> kryos = ThreadLocal.withInitial(Kryo::new);

    //private Class<T> clazz;
    //
    //public KryoRedisSerializer() {
    //
    //}

    //public KryoRedisSerializer(Class<T> clazz) {
    //    this.clazz = clazz;
    //}

    @Override
    public byte[] serialize(T t) throws SerializationException {
        //if (t == null) {
        //    return EMPTY_BYTE_ARRAY;
        //}

        return KryoUtil.writeToByteArray(t);

        //try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //     Output output = new Output(baos)) {
        //    kryo.writeClassAndObject(output, t);
        //    output.flush();
        //    return baos.toByteArray();
        //} catch (Exception e) {
        //    log.error(e.getMessage(), e);
        //}
        //
        //return EMPTY_BYTE_ARRAY;
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {

        return KryoUtil.readFromByteArray(bytes);
        //if (bytes == null || bytes.length <= 0) {
        //    return null;
        //}
        //
        //Kryo kryo = kryos.get();
        ////kryo.setReferences(false);
        ////kryo.register(clazz);
        //
        //try (Input input = new Input(bytes)) {
        //    return (T) kryo.readClassAndObject(input);
        //} catch (Exception e) {
        //    log.error(e.getMessage(), e);
        //}
        //
        //return null;
    }
}