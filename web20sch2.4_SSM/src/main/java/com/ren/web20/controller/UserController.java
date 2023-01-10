package com.ren.web20.controller;

import com.ren.web20.util.TopicUtil;
import com.ren.web20.pojo.Admin;
import com.ren.web20.pojo.Author;
import com.ren.web20.pojo.Topic;
import com.ren.web20.service.AdminBasicService;
import com.ren.web20.service.TopicService;
import com.ren.web20.service.UserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String login(@PathVariable("loginNum") Integer loginNum, String loginId, String password, HttpSession session){

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
}
