package com.ren.web20.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @program: WebCode
 * @author: Ren
 * @create: 2022-11-19 10:43
 * @description:
 **/
@ToString
@Data
public class Admin {
    private int id;
    private String nickName;
    private String loginId;
    private String password;

    private List<Topic> topicList;
    private List<Author> authorList;

    public int getId() {
        return id;
    }

}
