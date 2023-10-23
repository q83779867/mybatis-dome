package com.leiou;

import com.leiou.mapper.UserMapper;
import com.leiou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * todo 代理开发
 */

public class MybatisDemo2 {



    public static void main(String[] args) throws IOException {
        //todo 加载mybatis的核心配置文件 获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//todo 获取sqlsession对象 用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
//todo 执行sql
       // List<Object> users = sqlSession.selectList("test.selectAll");
//todo 获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();


        System.out.println(users);

        sqlSession.close();
    }
}
