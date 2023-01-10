package com.ren.web20.service.impl;

import com.ren.web20.mapper.AdminBasicMapper;
import com.ren.web20.pojo.Admin;
import com.ren.web20.pojo.Author;
import com.ren.web20.pojo.Topic;
import com.ren.web20.service.AdminBasicService;
import com.ren.web20.service.TopicService;
import com.ren.web20.service.UserBasicService;
import com.ren.web20.util.TopicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: WebCode
 * @author: Ren
 * @create: 2022-11-20 16:32
 * @description:
 **/
@Service
@Transactional
public class AdminBasicServiceImpl implements AdminBasicService {

    @Autowired
    private AdminBasicMapper adminBasicMapper;
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserBasicService userBasicService;

    @Override
    public Admin login(String loginId, String password) {
        Admin admin = adminBasicMapper.ADMINLogin(loginId, password);
        if (admin != null) {
            List<Author> allUser = userBasicService.getAllUser();
            admin.setAuthorList(allUser);
            List<Topic> allTopic = topicService.getAllTopic();
            List<Topic> topicTimeWCount = TopicUtil.getTopicTimeWCount(allTopic);
            admin.setTopicList(topicTimeWCount);
        }
        return admin;
    }

    @Override
    public int delAuthorById(int authorId){
        topicService.delAuthorTopicListById(authorId);
        return adminBasicMapper.delAuthorById(authorId);
    }
}
