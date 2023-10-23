package com.leiou;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *todo mybatis 快速入门代码
 */

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        //todo 加载mybatis的核心配置文件 获取 sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//todo 获取sqlsession对象 用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
//todo 执行sql
        List<Object> users = sqlSession.selectList("com.leiou.mapper.UserMapper.selectAll");

        System.out.println(users);
//todo 释放资源
        sqlSession.close();
    }
}
