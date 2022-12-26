package com.ren.web20.test;

import com.ren.myssm.util.SqlSessionUtil;
import com.ren.web20.mapper.AdminBasicMapper;
import com.ren.web20.pojo.Admin;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @program: web20sch1.2
 * @author: Ren
 * @create: 2022-12-15 22:25
 * @description:
 **/
public class AdminBasicMapperTest {

    @Test
    public void testADMINLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AdminBasicMapper mapper = sqlSession.getMapper(AdminBasicMapper.class);
        Admin admin = mapper.ADMINLogin("w001", "ok");
        System.out.println(admin);
    }

    @Test
    public void testDelAuthorById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AdminBasicMapper mapper = sqlSession.getMapper(AdminBasicMapper.class);
        Integer integer = mapper.delAuthorById(8);
        System.out.println("num" + integer);
    }
}
