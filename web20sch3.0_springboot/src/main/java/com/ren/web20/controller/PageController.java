package com.ren.web20.controller;

import com.ren.web20.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/page/{page}",method = RequestMethod.GET)
    public String page(@PathVariable("page") String page) {
        return page ;       // frames/left
    }

    /* 进入登 r1录页面前的判断，logNum=0时为用户登录 logNum=1时为管理员登录 保存在session作用域中*/
    /* enroll进行判断是注册还是登录 0为登录 1为注册*/
    @RequestMapping("/login/page")
    public String login(Integer enroll,Integer logNum, HttpSession session){
        /* 进行再次点击清空session账户信息，防止用户绕过检验进入管理层*/
        session.setAttribute("author",null);
        session.setAttribute("admin",null);

        session.setAttribute("enrollNum",enroll);
        session.setAttribute("logNum",logNum);
        /* 进行跳转后默认进行赋值登录页面 */
            return "login";
    }
}
