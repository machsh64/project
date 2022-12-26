package com.ren.web20.test;

import com.ren.myssm.util.SqlSessionUtil;
import com.ren.web20.mapper.TopicMapper;
import com.ren.web20.pojo.Topic;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: web20sch1.2
 * @author: Ren
 * @create: 2022-12-15 21:20
 * @description:
 **/
public class TopicMapperTest {

    @Test
    public void testGetTopicList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        List<Topic> allTopic = mapper.getTopicList(2);
        allTopic.forEach(System.out::println);
    }

    @Test
    public void testGetAllTopic() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        List<Topic> allTopic = mapper.getAllTopic();
        allTopic.forEach(System.out::println);
    }

    @Test
    public void testGetTopicById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        Topic topic = mapper.getTopicById(7);
        System.out.println(topic);
    }

    @Test
    public void testAddTopic() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Topic topic = new Topic("test", "test", "test", sdf.parse("2019-01-02"), "test", 1);
        Integer integer = mapper.addTopic(topic);
        System.out.println("num" + integer);
    }

    @Test
    public void testUpdateTopic() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Topic topic = new Topic(37,"testupdate", "test", "test", sdf.parse("2019-01-02"), "test", 1);
        Integer integer = mapper.updateTopic(topic);
        System.out.println("num" + integer);
    }

    @Test
    public void testDelTopicById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        Integer integer = mapper.delTopicById(37);
        System.out.println("num" + integer);
    }

    @Test
    public void testDelTopicByAuthorId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        Integer integer = mapper.delAuthorTopicList(1);
        System.out.println("num" + integer);
    }
}
