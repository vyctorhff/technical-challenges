package com.foursale.testetecnico.victor.ms_product.config;

import com.foursale.testetecnico.victor.ms_product.config.converters.ByteArrayToUuidConverter;
import com.foursale.testetecnico.victor.ms_product.config.converters.UuidToByteArrayConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;

import java.util.List;

@Configuration
public class SpringJdbcConfig {

    @Bean
    public JdbcCustomConversions jdbcCustomConversions(
            ByteArrayToUuidConverter byteArrayToUuidConverter, UuidToByteArrayConverter uuidToByteArrayConverter) {
        return new JdbcCustomConversions(List.of(byteArrayToUuidConverter, uuidToByteArrayConverter));
    }
}
