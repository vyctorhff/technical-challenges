package com.foursale.testetecnico.victor.ms_auth.config.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.UUID;

@Component
@ReadingConverter
public class ByteArrayToUuidConverter implements Converter<byte[], UUID> {
    @Override
    public UUID convert(byte[] source) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(source);
        long high = byteBuffer.getLong();
        long low = byteBuffer.getLong();
        return new UUID(high, low);
    }
}
