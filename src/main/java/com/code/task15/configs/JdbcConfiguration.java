package com.code.task15.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

    @Bean(name = "Datasource")
    @Primary
    @ConfigurationProperties("task15.datasource")
    public DataSource subscriptionDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "JdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("Datasource")
                                                            DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
