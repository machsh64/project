package com.ren.web20.mapper;

import com.ren.web20.pojo.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: web20sch1.2
 * @author: Ren
 * @create: 2022-12-15 22:30
 * @description:
 **/
@Mapper
public interface UserBasicMapper {

    /**
    * @Description: 用户登录
    * @Param: loginId,password
    * @Author: Ren
    * @return: Author
    * @Date: 2022/12/15 22:31
    */
    Author login(@Param("loginId") String loginId,@Param("password") String password);

    /**
    * @Description: 进行用户判断
    * @Param: author
    * @Author: Ren
    * @return: Author
    * @Date: 2022/12/15 22:32
    */
    Author finder(Author author);

    /**
    * @Description: 根据id获取用户
    * @Param: authorId
    * @Author: Ren
    * @return: Author
    * @Date: 2022/12/15 22:33
    */
    Author getAuthorById(@Param("authorId") Integer authorId);

    /**
    * @Description: 获取所有用户
    * @Param:
    * @Author: Ren
    * @return: List<Author>
    * @Date: 2022/12/15 22:34
    */
    List<Author> getAllUser();

    /**
    * @Description: 添加用户
    * @Param: author
    * @Author: Ren
    * @return:  Integer
    * @Date: 2022/12/15 22:34
    */
    Integer addUser(Author author);
}
