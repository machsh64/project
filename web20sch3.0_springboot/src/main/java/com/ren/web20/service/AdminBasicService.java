package com.ren.web20.service;

import com.ren.web20.pojo.Admin;

public interface AdminBasicService {
    /* 管理员登录 */
    Admin login(String loginId,String password);
    //根据用户id删除用户
    int delAuthorById(int authorId);
}
