package com.ren.web20.test;

import com.ren.web20.mapper.UserBasicMapper;
import com.ren.web20.pojo.Author;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @program: web20sch1.2
 * @author: Ren
 * @create: 2022-12-15 22:42
 * @description:
 **/
public class UserBasicMapperTest {

/*    @Test
    public void testLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserBasicMapper mapper = sqlSession.getMapper(UserBasicMapper.class);
        Author author = mapper.login("w001", "ok");
        System.out.println(author);
    }

    @Test
    public void testFinder() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserBasicMapper mapper = sqlSession.getMapper(UserBasicMapper.class);
        Author author = mapper.finder(new Author("REN","w001","ok"));
        System.out.println(author);
    }

    @Test
    public void testGetAuthorById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserBasicMapper mapper = sqlSession.getMapper(UserBasicMapper.class);
        Author author = mapper.getAuthorById(1);
        System.out.println(author);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserBasicMapper mapper = sqlSession.getMapper(UserBasicMapper.class);
        List<Author> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserBasicMapper mapper = sqlSession.getMapper(UserBasicMapper.class);
        Integer integer = mapper.addUser(new Author("REN01","w004","ok"));
        System.out.println(integer);
    }*/
}
