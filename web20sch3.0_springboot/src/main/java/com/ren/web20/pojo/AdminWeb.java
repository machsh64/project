package com.ren.web20.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Properties;

/**
 * @program: web20sch1.2
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-07 11:01
 * @description:
 **/
@ToString
@Data
public class AdminWeb {

    private String username;

    private String password;

    private static AdminWeb instance = null;

    public AdminWeb(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static AdminWeb getInstance(){
        if (instance == null){
            synchronized (AdminWeb.class){
                if (instance == null) {
                    instance = new AdminWeb("igottheworld", "123");
                }
            }
        }
        return instance;
    }

}
