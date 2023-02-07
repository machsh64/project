package com.ren.web20.config;

import com.ren.web20.interceptor.AdminLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: web20sch1.2
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-07 10:13
 * @description:
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        AdminLoginInterceptor adminLoginInterceptor = new AdminLoginInterceptor();
        InterceptorRegistration ir = registry.addInterceptor(adminLoginInterceptor);
        ir.addPathPatterns("/login/**");
    }
}
