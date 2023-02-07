package com.ren.web20.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @program: WebCode
 * @author: Ren
 * @create: 2022-11-19 10:43
 * @description:
 **/
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Topic {
    private int id;
    private String title;
    private String headLine;
    private String content;
    private Date topicDateTime;
    private String topicTime;
    private String publish;  //出版社
    private int count;  //topic的行数
    private int authorId;
    private Author author;

    /* 用于更新专题的构造器 */
    public Topic(int id,String title, String headLine, String content, Date topicDateTime,String publish, int authorId) {
        this.id = id;
        this.title = title;
        this.headLine = headLine;
        this.content = content;
        this.topicDateTime = topicDateTime;
        this.publish = publish;
        this.authorId = authorId;
    }

    /* 用于创建新专题的构造器 */
    public Topic(String title, String headLine, String content, Date topicDateTime,String publish, int authorId) {
        this.title = title;
        this.headLine = headLine;
        this.content = content;
        this.topicDateTime = topicDateTime;
        this.publish = publish;
        this.authorId = authorId;
    }
}
