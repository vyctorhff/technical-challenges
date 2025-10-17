package com.foursale.testetecnico.victor.ms_auth.config.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.UUID;

@Component
@WritingConverter
public class UuidToByteArrayConverter implements Converter<UUID, byte[]> {
    @Override
    public byte[] convert(UUID source) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(source.getMostSignificantBits());
        bb.putLong(source.getLeastSignificantBits());
        return bb.array();
    }
}
