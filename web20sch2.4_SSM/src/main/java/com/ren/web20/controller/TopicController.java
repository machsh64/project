package com.ren.web20.controller;

import com.ren.web20.pojo.Admin;
import com.ren.web20.pojo.Author;
import com.ren.web20.pojo.Topic;
import com.ren.web20.service.TopicService;
import com.ren.web20.service.UserBasicService;
import com.ren.web20.util.TopicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: WebCode
 * @author: Ren
 * @create: 2022-11-19 10:39
 * @description:
 **/
@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private UserBasicService userBasicService;

    // 首页专题展示
    @RequestMapping(value = "/index/{page}",method = RequestMethod.GET)
    public String page(@PathVariable("page") String page, HttpSession session) {
        List<Topic> allTopic = topicService.getAllTopic();
        session.setAttribute("topicList", allTopic);
        //首页只进行6个专题展示
        List<Topic> indexTopic = new LinkedList<>();
        if (allTopic.size() > 6) {
            for (int i = 0; i < 6; i++) {
                indexTopic.add(allTopic.get(i));
            }
        }
        Object logNumObj = session.getAttribute("logNum");
        if (logNumObj==null){
            session.setAttribute("logNum",0);
        }
        session.setAttribute("indexTopic", indexTopic);

        return page;
    }

    /* 进行跳转时使用 利用loginNum进行用户/管理员判断 0为用户 1为管理员 */
    @RequestMapping(value = "/JumpCrash")
    public String JumpCrash(HttpSession session){
        int loginNum = (int) session.getAttribute("logNum");
        if (loginNum == 0){
            Author author = (Author) session.getAttribute("author");
            if (author != null){
                List<Topic> authorTopicList = topicService.getTopicListByAuthorId(author.getId());
                author.setTopicList(authorTopicList);
                return "authorWadmin";
            }else {
                return "authorWadmin";
            }
        }else if (loginNum == 1){
            Admin admin = (Admin) session.getAttribute("admin");
            if (admin != null){
                List<Author> allUser = userBasicService.getAllUser();
                admin.setAuthorList(allUser);
                return "authorWadmin";
            }else {
                return "authorWadmin";
            }
        }
        throw new RuntimeException("UserController出现问题");
    }

    // 进行提交专题
    @PostMapping("/topic")
    public String putTopic(String title, String headLine, String content, String publish, String localDateTime, Integer authorId) {
        Date date = TopicUtil.StringToDate(localDateTime);
        Topic topic = new Topic(title, headLine, content, date, publish, authorId);
       topicService.addTopic(topic);
        return "redirect:/JumpCrash";
    }

    //删除文章
    @DeleteMapping("/topic/{topicId}")
    public String delTopic(@PathVariable("topicId") Integer topicId, HttpSession session){
        topicService.delTopicById(topicId);
        return "redirect:/JumpCrash";
    }

    //跳转到文章详情
    @RequestMapping("/topic/detail/{topicId}")
    public String topicDetail(@PathVariable("topicId") Integer topicId,HttpSession session){
        Topic topic = topicService.getTopicById(topicId);
        session.setAttribute("topicDetail",topic);
        return "topicDetail";
    }

    //跳转到设置文章的页面
    @RequestMapping("/topic/{topicId}")
    public String setTopicD(@PathVariable("topicId") Integer topicId,HttpSession session){
        Topic topic = topicService.getTopicById(topicId);
        topic.setTopicTime(TopicUtil.DateToString(topic.getTopicDateTime()));
        session.setAttribute("topicDetail",topic);
        return "setTopic";
    }

    //修改文章
    @PutMapping("/topic")
    public String updateTopic(String title, String headLine, String content, String publish, String localDateTime, Integer topicId, HttpSession session){
        Date date = TopicUtil.StringToDate(localDateTime);
        Topic topic = new Topic(topicId,title, headLine, content, date, publish, topicId);
        topicService.updateTopic(topic);

        Author author = (Author) session.getAttribute("author");
        if (author != null){
            List<Topic> authorTopicList = topicService.getTopicListByAuthorId(author.getId());
            author.setTopicList(authorTopicList);
            return "redirect:/JumpCrash";
        }
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin!=null){
            List<Author> allUser = userBasicService.getAllUser();
            admin.setAuthorList(allUser);
            return "redirect:/JumpCrash";
        }
        throw new RuntimeException("TopicController: updateTopic_maybe exception");
    }
}
