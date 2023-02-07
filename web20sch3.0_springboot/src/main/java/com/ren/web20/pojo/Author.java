package com.ren.web20.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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
public class Author {
    private int id;
    private String nickName;
    private String loginId;
    private String password;

    private List<Topic> topicList;

    /* 用于注册新作者的构造器 */
    public Author(String nickName, String loginId, String password) {
        this.nickName = nickName;
        this.loginId = loginId;
        this.password = password;
    }
}
