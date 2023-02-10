package com.ren.web20.controller;

import com.ren.web20.pojo.Admin;
import com.ren.web20.pojo.AdminWeb;
import com.ren.web20.pojo.Author;
import com.ren.web20.pojo.Topic;
import com.ren.web20.service.AdminBasicService;
import com.ren.web20.service.TopicService;
import com.ren.web20.service.UserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * @program: WebCode
 * @author: Ren
 * @create: 2022-11-19 10:40
 * @description:
 **/
@Controller
public class UserController {

    @Autowired
    private UserBasicService userBasicService;
    @Autowired
    private AdminBasicService adminBasicService;
    @Autowired
    private TopicService topicService;

    /* 利用loginNum进行用户/管理员判断 0为用户 1为管理员 */
    @RequestMapping(value = {"/login/{loginNum}","/login"})
    public String login(@PathVariable(value = "loginNum") Integer loginNum, String loginId, String password, HttpSession session){

        if (loginNum == 0){
            Author author = userBasicService.login(loginId, password);
            if (author != null){
                List<Topic> authorTopicList = topicService.getTopicListByAuthorId(author.getId());
                author.setTopicList(authorTopicList);
                session.setAttribute("author",author);
                return "authorWadmin";
            }else {
                return "login";
            }
        }else if (loginNum == 1){
            Admin admin = adminBasicService.login(loginId, password);
            if (admin != null){

                session.setAttribute("admin",admin);
                return "authorWadmin";
            }else {
                return "login";
            }
        }
        throw new RuntimeException("UserController出现问题");
    }

    /* 注册 仅限用户进行注册 */
    @PostMapping("/enroll")
    public String enroll(String nickName,String loginId,String password,HttpSession session){
        userBasicService.addUser(new Author(nickName,loginId,password));
        session.setAttribute("enrollNum",0);
        return "login";
    }

    /* 删除 对特定id的用户进行删除*/
    @DeleteMapping("/delete/{authorId}")
    public String delAuthor(@PathVariable("authorId") Integer authorId){
        adminBasicService.delAuthorById(authorId);
        return "redirect:/JumpCrash";
    }

    /* 站长登录 */
    @GetMapping("/weblogin")
    public String webLogin(){
        return "weblogin";
    }

    @Autowired
    AdminWeb adminWeb;

    @PostMapping("/weblogin")
    public String main(@RequestParam("username") String username, @RequestParam("password") String password, Model model,HttpSession session) throws IOException {

        if (adminWeb.getUsername().equals(username)&&adminWeb.getPassword().equals(password)) {
            session.setAttribute("adminLogin",adminWeb);
            // 登录成功 重定向到index页面
            return "redirect:/";
        }else {
            // 将登陆失败的信息返回
            model.addAttribute("msg","账号或密码错误");
            // 回到登录页
            return "weblogin";
        }
    }
}
