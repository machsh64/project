package com.ren.web20;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ren.web20.mapper")
@SpringBootApplication
public class Web20Application {

    public static void main(String[] args) {
        SpringApplication.run(Web20Application.class, args);
    }

}
