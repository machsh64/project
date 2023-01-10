package com.ren.web20.service.impl;

import com.ren.web20.util.TopicUtil;
import com.ren.web20.mapper.UserBasicMapper;
import com.ren.web20.pojo.Author;
import com.ren.web20.pojo.Topic;
import com.ren.web20.service.TopicService;
import com.ren.web20.service.UserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: WebCode
 * @author: Ren
 * @create: 2022-11-19 10:41
 * @description:
 **/
@Service
@Transactional
public class UserBasicServiceImpl implements UserBasicService {

    @Autowired
    private UserBasicMapper userBasicMapper;
    @Autowired
    private TopicService topicService;

    @Override
    public Author getAuthorById(int authorId) {
        return userBasicMapper.getAuthorById(authorId);
    }

    @Override
    public Author login(String loginId, String password) {
        Author author = userBasicMapper.login(loginId, password);
        if (author != null) {
            List<Topic> authorTopicList = topicService.getTopicListByAuthorId(author.getId());
            author.setTopicList(authorTopicList);
        }
        return author;
    }

/*模糊查找用户，功能简单但用户数量少，停止*/
    @Override
    public Author finder(Author author) {
        return null;
    }

    @Override
    public List<Author> getAllUser() {
        List<Author> authorList = userBasicMapper.getAllUser();
        for (Author author :authorList) {
            List<Topic> topicList = topicService.getTopicListByAuthorId(author.getId());
            List<Topic> topicList1 = TopicUtil.getTopicTimeWCount(topicList);
            author.setTopicList(topicList1);
        }
        return authorList;
    }

    @Override
    public int addUser(Author author) {
        Author finder = userBasicMapper.finder(author);
        if (finder == null){
            return userBasicMapper.addUser(author);
        } else {
            return 0;
        }
    }
}
