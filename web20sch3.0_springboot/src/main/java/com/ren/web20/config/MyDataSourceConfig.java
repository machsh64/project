package com.ren.web20.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: web20sch1.2
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-07 10:11
 * @description:
 **/
@Configuration
public class MyDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DruidDataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
