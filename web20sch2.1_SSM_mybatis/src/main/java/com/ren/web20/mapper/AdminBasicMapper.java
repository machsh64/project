package com.ren.web20.mapper;

import com.ren.web20.pojo.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @program: web20sch1.2
 * @author: Ren
 * @create: 2022-12-15 22:18
 * @description:
 **/
public interface AdminBasicMapper {

    /**
    * @Description: 获取管理员账号密码进行登录
    * @Param: loginId,password
    * @Author: Ren
    * @return: Admin
    * @Date: 2022/12/15 22:20
    */
    Admin ADMINLogin(@Param("loginId") String loginId,@Param("password") String password);

    /**
    * @Description: 根据用户id删除用户
    * @Param: authorId
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/15 22:23
    */
    Integer delAuthorById(@Param("authorId") Integer authorId);

}
