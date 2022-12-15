package com.ren.web20.mapper;

import com.ren.web20.pojo.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: web20sch1.2
 * @author: Ren
 * @create: 2022-12-15 21:19
 * @description:
 **/
public interface TopicMapper {

    /**
    * @Description: 根据作者Id获取所有专题
    * @Param: authorId
    * @Author: Ren
    * @return: List<Topic>
    * @Date: 2022/12/15 21:23
    */
    List<Topic> getTopicList(@Param("authorId") Integer authorId);

    /**
    * @Description: 获取所有的Topic
    * @Param:
    * @Author: Ren
    * @return: List<Topic>
    * @Date: 2022/12/15 21:58
    */
    List<Topic> getAllTopic();

    /**
    * @Description: 删除特定用户Id下所有专题
    * @Param: authorId
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/15 21:42
    */
    Integer delAuthorTopicList(@Param("authorId") int authorId);

    /**
    * @Description: 根据topicId获取Topic对象
    * @Param: topicId
    * @Author: Ren
    * @return: Topic
    * @Date: 2022/12/15 21:45
    */
    Topic getTopicById(@Param("topicId") int topicId);

    /**
    * @Description: 根据topicId删除专题
    * @Param: topicId
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/15 21:48
    */
    Integer delTopicById(@Param("topicId") int topicId);

    /**
    * @Description: 根据topic对象进行数据更新
    * @Param:  topic
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/15 21:50
    */
    Integer updateTopic(Topic topic);

    /**
    * @Description: 添加专题
    * @Param: topic
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/15 21:55
    */
    Integer addTopic(Topic topic);
}
