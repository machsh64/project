package com.ren.web20.service.impl;

import com.ren.myssm.util.SqlSessionUtil;
import com.ren.myssm.util.TopicUtil;
import com.ren.web20.mapper.TopicMapper;
import com.ren.web20.pojo.Topic;
import com.ren.web20.service.TopicService;

import java.util.List;

/**
 * @program: WebCode
 * @author: Ren
 * @create: 2022-11-19 10:41
 * @description:
 **/
public class TopicServiceImpl implements TopicService {

    private TopicMapper topicMapper;

    @Override
    public Topic getTopicById(int topicId){
        Topic topic = topicMapper.getTopicById(topicId);
        return TopicUtil.getTopicTimeWPo(topic);
    }

    @Override
    public List<Topic> getTopicListByAuthorId(int authorId) {
        List<Topic> topicList = topicMapper.getTopicList(authorId);
        return TopicUtil.getTopicTimeWCount(topicList);
    }

    @Override
    public int delAuthorTopicListById(int authorId) {
        return topicMapper.delAuthorTopicList(authorId);
    }

    @Override
    public List<Topic> getAllTopic() {
        List<Topic> allTopic = topicMapper.getAllTopic();
        return TopicUtil.getTopicTimeWCount(allTopic);
    }

    @Override
    public int addTopic(Topic topic){
        return topicMapper.addTopic(topic);
    }

    @Override
    public int updateTopic(Topic topic) {
        return topicMapper.updateTopic(topic);
    }

    @Override
    public int delTopicById(int topicId){
        return topicMapper.delTopicById(topicId);
    }
}
