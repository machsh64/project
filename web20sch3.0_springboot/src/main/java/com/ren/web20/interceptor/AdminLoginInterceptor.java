package com.ren.web20.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: web20sch1.2
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-07 19:26
 * @description:
 **/
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object adminLogin = session.getAttribute("adminLogin");
        if (adminLogin != null){
            return true;
        }
        request.setAttribute("msg","请使用由站长获取到的账号登录后访问");
        request.getRequestDispatcher("/weblogin").forward(request,response);
        return false;
    }

}
