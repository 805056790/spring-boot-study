package pers.study.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author : panxin
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        try {
            if (o == null) {
                return new byte[0];
            }
            return serializer.convert(o);
        }catch (Exception e) {
            throw new SerializationException("Serialize failed, cause: " + e.getMessage());
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        try {
            if (bytes == null || bytes.length <= 0) {
                return null;
            }
            return deserializer.convert(bytes);
        }catch (Exception e) {
            throw new SerializationException("Deserialize failed, cause: " + e.getMessage());
        }
    }

}
