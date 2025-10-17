package com.foursale.testetecnico.victor.ms_relatorio.config;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.CustomPedidoRelatorioRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.RelationalEvent;

@Configuration
@EnableJdbcRepositories(basePackages = "com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring")
public class SpringJdbcConfig extends AbstractJdbcConfiguration {

    @Bean
    public ApplicationListener<?> loggingListener() {
        return (ApplicationListener<ApplicationEvent>) event -> {
            if (event instanceof RelationalEvent) {
                System.out.println("Received an event: " + event);
            }
        };
    }
}
