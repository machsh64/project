package com.ren.web20.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: web20sch1.2
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-07 11:01
 * @description:
 **/
@ToString
@Component
@ConfigurationProperties("adminweb")
@Data
public class AdminWeb {
    private String username;
    private String password;
}
