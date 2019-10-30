package com.yan.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver").url
                ("jdbc:mysql://localhost:3306/test").username("root").password("123456").build();
        return dataSource;
    }

}
